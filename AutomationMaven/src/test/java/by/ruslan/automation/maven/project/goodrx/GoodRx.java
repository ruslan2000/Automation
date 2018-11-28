package by.ruslan.automation.maven.project.goodrx;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import by.ruslan.automation.maven.entity.App;

public class GoodRx extends App {

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

	@FindBy(id = "com.goodrx:id/textview_embeddedcoupon_price")
	WebElement couponPrice;
	
	@FindBy(id = "com.goodrx:id/textview_pricewithcoupon_default_price")
	WebElement couponDefaultPrice;
	
	@FindBy(id = "com.goodrx:id/textview_membership_price")
	WebElement membersPrice;
	
	@FindBy(id = "com.goodrx:id/textview_pricewithcoupon_cash_price")
	WebElement cashPrice;
	
	public GoodRx() {
		super("com.goodrx", "com.goodrx.activity.WelcomeActivity");

	}

	public void xClick() {
		if (xClick != null && xClick.isDisplayed()) {
			xClick.click();
		}
	}

	public void searchField(String text) {
		editText.sendKeys(text);
	}

	public void clearSearchField() {
		editText.clear();
	}

	public void clickSearchBttn() {
		searchBttn.click();
	}

	private List<WebElement> searchResult() {
		List<WebElement> list = searchResult.findElements(By.id("textview"));
		return list;
	}

	public void searchResultClickElement(int index) {
		List<WebElement> list = searchResult();
		WebElement drug = list.get(index);
		System.out.println(drug.getText());
		drug.click();
	}

	public void findPrice() {
		buttonFindPrice.click();
	}

	private List<WebElement> priceList() {
		List<WebElement> list = viewPrice.findElements((By.id("layout_priceitem_price")));
		return list;
	}

	public WebElement showPrice(int index) {
		List<WebElement> list = priceList();
		WebElement price = list.get(index).findElement(By.id("textview_priceitem_price"));
		System.out.println(price.getText());
		WebElement priceType = list.get(index).findElement(By.id("textview_priceitem_type"));
		
		return priceType;
	}

	public void couponPrice() {
		if (couponPrice != null) {
			System.out.println(couponPrice.getText());
		}
	}
	
	public void membersPrice() {
		System.out.println("Membership price: " + membersPrice.getText());
		System.out.println("Coupon price: " + couponDefaultPrice.getText());
	}
	
	public void cashPrice() {
		System.out.println("Cash price: " + cashPrice.getText());
		System.out.println("Coupon price: " + couponDefaultPrice.getText());
	}

}
