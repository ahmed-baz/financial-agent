# Financial Agent

Financial Agent is a Spring Boot application that leverages AI to analyze financial reports and provide investment insights. By using Large Language Models (LLM), it extracts key financial metrics and generates comprehensive analysis including strengths, risks, and investment opinions.

## Business Overview

The application is designed to automate the process of reading complex financial reports (e.g., quarterly earnings, annual reports). It helps investors and analysts by:
- Automatically extracting company details and core financial metrics (Revenue, Net Income, EPS, etc.).
- Providing AI-driven qualitative analysis of the company's performance.
- Generating investment signals (Growth vs. Warning) based on the report data.
- Storing and indexing analysis for quick retrieval and comparison.

## Technologies Used

*   **Java 17**
*   **Spring Boot 3.x**
*   **Spring AI**: Orchestrates the interaction with AI models.
*   **OpenAI (GPT-4o-mini)**: Used for processing and analyzing report content.
*   **Oracle Database**: For persistent storage of financial analysis results.
*   **MapStruct**: For efficient DTO-to-Entity mapping.
*   **Lombok**: To reduce boilerplate code.
*   **Maven**: Dependency management and build tool.

## Key Features

1.  **AI Financial Report Analysis**: Upload a financial report (PDF, Image) and get a structured analysis.
2.  **Metric Extraction**: Automated extraction of Market Cap, Revenue, Net Income, EPS, ROE, Debt-to-Equity, and more.
3.  **Investment Insights**: Generates an executive summary, investment thesis, strengths, risks, and an overall investment opinion.
4.  **Symbol Filtering**: Quickly retrieve previous analyses for specific companies using their stock symbols.
5.  **Caching**: Integrated caching for fast retrieval of previously analyzed data.

## API Endpoints

### Financial Analysis

*   **`POST /api/financial-analysis/analyze`**: Upload a financial report for AI processing.
    *   **Request**: `MultipartFile` with key `report`.
    *   **Process**: The system sends the report to the LLM, parses the response, and saves the analysis to the database.
*   **`GET /api/financial-analysis/filter/{symbol}`**: Retrieve all stored analyses for a specific company symbol.
    *   **Example**: `GET http://localhost:8080/api/financial-analysis/filter/AAPL`

## How to Run the Application

1.  **Prerequisites:**
    *   Java 17 or higher.
    *   An Oracle Database instance.
    *   An OpenAI API Key (configured in `application-dev.yml`).

2.  **Configuration:**
    *   Update `src/main/resources/application-dev.yml` with your database credentials and OpenAI API key.

3.  **Build and Run:**
    You can run the application using Maven:
    ```bash
    mvn spring-boot:run
    ```
    The application will start on port `8080` (default dev profile).
