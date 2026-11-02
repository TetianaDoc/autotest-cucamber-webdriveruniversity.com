# WebDriverUniversity Cucumber Test Suite

Automated UI test suite for [WebDriverUniversity](https://www.webdriveruniversity.com) built with **Java 21**, **Selenium WebDriver 4**, **Cucumber 7**, **TestNG**, and **Maven**.

## Running Tests

Run all regression scenarios:
```bash
mvn test
```

Run in headless mode or with a specific browser (`chrome` or `firefox`):
```bash
mvn test -DbrowserType=chrome -Dheadless=true
```

Run specific Cucumber tags:
```bash
mvn test -Dcucumber.filter.tags="@dropdown-menu"
```

## GitHub Actions CI (One-Click Execution)

Tests are configured to run via [GitHub Actions](.github/workflows/ci.yml):
- **Automatically** on every `push` and `pull_request` targeting `main`.
- **Manually in one click** from the GitHub UI:
  1. Go to the **Actions** tab in the GitHub repository.
  2. Select **Run Automated UI Tests** from the left sidebar.
  3. Click **Run workflow** (optionally choose the browser `chrome`/`firefox` or custom Cucumber tags) and click the green **Run workflow** button.
  4. Once finished, download the `cucumber-test-reports-*` artifact from the workflow summary page to view `cucumber_rep.html`.


