// This is the package, it is used as access protection and is used to
// categorize the classes and interfaces so that they are easily maintained The
package com.codedifferently.store;
// This is importing the Array list from the java.util package or folder
import java.util.ArrayList;
//  This is importing a HashMap from the java.util package or folder
import java.util.HashMap;
//  This is importing the Map from the java.util package or folder
import java.util.Map;
//  This is the public class called PapiStore
public class PapiStore {
//  The is a state of the object PapiStore. It is determining the value of IsStore Open true/false.
//  The method is private and cannot be changed by other users.
    private boolean isStoreOpen;
//  This state is a String Array list called tabs. The method is determining who can have a tab.
    private ArrayList<String> tabs;
//  This state is a Map interface that accepts data types String and Double. It is determining who owesPapiMoney.
    Map<String, Double> owesPapiMoney;
//  This is a public constructor called PapiStore named after the class PapiStore.
//  This constructor holds the values of isStoreOpen,tabs and owesPapiMoney.
    public PapiStore(){
//  This. is used to connect directly to the object isStoreOpen above, the state is set to false.
        this.isStoreOpen = false;
//  This.tabs is used to connect directly to the object tabs above.
        this.tabs = new ArrayList();
//  HashMap is used to initialize the hashmap by using the elements of the object owesPapiMoney.
        this.owesPapiMoney = new HashMap<>();
    }
//  This is another constructor with multiple states the accepted parameters include Boolean isOpen,ArrayList<String>.
    public PapiStore(Boolean isOpen, ArrayList<String> tabsIn){
//  Another value for isStoreOpen this time it is checking for the current state.
        this.isStoreOpen = isOpen;
//  Another value for tabs, this time you would use the method tabsIn instead of ArrayList.
        this.tabs = tabsIn;
//  We can only use on constructor at a time, if we choose this constructor we must use the methods listed.
        this.owesPapiMoney = new HashMap<>();
    }
//  This is a public method the state of the object is closeStore and does not return a value.
    public void closeStore(){

    }
//  This method sets the value of is store open to true, because it contains void we will not receive an output.
    public void openStore(){
        this.isStoreOpen = true; }
//   We are using the boolean isStoreOpen method to receive the output of isStoreOpen.
    public boolean isStoreOpen() {
        return isStoreOpen;
    }

//  This is a public method Boolean allowToUseTab accepts a data type String called name.
    public Boolean allowToUseTab(String name){
//  The reference type boolean response is set to false.
        Boolean response = false;
//  If name has an active tab and does not have an overdue balance the result will be false.
        if(hasAnActiveTab(name) && !hasAnOverDueBalance(name))
//  If name has an active tab and an overdue balance the result will be true.
            response = true;
//  return the response.
        return response;
    }
//  This method is private and is used to assist the allowToUseTab method.
//  This method tracks if someone has an overdue balance and accepts a data type String called name.
    private boolean hasAnOverDueBalance(String name){
//  If person (name) does not owe papi money
        if(!owesPapiMoney.containsKey(name))
//  Returns false if name does not have an overdue balance, this method will return false.
            return false;
//  Double called money includes decimals and allows us to see the full amount owed.
        Double money = owesPapiMoney.get(name);
//  A Boolean was created and is set to false
        Boolean owes = false;
//  If the money the person owes is greater than 0.0
        if(money > 0.0)
//  The if statement will return true meaning name owesPapiMoney
            owes = true;
//  Response owes is returned
        return owes;
    }
//  This method is used by the constructor allowtoUseTab to track if a person has an active tab.
    private boolean hasAnActiveTab(String name){
//  for every string called tab with a collection of tabs are the parameters for the for loop.
        for (String tab : tabs){
//  If a person (name) has a tab
            if (tab.equals(name))
//  this method will return as true because they have an active tab.
                return true;
//   If a person does not have an active tab, the method will return as false.
        }
        return false;
    }
//   Created an object createActive tab that accepts a data type String called name.
//   This method creates a tab for anyone who wants one.
    public void createActiveTab(String name){
        this.tabs.add(name);
    }

//  public is an access specifier that identifies the execution point of the program.
//  static methods invoke without creating the objects so that we do not need an object to call main() method.
//  Main is the starting point for execution of a Java program.
//  String[] args allows the main method to also accept data from the user. It accepts a group of strings(array).
//  System.out is the method we use to print the message "Welcome to Papi Store, Hola."
    public static void main(String[] args) {
        System.out.println("Welcome to Papi Store, Hola");
    }


}
