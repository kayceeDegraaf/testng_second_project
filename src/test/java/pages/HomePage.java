package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "div[role='tablist']>a")
    public List<WebElement> mainMenuNavigation;

    @FindBy(xpath = "//li[@name='travelTab']/../li")
    public List<WebElement> travelMenu;

    @FindBy (xpath = "(//span[contains(@class,'checkmark--2DHJD')])[1]")
    public WebElement roundTripRadioButton;

    @FindBy (xpath = "(//span[contains(@class,'checkmark--2DHJD')])[2]")
    public WebElement oneWayRadioButton;

    @FindBy(css = "label[for='award']")
    public WebElement bookWithMilesCheckBox;

    @FindBy(css = "label[for='flexibleDates']")
    public WebElement flexibleDatesCheckBox;

    @FindBy(id = "bookFlightOriginInput")
    public WebElement departureInputBox;

    @FindBy(id = "bookFlightDestinationInput")
    public WebElement arrivalInputBox;

    @FindBy(id = "DepartDate")
    public WebElement departureDateBox;

    @FindBy (css = "div[id=passengerSelector]>button")
    public WebElement travelerSelectorBox;

    @FindBy(css = "button[aria-label='Substract one Adult']")
    public WebElement additionalAdultOption;

    @FindBy (id = "cabinType")
    public WebElement cabinTypeBox;

    @FindBy(css = "ul[role='listbox']>li")
    public List<WebElement> cabinDropdown;

    @FindBy (css = "button[class='atm-c-btn atm-c-btn--bare']")
    public WebElement closeButton;

    @FindBy(css = "button[aria-label='Find flights']")
    public WebElement findFlightsButton;




}
