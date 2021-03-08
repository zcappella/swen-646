package gem;

import java.util.List;

/**
 * A class holding the test class for exercising the GEM API
 *
 * @author Zachary Cappella
 */

public class Gem {
    public static String accountPath = "/Users/zaccappella/eclipse-workspace/SWEN-646 Project/src/accounts";

    /**
     * @param args - command-line arguments
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            if (args[0] != null && args[0].length() > 0)
                accountPath = args[0];
        }

        // Execute Test Scenarios
        testScenario1();
        testScenario2();
        testScenario3();
        testScenario4();
        testScenario5();
    }

    public static void testScenario1() {
        AccountManager am = new AccountManager(accountPath);
        
        List<Account> accountList = am.getAccounts();
        for (Account account : accountList) {
        	System.out.println("---------- Account Information ----------");
        	System.out.println("Account ID: " + String.valueOf(account.getID()));
        	System.out.println("Account Status: " + String.valueOf(account.getAccountStatus()));
        	for (Equipment equipment : account.getEquipmentList()) {
        		System.out.println("Account Equipment: " + equipment.getSerialNumber());
        	}
        	System.out.println("Account Owner: " + account.getOwner().toString());
        	System.out.println("-----------------------------------------");
        }
    }

    public static void testScenario2() {
        
    }

    public static void testScenario3() {
        
    }

    public static void testScenario4() {
        
    }

    public static void testScenario5() {
        
    }
}