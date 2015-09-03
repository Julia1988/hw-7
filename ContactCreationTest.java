package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {
	
		
  @Test(dataProvider = "randomValidContactGenerator")
  public void testContactCreationWithValidData(GroupContact contact) throws Exception {    
    
		app.getNavigationHelper().openMainPage();
				
		List<GroupContact> oldList = app.getContactHelper().getContacts();
		
		app.getContactHelper().initContactCreation();
		app.getContactHelper().fillContactForm(contact);    
        app.getContactHelper().submitContactCreation();    
        app.getContactHelper().returnToHomePage();
        
        List<GroupContact> newList = app.getContactHelper().getContacts();
        
        //assertEquals(newList.size(), oldList.size()+1);
        
        oldList.add(contact);
        Collections.sort(oldList);
        assertEquals(newList, oldList);
        
      }
}
