package com.ai.app.service;

import com.ai.app.dto.FinancialAnalysisDto;
import com.ai.app.entity.FinancialAnalysis;
import com.ai.app.mapper.FinancialAnalysisMapper;
import com.ai.app.repository.FinancialAnalysisRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeType;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FinancialService {

    private final FinancialAnalysisRepository repository;
    private final FinancialAnalysisMapper mapper;
    private final ChatClient chatClient;
    private final String systemMessage;
    private final String userMessage;

    public FinancialService(FinancialAnalysisRepository repository,
                            FinancialAnalysisMapper mapper,
                            OpenAiChatModel chatModel,
                            @Value("classpath:prompts/system_msg.txt") Resource systemMessage,
                            @Value("classpath:prompts/user_msg.txt") Resource userMessage) throws IOException {
        this.repository = repository;
        this.mapper = mapper;
        this.chatClient = ChatClient.builder(chatModel).build();
        this.systemMessage = systemMessage.getContentAsString(StandardCharsets.UTF_8);
        this.userMessage = userMessage.getContentAsString(StandardCharsets.UTF_8);
    }

    public FinancialAnalysisDto saveFinancialAnalysis(FinancialAnalysisDto dto) {
        FinancialAnalysis entity = mapper.toEntity(dto);
        FinancialAnalysis savedEntity = repository.save(entity);
        return mapper.toDto(savedEntity);
    }

    @Cacheable(value = "financialAnalysisBySymbol", key = "#symbol")
    public List<FinancialAnalysisDto> getFinancialAnalysisBySymbol(String symbol) {
        return repository.findByCompanySymbol(symbol).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    private ByteArrayResource getFileResource(MultipartFile file) {
        try {
            return new ByteArrayResource(file.getBytes());
        } catch (Exception e) {
            log.error("Error with the file", e);
            throw new RuntimeException("Error with the file", e);
        }
    }

    @Async
    public void uploadFinancialReport(MultipartFile file) {
        MimeType mimeType = MimeType.valueOf(Objects.requireNonNull(file.getContentType()));
        var content = chatClient.prompt()
                .system(systemMessage)
                .user(u -> u.text(userMessage).media(mimeType, getFileResource(file)))
                .call()
                .content();

        BeanOutputConverter<FinancialAnalysisDto> outputConverter = new BeanOutputConverter<>(FinancialAnalysisDto.class);
        assert content != null;
        FinancialAnalysisDto dto = outputConverter.convert(content);
        saveFinancialAnalysis(dto);
    }
}
