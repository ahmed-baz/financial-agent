package com.ai.app.mapper;

import com.ai.app.dto.FinancialAnalysisDto;
import com.ai.app.entity.FinancialAnalysis;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FinancialAnalysisMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "companyName", source = "company.name")
    @Mapping(target = "companySymbol", source = "company.symbol")
    @Mapping(target = "companySector", source = "company.sector")
    @Mapping(target = "companyExchange", source = "company.exchange")
    @Mapping(target = "reportingPeriod", source = "investmentSummary.reportingPeriod")
    @Mapping(target = "currency", source = "investmentSummary.currency")
    @Mapping(target = "marketCap", source = "investmentSummary.marketCap")
    @Mapping(target = "revenue", source = "investmentSummary.revenue")
    @Mapping(target = "netIncome", source = "investmentSummary.netIncome")
    @Mapping(target = "operatingCashFlow", source = "investmentSummary.operatingCashFlow")
    @Mapping(target = "freeCashFlow", source = "investmentSummary.freeCashFlow")
    @Mapping(target = "eps", source = "investmentSummary.eps")
    @Mapping(target = "roe", source = "investmentSummary.roe")
    @Mapping(target = "debtToEquity", source = "investmentSummary.debtToEquity")
    @Mapping(target = "executiveSummary", source = "llmAnalysis.executiveSummary")
    @Mapping(target = "investmentThesis", source = "llmAnalysis.investmentThesis")
    @Mapping(target = "strengths", source = "llmAnalysis.strengths")
    @Mapping(target = "risks", source = "llmAnalysis.risks")
    @Mapping(target = "growthSignals", source = "llmAnalysis.growthSignals")
    @Mapping(target = "warningSignals", source = "llmAnalysis.warningSignals")
    @Mapping(target = "investmentOpinion", source = "llmAnalysis.investmentOpinion")
    @Mapping(target = "confidenceLevel", source = "llmAnalysis.confidenceLevel")
    @Mapping(target = "unit", source = "metadata.unit")
    @Mapping(target = "audited", source = "metadata.audited")
    @Mapping(target = "sourceLanguage", source = "metadata.sourceLanguage")
    @Mapping(target = "extractionConfidence", source = "metadata.extractionConfidence")
    FinancialAnalysis toEntity(FinancialAnalysisDto dto);

    @Mapping(source = "companyName", target = "company.name")
    @Mapping(source = "companySymbol", target = "company.symbol")
    @Mapping(source = "companySector", target = "company.sector")
    @Mapping(source = "companyExchange", target = "company.exchange")
    @Mapping(source = "reportingPeriod", target = "investmentSummary.reportingPeriod")
    @Mapping(source = "currency", target = "investmentSummary.currency")
    @Mapping(source = "marketCap", target = "investmentSummary.marketCap")
    @Mapping(source = "revenue", target = "investmentSummary.revenue")
    @Mapping(source = "netIncome", target = "investmentSummary.netIncome")
    @Mapping(source = "operatingCashFlow", target = "investmentSummary.operatingCashFlow")
    @Mapping(source = "freeCashFlow", target = "investmentSummary.freeCashFlow")
    @Mapping(source = "eps", target = "investmentSummary.eps")
    @Mapping(source = "roe", target = "investmentSummary.roe")
    @Mapping(source = "debtToEquity", target = "investmentSummary.debtToEquity")
    @Mapping(source = "executiveSummary", target = "llmAnalysis.executiveSummary")
    @Mapping(source = "investmentThesis", target = "llmAnalysis.investmentThesis")
    @Mapping(source = "strengths", target = "llmAnalysis.strengths")
    @Mapping(source = "risks", target = "llmAnalysis.risks")
    @Mapping(source = "growthSignals", target = "llmAnalysis.growthSignals")
    @Mapping(source = "warningSignals", target = "llmAnalysis.warningSignals")
    @Mapping(source = "investmentOpinion", target = "llmAnalysis.investmentOpinion")
    @Mapping(source = "confidenceLevel", target = "llmAnalysis.confidenceLevel")
    @Mapping(source = "unit", target = "metadata.unit")
    @Mapping(source = "audited", target = "metadata.audited")
    @Mapping(source = "sourceLanguage", target = "metadata.sourceLanguage")
    @Mapping(source = "extractionConfidence", target = "metadata.extractionConfidence")
    FinancialAnalysisDto toDto(FinancialAnalysis entity);
}
