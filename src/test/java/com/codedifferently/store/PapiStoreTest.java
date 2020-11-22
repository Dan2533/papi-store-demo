// This is the package it defines the family relation of objects
package com.codedifferently.store;

// This is importing the Assert Class from the org.junit package or folder
import org.junit.Assert;
// This is importing Before class from org.junit package or folder.
import org.junit.Before;
// This is importing the Test class from org.junit package or folder.
import org.junit.Test;

//  This is a public class called PapiStoreTest
    public class PapiStoreTest {
//  This calls for the object PapiStore and creates a variable called papiStore.
        PapiStore papiStore;
//  Before is a fixture and is used when we do not want to repeat code.
//  Each of the methods will be ran before starting the other tests.
        @Before
        public void setup(){
            papiStore = new PapiStore();
//  Creating an active tab for Jamal.
            papiStore.createActiveTab("Jamal");
//  Creating an active tab for Victor.
            papiStore.createActiveTab("Victor");
//  Jamal does not owe the papiStore money.
            papiStore.owesPapiMoney.put("Jamal", 0.0);
//  Victor owes papiStore $7.0
            papiStore.owesPapiMoney.put("Victor", 7.0);
        }
//  This is an annotation for user testing
        @Test
//  This is a public test but does not return a value.
        public void OpenStoreTest(){
            //Given
//  References papiStore to ask if the store open.
            papiStore.openStore();
//  Data type Boolean should return true
            //When
            Boolean expected = true;
            Boolean actual = papiStore.isStoreOpen();

            //Then
            //Assert.assertEquals(expected, actual);
//  The result is collected in this method.
//  .assertTrue always returns true, adding actual allows the method to grab whichever response the method received.
            Assert.assertTrue(actual);
        }
//  Testing if _ is allowed to use a tab, private methods are being called from the @before fixture.
        @Test
        public void allowToUseTabTestSuccess(){
            // given
//  class PapiStore extends and creates new PapiStore object
            PapiStore papiStore = new PapiStore();
//   Data type boolean should produce a true result
            // when
            Boolean expected = true;
//  The method is testing if Jamal is allowed to use a tab.
            Boolean actual = papiStore.allowToUseTab("Jamal");
//  This is the test stating the expected and calling for the actual result.
            // then
            Assert.assertEquals(expected, actual);
        }

        @Test
        public void allowToUseTabTestFail(){
//  A new object named PapiStore is created
            // given
            PapiStore papiStore = new PapiStore();
//  The result is expected to be false
            // when
            Boolean expected = false;
//  This is the test stating the expected and calling for the actual result.
            Boolean actual = papiStore.allowToUseTab("Victor");
//  This method states the expected and calls the actual result.
            // then
            Assert.assertEquals(expected, actual);
        }
}
