package com.ai.app.repository;

import com.ai.app.entity.FinancialAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinancialAnalysisRepository extends JpaRepository<FinancialAnalysis, Long> {
    List<FinancialAnalysis> findByCompanySymbol(String companySymbol);
}
