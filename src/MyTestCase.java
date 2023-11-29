package loginProcess;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class MyTestCase extends Parameters {

	@BeforeTest
	public void Setup() {

		driver.manage().window().maximize();
		driver.get(MyURL);

	}

  @Test()
	public void mytestcase() {

		WebElement userNameInput = driver.findElement(By.id("user-name"));

		WebElement passwordInput = driver.findElement(By.id("password"));

		WebElement loginButton = driver.findElement(By.id("login-button")); 

		userNameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		loginButton.click();

    List < WebElement >itemsNames = driver. findElements(By. className( "inventory_item_name") ) ;
		
		List<WebElement> itemsPrices = driver.findElements(By.className("inventory_item_price"));
		
		List<WebElement> myElements = driver.findElements(By.className("btn_primary"));

    for (WebElement element : myElements) {
    int index = myElements.indexOf(element);
    String itemName = itemsNames.get(index).getText();
    String originalPrice = itemsPrices.get(index).getText();
    double priceBeforeTax = Double.parseDouble(originalPrice.replace("$", ""));
    double finalPrice = priceBeforeTax * 0.10;

    if (itemName.contains("Backpack") || itemName.contains("Fleece") || itemName.contains("Onesie")) {
        System.out.println("This item " + itemName + " was not added, and the original price of this item is "
                + itemsPrices.get(index).getText());
        continue;
    } else {
        element.click();
        System.out.println("This item " + itemName + " was added, and the price of this item is "
                + itemsPrices.get(index).getText());
    }

    if (Math.floor(finalPrice) % 2 == 0) {
        System.out.println("The final price for " + itemName + " is an even number, and the value is: " + finalPrice);
    } else {
        System.out.println("The final price for " + itemName + " is an odd number, and the value is: " + finalPrice);
    }
}

Check.assertAll();

  }   } 
  
    
	@AfterTest
	public void posttest() {
	}

} 
		
