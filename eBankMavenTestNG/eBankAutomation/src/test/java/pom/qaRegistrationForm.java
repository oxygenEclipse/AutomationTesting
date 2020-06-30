package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseClass.BaseClass;

public class qaRegistrationForm extends BaseClass {

	@FindBy(name ="firstname")
	private WebElement firstName;
	
	@FindBy(id="lastname")
	private WebElement lastName;
	
	@FindBy(id="sex-1")
	private WebElement gender;
	
	@FindBy(id="exp-1")
	private WebElement exp;
	
	@FindBy(id="datepicker")
	private WebElement date;
	
	@FindBy(id="profession-1")
	private WebElement profession;
	
	@FindBy(id="photo")
	private WebElement upload;
	
	@FindBy(xpath="//a[text()='Test File to Download']")
	private WebElement download;
	
	@FindBy(id="tool-2")
	private WebElement tools;
	
	@FindBy(id="continents")
	private WebElement continents;
	
	@FindBy(id="continentsmultiple")
	private WebElement multipleCont;
	
	

}
