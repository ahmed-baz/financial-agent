package com.ai.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "FINANCIAL_ANALYSIS")
@Entity
public class FinancialAnalysis {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "financial_analysis_seq_gen")
    @SequenceGenerator(
            name = "financial_analysis_seq_gen",
            sequenceName = "FINANCIAL_ANALYSIS_SEQ",
            allocationSize = 1
    )
    @Column(name = "ID")
    private Long id;

    // Company Information
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @Column(name = "COMPANY_SYMBOL")
    private String companySymbol;
    @Column(name = "COMPANY_SECTOR")
    private String companySector;
    @Column(name = "COMPANY_EXCHANGE")
    private String companyExchange;

    // Investment Summary
    @Column(name = "REPORTING_PERIOD")
    private String reportingPeriod;
    @Column(name = "CURRENCY")
    private String currency;
    @Column(name = "MARKET_CAP")
    private Double marketCap;
    @Column(name = "REVENUE")
    private Double revenue;
    @Column(name = "NET_INCOME")
    private Double netIncome;
    @Column(name = "OPERATING_CASH_FLOW")
    private Double operatingCashFlow;
    @Column(name = "FREE_CASH_FLOW")
    private Double freeCashFlow;
    @Column(name = "EPS")
    private Double eps;
    @Column(name = "ROE")
    private Double roe;
    @Column(name = "DEBT_TO_EQUITY")
    private Double debtToEquity;

    // LLM Analysis
    @Lob
    @Column(name = "EXECUTIVE_SUMMARY")
    private String executiveSummary;
    @Lob
    @Column(name = "INVESTMENT_THESIS")
    private String investmentThesis;
    @Lob
    @Column(name = "STRENGTHS")
    @Convert(converter = StringListConverter.class)
    private List<String> strengths;
    @Lob
    @Column(name = "RISKS")
    @Convert(converter = StringListConverter.class)
    private List<String> risks;
    @Lob
    @Column(name = "GROWTH_SIGNALS")
    @Convert(converter = StringListConverter.class)
    private List<String> growthSignals;
    @Lob
    @Column(name = "WARNING_SIGNALS")
    @Convert(converter = StringListConverter.class)
    private List<String> warningSignals;
    @Column(name = "INVESTMENT_OPINION")
    private String investmentOpinion;
    @Column(name = "CONFIDENCE_LEVEL")
    private Double confidenceLevel;

    // Metadata
    @Column(name = "UNIT")
    private String unit;
    @Column(name = "AUDITED")
    private Boolean audited;
    @Column(name = "SOURCE_LANGUAGE")
    private String sourceLanguage;
    @Column(name = "EXTRACTION_CONFIDENCE")
    private Double extractionConfidence;
}




