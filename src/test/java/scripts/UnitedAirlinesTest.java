package scripts;

import org.openqa.selenium.Keys;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;


public class UnitedAirlinesTest extends Base{
    @Test(priority = 1, description = "TC 001: Validate Main menu navigation items")
    public void validateMainMenuItems(){
        driver.get("https://www.united.com/en/us");

        //array of menu items
        String[] mainMenuItems = {"BOOK", "MY TRIPS", "TRAVEL INFO", "MILEAGEPLUS® PROGRAM", "DEALS", "HELP"};

        //is displayed, enabled, and correct text
        for (int i = 0; i < homePage.mainMenuNavigation.size(); i++) {
            Assert.assertTrue(homePage.mainMenuNavigation.get(i).isDisplayed());
            Assert.assertTrue(homePage.mainMenuNavigation.get(i).isEnabled());
            Assert.assertEquals(homePage.mainMenuNavigation.get(i).getText(), mainMenuItems[i]);

        }
    }

    @Test(priority = 2, description = "TC 002: Validate 'Book travel menu' navigation items")
    public void validateBookTravelMenu(){
        driver.get("https://www.united.com/en/us");

        //array of menu items
        String[] bookTravel = {"Book", "Flight status", "Check-in", "My trips"};


        //is displayed and is correct text
        for (int i = 0; i < homePage.travelMenu.size(); i++) {
            Assert.assertTrue(homePage.travelMenu.get(i).isDisplayed());
            Assert.assertEquals(homePage.travelMenu.get(i).getText(), bookTravel[i]);

        }
    }
    @Test(priority = 3, description = "TC 003: Validate 'Round-trip' and 'One-way' radio buttons" )
    public void validateFlightRadioButtons(){
        driver.get("https://www.united.com/en/us");

        //round trip
        Assert.assertTrue(homePage.roundTripRadioButton.isDisplayed());
        Assert.assertTrue(homePage.roundTripRadioButton.isEnabled());
        Assert.assertTrue(homePage.roundTripRadioButton.isSelected());
        Waiter.pause(2);

        //one way
        Assert.assertTrue(homePage.oneWayRadioButton.isDisplayed());
        Assert.assertTrue(homePage.oneWayRadioButton.isEnabled());
        Assert.assertFalse(homePage.oneWayRadioButton.isSelected());
        Waiter.pause(2);

        //select one way
        homePage.oneWayRadioButton.click();
        Assert.assertFalse(homePage.roundTripRadioButton.isSelected());
        Assert.assertTrue(homePage.oneWayRadioButton.isSelected());
        Waiter.pause(2);

    }
    @Test(priority = 4, description = "TC 004: Validate 'Book with miles' and 'Flexible dates' checkboxes")
    public void validateBookingCheckBoxes() {
        driver.get("https://www.united.com/en/us");

        //book with miles validation
        Assert.assertTrue(homePage.bookWithMilesCheckBox.isDisplayed());
        Assert.assertTrue(homePage.bookWithMilesCheckBox.isEnabled());
        Assert.assertFalse(homePage.bookWithMilesCheckBox.isSelected());

        //flexible dates validation
        Assert.assertTrue(homePage.flexibleDatesCheckBox.isDisplayed());
        Assert.assertTrue(homePage.flexibleDatesCheckBox.isEnabled());
        Assert.assertFalse(homePage.flexibleDatesCheckBox.isSelected());

        //validate click for book with miles
        homePage.bookWithMilesCheckBox.click();
        Assert.assertTrue(homePage.bookWithMilesCheckBox.isSelected());

        //validate click for flexible dates
        homePage.flexibleDatesCheckBox.click();
        Assert.assertTrue(homePage.flexibleDatesCheckBox.isSelected());

        //book with miles deselected
        homePage.bookWithMilesCheckBox.click();
        Assert.assertFalse(homePage.bookWithMilesCheckBox.isSelected());

        //flexible dates deselected
        homePage.flexibleDatesCheckBox.click();
        Assert.assertFalse(homePage.flexibleDatesCheckBox.isSelected());

    }
    @Test(priority = 5, description = "TC 005: Validate One-way ticket search results 'from Chicago, IL, US (ORD) to Miami, FL, US (MIA)'")
    public void validateOneWayTicketSearchResults(){
        driver.get("https://www.united.com/en/us");

        homePage.oneWayRadioButton.click();


        //enter one way flight search information
        homePage.departureInputBox.clear();
        homePage.departureInputBox.sendKeys("Chicago, IL, US (ORD)" + Keys.ENTER);
        homePage.arrivalInputBox.clear();
        homePage.arrivalInputBox.sendKeys("Miami, FL, US (MIA)" + Keys.ENTER);
        homePage.departureDateBox.clear();
        homePage.departureDateBox.click();
        homePage.departureDateBox.sendKeys("Jan 30" + Keys.ENTER);
        Waiter.pause(2);

        homePage.travelerSelectorBox.click();
        homePage.additionalAdultOption.click();
        homePage.closeButton.click();
        homePage.cabinTypeBox.click();
        homePage.cabinDropdown.get(2).click();

        homePage.findFlightsButton.click();
        Assert.assertEquals(departurePage.departure.getText(), "Chicago, IL, US to Miami, FL, US");

    }

}
