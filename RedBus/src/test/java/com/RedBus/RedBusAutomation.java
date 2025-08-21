package com.RedBus;

import com.google.common.util.concurrent.ListenableFuture;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class RedBusAutomation {
    public static  void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.redbus.in/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));

        WebElement from =
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,\"srcDestWrapper\") and @role=\"button\"])[1]")));
                from.click();

        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,\"searchSuggestionWrapper\")]")));
        WebElement textBox = driver.switchTo().activeElement();
        textBox.sendKeys("Delhi");

        Thread.sleep(4000);
        String journey = "Delhi Airport";

        List<WebElement> suggestions = driver.findElements(By.xpath("//div[contains(@class, 'listHeader')]"));
        for (WebElement suggest : suggestions){
            if (suggest.getText().equalsIgnoreCase(journey)){
                suggest.click();
                break;
            }

        }

        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,\"searchSuggestionWrapper\")]")));
        WebElement textBox2 = driver.switchTo().activeElement();
        textBox2.sendKeys("Mumbai");
        Thread.sleep(4000);
        String journey2 = "Mumbai";

        List<WebElement> suggestions2 = driver.findElements(By.xpath("//div[contains(@class, 'listHeader')]"));
        for (WebElement suggest : suggestions2){
            if (suggest.getText().equalsIgnoreCase(journey2)){
                suggest.click();
                break;
            }

        }

        WebElement searchBuses =
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'primaryButton___0dc9db searchButtonWrapper')]")));
                searchBuses.click();
        WebElement totalSize =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"busesFoundText__ind-search-styles-module-scss-PHVGD\"]")));
        System.out.println(totalSize.getText());

        By tupleWrapperLocator = By.xpath("//li[contains(@class, 'tupleWrapper')]");
        By busesNameLocator = By.xpath(".//div[contains(@class, 'travelsName')]");

        // Here we use JavascriptExecutor for end of the scroll
        JavascriptExecutor js = (JavascriptExecutor) driver;

        while (true) {
            List<WebElement> rowList = wait
                    .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(tupleWrapperLocator));
            List<WebElement> endOfList = driver.findElements(By.xpath("//span[contains(text(),'End of list')]"));

            if (!endOfList.isEmpty()) {
                break;
            }
            js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth'});", rowList.get(rowList.size() - 3));
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(tupleWrapperLocator, rowList.size()));
        }

        List<WebElement> rowList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(tupleWrapperLocator));
        for (WebElement row : rowList) {
            System.out.println(row.findElement(busesNameLocator).getText());
        }

    }
}
