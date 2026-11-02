@regression @dropdown-menu

Feature: WebDriver University - Dropdown Menu, Checkbox and Radio Buttons

  Background:
    Given Go to Dropdown Menu, Checkbox and Radio Buttons page

  Scenario Outline: Validate Dropdown Menu
    When I click on dropdown <menu>
    And I select option <value>
    Then The selected option <text> displayed
    Examples:
      | menu            | value      | text       |
      | dropdowm-menu-1 | java       | JAVA       |
      | dropdowm-menu-1 | c#         | C#         |
      | dropdowm-menu-1 | python     | Python     |
      | dropdowm-menu-1 | sql        | SQL        |
      | dropdowm-menu-2 | eclipse    | Eclipse    |
      | dropdowm-menu-2 | maven      | Maven      |
      | dropdowm-menu-2 | testng     | TestNG     |
      | dropdowm-menu-2 | junit      | JUnit      |
      | dropdowm-menu-3 | html       | HTML       |
      | dropdowm-menu-3 | css        | CSS        |
      | dropdowm-menu-3 | javascript | JavaScript |
      | dropdowm-menu-3 | jquery     | JQuery     |

  Scenario Outline: Validate Checkboxes
    When I click on checkbox <checkbox>
    Then The checkbox <checkbox> selected state should be <expectedState>
    Examples:
      | checkbox | expectedState |
      | option-1 | true          |
      | option-2 | true          |
      | option-3 | false         |
      | option-4 | true          |

  Scenario Outline: Validate Radio Buttons
    When I select radio button <color>
    Then The radio button <color> is selected
    Examples:
      | color  |
      | green  |
      | blue   |
      | yellow |
      | orange |
      | purple |
