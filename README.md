# Web UI Test Automation Suite (web-automation-tests)

This is a Quality Assurance (QA) / SDET project demonstrating how to build a robust, maintainable test automation suite for a web application using industry-standard tools and design patterns.

This suite runs automated UI tests against the e-commerce demo website: **[https://www.saucedemo.com/](https://www.saucedemo.com/)**.

---

## 🚀 Key Features & Design Patterns

This project was built to demonstrate proficiency in modern QA automation practices:

* **Behavior-Driven Development (BDD):** Tests are written in Gherkin (a human-readable, natural language) using **Cucumber**. This allows technical and non-technical stakeholders to understand the test scenarios.
* **Page Object Model (POM):** The architecture follows the Page Object Model, the most important design pattern for UI automation. Each page of the application (`LoginPage`, `ProductsPage`, etc.) is a separate class, making the tests highly maintainable, reusable, and easy to debug.
* **Automatic Driver Management:** Uses **WebDriverManager** to automatically download and configure the correct version of `chromedriver`, eliminating the need to manually manage browser drivers.
* **Cucumber Hooks (`@Before` / `@After`):** Manages the browser lifecycle (setup and teardown) cleanly before and after each test scenario, ensuring tests run in an isolated and clean environment.

---

## 🛠️ Technology Stack

* **Java 17**
* **Maven** (Build and dependency management)
* **Selenium WebDriver** (The core library for browser automation)
* **Cucumber (BDD)** (For Gherkin `.feature` files and test execution)
* **JUnit 5** (The test runner platform)
* **WebDriverManager** (For automatic driver setup)

---

## 🚦 How to Run These Tests

### Prerequisites

* Java 17 (JDK)
* Apache Maven
* Google Chrome (installed)

### Running the Tests

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/lucas-ribeiro-silva/web-automation-tests.git](https://github.com/lucas-ribeiro-silva/web-automation-tests.git)
    cd web-automation-tests
    ```

2.  **Run via IntelliJ (Recommended):**
    * Open the project in IntelliJ.
    * Navigate to `src/test/java/com/lucasribeiro/webtests/`.
    * Open the `RunCucumberTest.java` file.
    * Click the green "Play" (▶️) icon next to the class name and select "Run 'RunCucumberTest'".

3.  **Run via Maven Terminal:**
    * Open a terminal in the project's root directory.
    * Execute the Maven test command:
        ```bash
        # (Windows)
        .\mvnw.cmd test
        
        # (Mac/Linux)
        ./mvnw test
        ```
    * A Chrome browser window will open, execute the test flow, and close automatically.

---

## 🔬 Test Scenario (`compra.feature`)

This suite automates the following end-to-end "happy path" scenario:

1.  **Given** the user is on the SauceDemo login page.
2.  **When** the user enters the username "standard_user".
3.  **And** the user enters the password "secret_sauce".
4.  **And** the user clicks the login button.
5.  **Then** the user is redirected to the "Products" page.
6.  **When** the user adds the "Sauce Labs Backpack" to the cart.
7.  **And** the user clicks the cart icon.
8.  **Then** the user sees the "Sauce Labs Backpack" on the cart page.

---

## 👨‍💻 Author

* **Lucas Ribeiro Silva**
* [LinkedIn](https://linkedin.com/in/dev-lucasribeirosilva)
* [GitHub](https://github.com/lucas-ribeiro-silva)