package myWordpress.testScripts;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import myWordpress.myWordpress.BaseClass;
import myWordpress.pages.NewClass1;

public class TC_NewClass1 extends BaseClass{
	@Test
	public void runThePom() {
		NewClass1 newData=new NewClass1(driver);
		Actions action=new Actions(driver);
		action.moveToElement(newData.holdtheExtend()).build().perform();;
		newData.clickGetWorpress();
		String str=newData.getTheString();
		System.out.println(str);
		String str1="Get WordPress";
		Assert.assertEquals(str, str1);
		newData.ClickCommunity();
		newData.ClickPhotoDirectory();

	}



}

