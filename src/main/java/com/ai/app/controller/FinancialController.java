package com.ai.app.controller;

import com.ai.app.dto.FinancialAnalysisDto;
import com.ai.app.service.FinancialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/financial-analysis")
@RequiredArgsConstructor
public class FinancialController {

    private final FinancialService service;

    @PostMapping("/analyze")
    public void uploadFinancialReport(@RequestParam("report") MultipartFile file) {
        service.uploadFinancialReport(file);
    }

    @GetMapping("/filter/{symbol}")
    public ResponseEntity<List<FinancialAnalysisDto>> getFinancialAnalysisBySymbol(@PathVariable String symbol) {
        return ResponseEntity.ok(service.getFinancialAnalysisBySymbol(symbol));
    }
}
