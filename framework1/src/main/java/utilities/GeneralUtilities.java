package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public String getSelectedValueFromDropDown(WebElement element, String valueToSelect) {
		Select select = new Select(element);
		select.selectByValue(valueToSelect);
		WebElement selectedTitle = select.getFirstSelectedOption();
		String text = selectedTitle.getText();
		return text;
	}

	public Boolean checkBoxSelection(WebElement element) {
		Boolean checkBoxSelected = element.isSelected();
		return checkBoxSelected;
	}

	public String getStyleProperties(WebElement element, String stylePropertyValue) {
		String fontSize = element.getCssValue(stylePropertyValue);
		return fontSize;
	}

	public String toolTip(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		return element.getAttribute("title");
	}

	public String getAlertMessage(WebDriver driver, Boolean accept) {
		String alertText = driver.switchTo().alert().getText();
		if (accept) {
			driver.switchTo().alert().accept();
		} else {
			driver.switchTo().alert().dismiss();
		}
		return alertText;
	}

	public int getTableValueDynamically(List<WebElement> columnElement, String comparingString) { //find index value in a table column that matches a specific string
		int j = 0;

		for (int i = 0; i < columnElement.size(); i++) {
			if (columnElement.get(i).getText().equals(comparingString)) {
				j = i + 1;  //return the 1-based index
				break;
			}

		}
		return j;    //index of matching element
	}

	public boolean isTableFilteringWorkingProperly(List<WebElement> columnValue, String comparingValue) {  //to check if a given value exists in the list of column values
		Boolean value = false;

		for (int i = 0; i < columnValue.size(); i++) {
			if (columnValue.get(i).getText().equals(comparingValue)) {
				value = true;
			}
		}
		return value;
	}

}
