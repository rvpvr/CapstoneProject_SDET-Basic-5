package myWordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewClass1 {
	WebDriver driver;
	By ele=By.xpath("//*[@id='modal-1-content']/ul/li[4]/button");
	By ele1=By.xpath("/html/body/div/header/div/a");
	By ele2=By.xpath("//*[@id=\\\"wp--skip-link--target\\");
	By eleGettingString=By.xpath("//*[@id='wp--skip-link--target']/div[1]/h1");
	By ele3=By.xpath("//*[@id='modal-1-content']/ul/li[6]/button");
	By ele4=By.xpath("//*[@id='modal-1-content']/ul/li[6]/ul/li[2]/a/span");
	By ele5=By.id("s");

	public NewClass1(WebDriver rdriver) {
		driver=rdriver;

	}
	public WebElement holdtheExtend() {
		return driver.findElement(ele);
	}
	public void clickGetWorpress() {
		driver.findElement(ele1).click();;

	}
	public String getTheString() {
		return driver.findElement(eleGettingString).getText();

	}
	public void ClickCommunity() {
		driver.findElement(ele3).click();
	}
	public void ClickPhotoDirectory() {
		driver.findElement(ele4).click();
	}

}
