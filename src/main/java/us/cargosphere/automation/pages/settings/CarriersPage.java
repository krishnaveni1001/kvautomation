package us.cargosphere.automation.pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

import us.cargosphere.automation.pages.BasePage;
import us.cargosphere.automation.pages.navigation.NavigationMenuBar;

public class CarriersPage extends BasePage{
	private NavigationMenuBar naviMenuBar;
    
    public NavigationMenuBar getNaviMenuBar() {
		return naviMenuBar;
	}
    
    
    @FindBy(how = How.ID, using = "addUserButton")
   	private WebElement addCarrierButton;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"uiSelectCarrier\"]/div[1]/div/div[1]/span")
   	private WebElement addScacCode;
 
    @FindBy(how = How.XPATH, using = "//*[@id=\"uiSelectCarrier\"]/div[1]/div/ul")
   	private WebElement seleScacCode;
    
    @FindBy(how = How.XPATH, using = "//*[@id=\"addACarrierModal\"]/div/div/div[2]/div[3]/div/input[4]")
   	private WebElement companyCode;
    
    @FindBy(how = How.ID, using = "contactName")
   	private WebElement contactName;
    
    @FindBy(how = How.ID, using = "emailAddress")
   	private WebElement emailAddress;
    
    @FindBy(how = How.ID, using = "cancelCarrier")
   	private WebElement cancelCarrierButton;
    
    @FindBy(how = How.ID, using = "saveCarrier")
   	private WebElement saveCarrierButton;
    
    
    public void SelectScacCode(String scode) {
		Select selScacCode = new Select(addScacCode);
		
		boolean userFound = false;
		for (WebElement userElement: selScacCode.getOptions()) {
			if (userElement.getText().equals(scode)) {
				userElement.click();
				userFound = true;
				break;
			}
		}
		
		if ( userFound == false ) {
			 System.out.println("Scac not found");
		}
	}
    
    public void ClickAddUser()  {
    	addCarrierButton.click();
    }
    
    public void EnterScacCode(String scode) {
    	addScacCode.click();
		
    	java.util.List<WebElement> listElem = seleScacCode.findElement(By.tagName("li")).findElements(By.className("ui-select-choices-row"));
    	for(WebElement element : listElem) {
    		String text = element.getText();
    		if(text.contains(scode)) {
    			element.click();
    			return;
    		}
    	}
    }

    public void EnterCompanyCode(String cName) throws InterruptedException {
    	companyCode.click();
    	companyCode.clear();
    	companyCode.sendKeys(cName);
    	companyCode.sendKeys(Keys.ENTER);
    }
    
    public void EnterContactName(String ctName) {
    	contactName.click();
    	contactName.clear();
    	contactName.sendKeys(ctName);
    	contactName.sendKeys(Keys.ENTER);
    }
    
    public void EnterEmail(String email) {
    	emailAddress.click();
    	emailAddress.clear();
    	emailAddress.sendKeys(email);
    	emailAddress.sendKeys(Keys.ENTER);
    }
    
    public boolean catchError() {
      	 if (webDriver.findElements(By.xpath("//*[@id=\"addACarrierModal\"]/div/div/div[2]/div[5]/div[2]")).size() > 0) {
               return true;
           }
           return false;
      }
    
    public void ClickSaveUser() {
    	saveCarrierButton.click();
    }
    
    public void ClickSaveUserWithPopup() throws InterruptedException {
    	saveCarrierButton.click();
    	webDriver.switchTo().alert().accept();
    }
    
    public boolean catchDupCarrierError() {
     	 if (webDriver.findElements(By.xpath("//*[@id=\"addACarrierModal\"]/div/div/div[1]/span")).size() > 0) {
              return true;
          }
          return false;
     }
    
    public void ClickCancelButton() {
    	cancelCarrierButton.click();
    }
    
    public boolean showsError() {
   	 if (webDriver.findElements(By.xpath("//*[@id=\"addACarrierModal\"]/div/div/div[1]")).size() > 0) {
            return true;
        }
        return false;
   }
    public CarriersPage(WebDriver webDriver) {
	        super(webDriver);
	        PageFactory.initElements(webDriver, this);
	        // Check that we are on the correct page.
	        if (!webDriver.getCurrentUrl().contains("ptrade/carriers/CarriersList.jsp")) {
	            throw new IllegalStateException("This is not carriers page. Currently on: " + webDriver.getCurrentUrl());
	        } 
	        naviMenuBar = new NavigationMenuBar(webDriver);
	    }


}
