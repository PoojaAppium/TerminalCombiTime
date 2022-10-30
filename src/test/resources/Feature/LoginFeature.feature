Feature: Login Feature

  Scenario Outline: Login using valid credentials
    Given Chrome Launch
    When Navigate to URL "https://combitimedevapp.z16.web.core.windows.net/login"
    And Choose Terminal in Select Login type dropdown
    And Click on Continue
    And Move in new tab
    Then Validate Page Title "CombiTime"
    When Login By Email as "<EmailID>"
    And Login By Password as "<Password>"
    And Click on Submit button
    Then Validate Page Title "Terminal"
    When Fill Resource ID "<ResourceID>"
    And Click On Submit Icon
    Then Validate Page Header "My registrations"
    And Quit Window

    Examples: 
      | EmailID    |  | Password |  | ResourceID |
      | 6239194-28 |  |    12345 |  |        012 |

  Scenario Outline: Login using Invalid ResourceID
    Given Chrome Launch
    When Navigate to URL "https://combitimedevapp.z16.web.core.windows.net/login"
    And Choose Terminal in Select Login type dropdown
    And Click on Continue
    And Move in new tab
    Then Validate Page Title "CombiTime"
    When Login By Email as "<EmailID>"
    And Login By Password as "<Password>"
    And Click on Submit button
    Then Validate Page Title "Terminal"
    When Fill Resource ID "<ResourceID>"
    And Click On Submit Icon
    Then Validate Toast Message "Invalid username or password, please try again."
    And Quit Window

    Examples: 
      | EmailID    |  | Password |  | ResourceID |
      | 6239194-28 |  |    12345 |  |        876 |

  @tag1
  Scenario Outline: Login using Invalid TerminalID
    Given Chrome Launch
    When Navigate to URL "https://combitimedevapp.z16.web.core.windows.net/login"
    And Choose Terminal in Select Login type dropdown
    And Click on Continue
    And Move in new tab
    Then Validate Page Title "CombiTime"
    When Login By Email as "<EmailID>"
    And Login By Password as "<Password>"
    And Click on Submit button
    Then Validate Error Message in TerminalID "Invalid username or password"
    And Quit Window

    Examples: 
      | EmailID    |  | Password |
      | 6239194-10 |  |    12345 |

  @tag1
  Scenario Outline: Login using NonExisting TerminalID
    Given Chrome Launch
    When Navigate to URL "https://combitimedevapp.z16.web.core.windows.net/login"
    And Choose Terminal in Select Login type dropdown
    And Click on Continue
    And Move in new tab
    Then Validate Page Title "CombiTime"
    When Login By Email as "<EmailID>"
    And Login By Password as "<Password>"
    And Click on Submit button
    Then Validate Error Message in TerminalID "Terminal app not found"
    And Quit Window

    Examples: 
      | EmailID      |  | Password |
      | 623916594-10 |  |    12345 |

  @tag1
  Scenario Outline: Login using Invalid Password
    Given Chrome Launch
    When Navigate to URL "https://combitimedevapp.z16.web.core.windows.net/login"
    And Choose Terminal in Select Login type dropdown
    And Click on Continue
    And Move in new tab
    Then Validate Page Title "CombiTime"
    When Login By Email as "<EmailID>"
    And Login By Password as "<Password>"
    And Click on Submit button
    Then Validate Error Message in Password "Password is Required"
    And Quit Window

    Examples: 
      | EmailID      |  | Password |
      | 623916594-10 |  |          |

  Scenario Outline: Login using Empty ID & Password
    Given Chrome Launch
    When Navigate to URL "https://combitimedevapp.z16.web.core.windows.net/login"
    And Choose Terminal in Select Login type dropdown
    And Click on Continue
    And Move in new tab
    Then Validate Page Title "CombiTime"
    When Login By Email as "<EmailID>"
    And Login By Password as "<Password>"
    And Click on Submit button
    Then Validate Error Message in Email_Required "Email is Required"
    Then Validate Error Message in Password "Password is Required"
    And Quit Window

    Examples: 
      | EmailID |  | Password |
      |         |  |          |
