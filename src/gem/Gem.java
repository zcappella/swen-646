package gem;

import java.util.List;

/**
 * A class holding the test class for exercising the GEM API
 *
 * @author Zachary Cappella
 */

public class Gem {
    public static String accountPath = "/Users/zaccappella/eclipse-workspace/SWEN-646 Project/src/accounts/";

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
        testScenario6();
        testScenario7();
        testScenario8();
        testScenario9();
        testScenario10();
        testScenario11();
    }
    
    /*
     * Function for generating a new Owner stub for Account objects
     */
    private static Owner generateOwnerStub() {
        return new Owner("Owner Stub", "stub@gmail.com", "111-111-1111", generateAddressStub().clone());
    }

    /*
     * Function for generating a new Address stub for Owner objects
     */
    private static Address generateAddressStub() {
        return new Address("12345", "Address Stub Street", "Stub City", "ST");
    }

    /*
     * Create a new Account Manager object, load the accounts at the specified path, and dump the account information available
     */
    public static void testScenario1() {
    	System.out.println("Test Scenario #1:");
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
        System.out.println("\n");
    }

    /*
     * Create a new Address object
     */
    public static void testScenario2() {
    	System.out.println("Test Scenario #2:");
        Address address = new Address(
             "12345",
             "Example Street",
             "Bowie",
             "MD");

        System.out.println("---------- Address Information ----------");
        System.out.println("Address Zipcode: " + address.getZipcode());
        System.out.println("Address Street: " + address.getStreet());
        System.out.println("Address City: " + address.getCity());
        System.out.println("Address State: " + address.getState());
        System.out.println("To String Method: " + address.toString());
        System.out.println("-----------------------------------------");

        System.out.println("\n");
    }

    /*
     * Create a new Owner object
     */
    public static void testScenario3() {
    	System.out.println("Test Scenario #3:");
        Owner owner = new Owner(
                 "Zac Cappella",
                 "zcappella@student.umgc.edu",
                 "111-222-3333",
                 generateAddressStub().clone());
        System.out.println("---------- Owner Information ----------");
        System.out.println("Owner Name: " + owner.getName());
        System.out.println("Owner Email Address: " + owner.getEmailAddress());
        System.out.println("Owner Phone Number: " + owner.getPhoneNumber());
        System.out.println("Owner Address: " + owner.getAddress().toString());
        System.out.println("To String Method: " + owner.toString());
        System.out.println("-----------------------------------------");

    	System.out.println("\n");
    }

    /*
     * Create a new Account object
     */
    public static void testScenario4() {
    	System.out.println("Test Scenario #4:");
        Account account = new Account(
            1,
            generateOwnerStub().clone());
        System.out.println("---------- Account Information ----------");
        System.out.println("Account ID: " + account.getID());
        System.out.println("Account Status: " + account.getAccountStatus());
        System.out.println("Account Owner Name: " + account.getOwner().getName());
        if (account.getEquipmentList().isEmpty())
            System.out.println("Account Equipment List is empty");
        else
            throw new InvalidOperationException(String.valueOf(account.getID()), "Account created with non-emtpy equipment list.");
        System.out.println("Account Owner Information: " + account.getOwner().toString());
        System.out.println("To String Method: " + account.toString());
        System.out.println("-----------------------------------------");

    	System.out.println("\n");
    }

    /*
     * Create a new equipment object of each type
     */
    public static void testScenario5() {
    	System.out.println("Test Scenario #5:");
        Treadmill treadmill = new Treadmill(
            "TH000001",
            "Test Treadmill Brand",
            "Test Treadmill Model",
            100.00,
            12.0);

        System.out.println("---------- Treadmill Information ----------");
        System.out.println("Treadmill Serial Number: " + treadmill.getSerialNumber());
        System.out.println("Treadmill Brand: " + treadmill.getBrand());
        System.out.println("Treadmill Model: " + treadmill.getModel());
        System.out.println("Treadmill Equipment Price: " + String.valueOf(treadmill.getEquipmentPrice()));
        System.out.println("Treadmill Max Speed: " + treadmill.getMaxSpeed());
        System.out.println("To String Method: " + treadmill.toString());
        System.out.println("-----------------------------------------");
        System.out.println("\n");

        Stepper stepper = new Stepper(
            "ST000001",
            "Test Stepper Brand",
            "Test Stepper Model",
            975.50,
            true,
            12);

        System.out.println("---------- Stepper Information ----------");
        System.out.println("Stepper Serial Number: " + stepper.getSerialNumber());
        System.out.println("Stepper Brand: " + stepper.getBrand());
        System.out.println("Stepper Model: " + stepper.getModel());
        System.out.println("Stepper Equipment Price: " + String.valueOf(stepper.getEquipmentPrice()));
        System.out.println("Stepper Heart Monitor: " + String.valueOf(stepper.getHeartMonitor()));
        System.out.println("Stepper Height: " + String.valueOf(stepper.getHeight()));
        System.out.println("To String Method: " + stepper.toString());
        System.out.println("-----------------------------------------");
        System.out.println("\n");

        StationaryBike sb = new StationaryBike(
            "SB000001",
            "Test Stationary Bike Brand",
            "Test Stationary Bike Model",
            899.99,
            15,
            4);
        System.out.println("---------- Stationary Bike Information ----------");
        System.out.println("Stationary Bike Serial Number: " + sb.getSerialNumber());
        System.out.println("Stationary Bike Brand: " + sb.getBrand());
        System.out.println("Stationary Bike Model: " + sb.getModel());
        System.out.println("Stationary Bike Equipment Price: " + String.valueOf(sb.getEquipmentPrice()));
        System.out.println("Stationary Bike Resistance Levels: " + String.valueOf(sb.getResistanceLevels()));
        System.out.println("Stationary Bike Height: " + String.valueOf(sb.getHeight()));
        System.out.println("To String Method: " + sb.toString());
        System.out.println("-----------------------------------------");

    	System.out.println("\n");
    }

    /*
     * Create a new Account object and save to a file
     */
    public static void testScenario6() {
        System.out.println("Test Scenario #6:");
        AccountManager am = new AccountManager(accountPath);
        
        List<Account> accountList = am.getAccounts();
        int accountCount = 1;
        for (Account account : accountList) {
            accountCount++;
        }
        Account account = new Account(accountCount++, generateOwnerStub().clone());
        am.addAccount(account);
        am.removeAccount(account.getID());
        System.out.println("\n");
    }

    /*
     * Create a new Account object, add equipment to it, and complete a transaction
     */
    public static void testScenario7() {
        System.out.println("Test Scenario #7:");
        AccountManager am = new AccountManager(accountPath);
        
        List<Account> accountList = am.getAccounts();
        int accountCount = 1;
        for (Account account : accountList) {
            accountCount++;
        }
        Account account = new Account(accountCount++, generateOwnerStub().clone());
        am.addAccount(account);
        System.out.println("Successfully wrote new account file.");
        Stepper stepper = new Stepper(
            "ST000001",
            "Test Stepper Brand",
            "Test Stepper Model",
            975.50,
            true,
            12);
        am.addEquipmentToAccount(account.getID(), stepper);
        am.completeTransactionForAccount(account.getID(), stepper.getSerialNumber(), 2);
        try {
            am.removeAccount(account.getID());
        } catch (InvalidOperationException ioe) {
            System.out.println("Was not able to remove account with completed transaction, as expected.");
        }
        System.out.println("\n");
    }

    /*
     * Create a new Account object, add equipment to it, and complete a transaction
     */
    public static void testScenario8() {
        System.out.println("Test Scenario #8:");
        AccountManager am = new AccountManager(accountPath);
        
        List<Account> accountList = am.getAccounts();
        int accountCount = 1;
        for (Account account : accountList) {
            accountCount++;
        }
        Account account = new Account(accountCount++, generateOwnerStub().clone());
        am.addAccount(account);
        System.out.println("Successfully wrote new account file.");
        StationaryBike sb = new StationaryBike(
            "SB000001",
            "Test Stationary Bike Brand",
            "Test Stationary Bike Model",
            899.99,
            15,
            4);
        am.addEquipmentToAccount(account.getID(), sb);
        try {
            am.addEquipmentToAccount(account.getID(), sb);
        } catch (DuplicateObjectException doe) {
            System.out.println("Was not able to equipment to account a second time, as expected.");
        }
        am.removeAccount(account.getID());
        System.out.println("\n");
    }

    /*
     * Attempt to create a new Account manager with invalid account path
     */
    public static void testScenario9() {
        System.out.println("Test Scenario #9:");
        String path = "/Users/zaccappella/path/to/nowhere";
        try {
            AccountManager am = new AccountManager(path);    
        } catch (InvalidLoadException ile) {
            System.out.println("Could not load account from non-existant directory");
        }
        System.out.println("\n");
    }

    /*
     * Create a new Account object and deactivate it
     */
    public static void testScenario10() {
        System.out.println("Test Scenario #10:");
        AccountManager am = new AccountManager(accountPath);
        
        List<Account> accountList = am.getAccounts();
        int accountCount = 1;
        for (Account account : accountList) {
            accountCount++;
        }
        Account account = new Account(accountCount++, generateOwnerStub().clone());
        am.addAccount(account);
        am.deactivateAccount(account.getID());
        System.out.println("Account is inactive!");
        am.removeAccount(account.getID());
        System.out.println("\n");
    }

    /*
     * Create a new Account object, add equipment to it, and complete a transaction
     */
    public static void testScenario11() {
        System.out.println("Test Scenario #11:");
        AccountManager am = new AccountManager(accountPath);
        
        List<Account> accountList = am.getAccounts();
        int accountCount = 1;
        for (Account account : accountList) {
            accountCount++;
        }
        Account account = new Account(accountCount++, generateOwnerStub().clone());
        am.addAccount(account);
        System.out.println("Successfully wrote new account file.");
        Treadmill treadmill = new Treadmill(
            "TH000001",
            "Test Treadmill Brand",
            "Test Treadmill Model",
            100.00,
            12.0);
        am.addEquipmentToAccount(account.getID(), treadmill);
        am.completeTransactionForAccount(account.getID(), treadmill.getSerialNumber(), 2);
        try {
            am.completeTransactionForAccount(account.getID(), treadmill.getSerialNumber(), 2);
        } catch (InvalidCompletionException ice) {
            System.out.println("Was not able to complete a transaction a second time, as expected.");
        }
        System.out.println("\n");
    }
}