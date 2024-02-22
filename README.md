## Automated AAC Moodle Course Access and Logout

This project automates logging into the AAC Moodle platform, accessing a specific course based on user selection, and then logging out from both AAC portal and Moodle.

**Features:**

* Prompts user for username and password.
* Opens AAC portal and navigates to the login page.
* Logs in to AAC portal using provided credentials.
* Redirects to Moodle login page.
* Waits for courses to load and displays a list of available courses.
* Asks user to choose the desired course by number.
* Clicks on the selected course to access it.
* Opens the user menu and clicks on the logout option.
* Waits for 3 seconds for Moodle logout confirmation.
* Clicks on the final logout button on the AAC portal.
* Closes the browser window.

**Technology:**

* Java
* Selenium WebDriver
* ChromeDriver
