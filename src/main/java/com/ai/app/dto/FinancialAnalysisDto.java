package com.ai.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FinancialAnalysisDto {

    private CompanyDto company;
    private InvestmentSummaryDto investmentSummary;
    private LlmAnalysisDto llmAnalysis;
    private MetadataDto metadata;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CompanyDto {
        private String name;
        private String symbol;
        private String sector;
        private String exchange;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InvestmentSummaryDto {
        private String reportingPeriod;
        private String currency;
        private Double marketCap;
        private Double revenue;
        private Double netIncome;
        private Double operatingCashFlow;
        private Double freeCashFlow;
        private Double eps;
        private Double roe;
        private Double debtToEquity;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LlmAnalysisDto {
        private String executiveSummary;
        private String investmentThesis;
        private List<String> strengths;
        private List<String> risks;
        private List<String> growthSignals;
        private List<String> warningSignals;
        private String investmentOpinion;
        private Double confidenceLevel;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MetadataDto {
        private String unit;
        private Boolean audited;
        private String sourceLanguage;
        private Double extractionConfidence;
    }
}
