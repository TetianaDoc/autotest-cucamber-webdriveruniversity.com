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

