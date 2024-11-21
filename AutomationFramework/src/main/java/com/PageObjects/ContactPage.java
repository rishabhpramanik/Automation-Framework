package com.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ActionClass.ActionClass;
import com.BaseClass.BaseClass;

public class ContactPage extends BaseClass{
	ActionClass action = new ActionClass();
	
	@FindBy(id = "id_contact")
	WebElement subjectHeadingField;
	
	@FindBy(id = "email")
	WebElement emailField;
	
	@FindBy(id = "id_order")
	WebElement orderReferenceField;
	
	@FindBy(id = "fileUpload")
	WebElement chooseFileField;
	
	@FindBy(id = "submitMessage")
	WebElement sendButton;
	
	@FindBy(id = "message")
	WebElement messageField;
	
	@FindBy(xpath = "//p[@class='alert alert-success']")
	WebElement successMessage;
	
	@FindBy(xpath = "//div[@class='alert alert-danger']")
	WebElement errorMessage;
	
	public ContactPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void selectSubjectHeading(String subject) {
		action.selectByVisibleText(subjectHeadingField, subject);
	}
	
	public void setEmail(String email) {
		emailField.sendKeys(email);
	}
	
	public void setOrderReference(String ref) {
		orderReferenceField.sendKeys(ref);
	}
	
	public void attachFile(String fileLocation) {
		chooseFileField.sendKeys(fileLocation);
	}
	
	public void setMessage(String msg) {
		messageField.sendKeys(msg);
	}
	
	public void clickSend() {
		sendButton.click();
	}
	
	public String getMessage() {
		String msg = successMessage.getText();
		return msg;
	}
	
	public String getErrorMessage() {
		String msg = errorMessage.getText();
		return msg;
	}
	

	//Successful message - Your message has been successfully sent to our team.
	//Error message - The message cannot be blank.
	//Error messgae - Invalid email address.
	//Error message - Please select a subject from the list provided.
	//File location - E:\InvoiceFortesting.txt
}
