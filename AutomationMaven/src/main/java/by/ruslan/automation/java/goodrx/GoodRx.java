package by.ruslan.automation.java.goodrx;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import by.ruslan.automation.java.entity.App;

public class GoodRx extends App{
	@FindBy(id = "imageview_close")
	WebElement xClick;
	
	@FindBy(id = "edittext")
	WebElement editText;

	@FindBy(id = "action_search")
	WebElement searchBttn;
	
	@FindBy(id = "recyclerview_search_result")
	WebElement searchResult;
	
	@FindBy(id = "recyclerview_price")
	WebElement viewPrice;
	
	@FindBy(id = "button_price_configure")
	WebElement buttonFindPrice;
	

	public GoodRx() {
	 	super("com.goodrx", "com.goodrx.activity.WelcomeActivity");

	}

	
	public void xClick() {
		if (xClick != null && xClick.isDisplayed()) {
			xClick.click();
		}
	}
	
	public void searchField(String text){
		editText.sendKeys(text);
	}
	
	public void clearSearchField() {
		editText.clear();
	}
	
	public void clickSearchBttn() {
		searchBttn.click();
	}
	
	private List<WebElement> searchResult(){
		List<WebElement> list = searchResult.findElements(By.id("textview"));
		return list;
	}
	
	public void searchResultClickElement(int index) {
		List<WebElement> list = searchResult();
		list.get(index).click();
	}
	
	public void findPrice() {
		buttonFindPrice.click();
	}
	
	private List<WebElement> priceList(){
		List<WebElement> list = viewPrice.findElements((By.id("layout_priceitem_price")));
		return list;
	}
	
	public void showPrice(int index){
		List<WebElement> list = priceList();
		String price = (list.get(index).findElement(By.id("textview_priceitem_price"))).getText();	
		System.out.println(price);
	}

	

}
