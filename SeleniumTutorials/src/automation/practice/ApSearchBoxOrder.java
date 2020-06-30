package automation.practice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApSearchBoxOrder extends BaseClass {
	@FindBy(id = "search_query_top")
	private WebElement searchQuery;

	@FindBy(name = "submit_search")
	private WebElement submitSearch;

	@FindBy(xpath = "(//a[contains(text(),'Blouse') and @title='Blouse'])[2]")
	private WebElement selectedProduct;

	public WebElement getSearchQuery() {
		return searchQuery;
	}

	public WebElement getSubmitSearch() {
		return submitSearch;
	}

	public WebElement getSelectedProduct() {
		return selectedProduct;
	}

	ApSearchBoxOrder() {
		PageFactory.initElements(driver, this);
	}

}
