# Red-Bus-Automation
Red Bus Automation
🚍 RedBus Automation (Selenium + Java)

This project automates the process of searching buses on RedBus
 using Selenium WebDriver with Java.

📌 What the Script Does

Launch Browser

Opens Chrome browser and navigates to redbus.in
.

Maximizes the window.

Enter "From" City (Source)

Clicks on the From field.

Types Delhi.

Selects Delhi Airport from the suggestions.

Enter "To" City (Destination)

Clicks on the To field.

Types Mumbai.

Selects Mumbai from the suggestions.

Search for Buses

Clicks on the Search Buses button.

Waits until the results page is loaded.

Prints the total buses found.

Scroll Through Bus List

Uses JavaScript scrolling to load more buses until the “End of list” message is reached.

Extract Bus Names

Collects all the bus names displayed on the page.

Prints them in the console.

🛠️ Tools & Dependencies

Java 17+ (or compatible version)

Selenium WebDriver

ChromeDriver (make sure it matches your Chrome version)

Maven/Gradle (optional, for dependency management)
