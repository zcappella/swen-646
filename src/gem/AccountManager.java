package gem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A class to provide the UI with an API to access account information
 *
 * @author Zachary Cappella
 */

import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class AccountManager {

  private String accountPath; // the path to where the accounts are being stored
  private List<Account> accounts;  // a list of all of the accounts
  
  // AccountManager constructor
  public AccountManager(String accountPath) {
      // validate parameters
      if (accountPath == null || accountPath.length() == 0)
          throw new IllegalArgumentException("Path cannot be null/empty string!");
    
      this.accountPath = accountPath;
      loadAccounts();
  }

  // get the path to the accounts
  public String getAccountPath() {
     return this.accountPath;
  }

  // get the list of all the accounts
  public List<Account> getAccounts() {
     List<Account> accountList = new ArrayList<>();
     for (Account account : this.accounts) {
        accountList.add(account.clone());
     }
     return accountList;
  }

  // load all of the user accounts into a list for management
  private void loadAccounts() {
	 List<Account> accountList = new ArrayList<>();

     File f = new File(this.accountPath);
     if (!f.exists() || !f.isDirectory())
        throw new InvalidLoadException(this.accountPath, "Account directory does not exist!");
     File fileList[] = f.listFiles();
     if (fileList.length == 0)
     	this.accounts = new ArrayList<>();
     else {
     	for (File file : fileList) {
            if (!file.getName().matches("^account-[0-9]{1,6}.yaml$"))
            	continue;
	        try {
	            Account account = new Account(String.valueOf(file.getAbsolutePath()));
	            accountList.add(account);
	        } catch(IllegalArgumentException e) {
	            throw new InvalidLoadException(String.valueOf(file.getAbsolutePath()), e.getMessage());
	        }
	     }
	     this.accounts = accountList;
     }
  }

  // save the account information to a YAML file
  private void saveToFile(Account account) {
     // Ensure that none of the params are null or zero values
     if (account == null)
            throw new IllegalArgumentException("Account cannot be null!");

     String fileName = "";
     if (this.accountPath.endsWith("/"))
            fileName = "account-" + String.valueOf(account.getID()) + ".yaml";
     else
            fileName = "/account-" + String.valueOf(account.getID()) + ".yaml";

     Map<String, Object> data = account.generateFileContent();
     Yaml yaml = new Yaml();
     FileWriter writer;
	 try {
		 writer = new FileWriter(this.accountPath + fileName, false);
		 yaml.dump(data, writer);
	 } catch (IOException e) {
		 throw new InvalidOperationException(String.valueOf(account.getID()),
                 							 "Could not write account file!");
	 }
  }

  // add equipment to a given account
  public void addEquipmentToAccount(int accountID, Equipment equipment) {
     // Ensure that none of the params are null or zero values
     if (equipment == null || accountID <= 0)
            throw new IllegalArgumentException("Account and Equipment values cannot be null/zero values!");

     boolean success = false;
     for (Account account : this.accounts) {
        if (account.getID() == accountID)
        {
            account.addEquipment(equipment.clone());
            saveToFile(account.clone());
            success = true;
        }
     }
     if (!success)
        throw new IllegalArgumentException("Account '" +
                                        String.valueOf(accountID) +
                                        "' does not exist!");
  }

  // remove equipment from a given account
  public void removeEquipmentFromAccount(int accountID, String serialNumber) {
	 // Ensure that none of the params are null or zero values
     if (serialNumber == null || serialNumber.length() ==0 || accountID <= 0)
            throw new IllegalArgumentException("Account and serial number values cannot be null/zero values!");

     boolean success = false;
     for (Account account : this.accounts) {
        if (account.getID() == accountID)
        {
            account.removeEquipment(serialNumber);
            saveToFile(account.clone());
            success = true;
        }
     }
     if (!success)
        throw new IllegalArgumentException("Account '" +
                                        String.valueOf(accountID) +
                                        "' does not exist!");
  }

  // change an account from active to inactive
  public void deactivateAccount(int accountID) {
     // Ensure that none of the params are null or zero values
     if (accountID <= 0)
            throw new IllegalArgumentException("Account ID cannot be a zero value!");

     boolean success = false;
     for (Account account : this.accounts) {
        if (account.getID() == accountID)
        {
            account.deactivateAccount();
            saveToFile(account.clone());
            success = true;
        }
     }
     if (!success)
        throw new IllegalArgumentException("Account '" +
                                           String.valueOf(accountID) +
                                           "' does not exist!");
  }

  // complete a transaction for a given account based on the equipment
  public void completeTransactionForAccount(int accountID, String serialNumber, int status) {
     // Ensure that none of the params are null or zero values
     if (accountID <= 0 || serialNumber == null || serialNumber.length() == 0 || status <= 0)
            throw new IllegalArgumentException("Account and equipment values cannot be a null/zero values!");

     boolean success = false;
     for (Account account : this.accounts) {
        if (account.getID() == accountID)
        {
            account.completeTransaction(serialNumber, status);
            saveToFile(account.clone());
            success = true;
        }
     }
     if (!success)
        throw new IllegalArgumentException("Account '" +
                                           String.valueOf(accountID) +
                                           "' does not exist!");
  }

  // add a new account
  public void addAccount(Account account) {
     // Ensure that none of the params are null or zero values
     if (account == null)
            throw new IllegalArgumentException("Account cannot be null!");

     for (Account act : this.accounts) {
        if (act.getID() == account.getID())
            throw new DuplicateObjectException(String.valueOf(account.getID()));
     }

     this.accounts.add(account);
     saveToFile(account.clone());
  }

  // remove a given account
  public void removeAccount(int accountID) {
     // Ensure that none of the params are null or zero values
     if (accountID <= 0)
            throw new IllegalArgumentException("Account ID cannot be zero!");

     boolean success = false;
     for (Account account : this.accounts) {
        if (account.getID() == accountID) {
            for (Equipment equipment : account.getEquipmentList()) {
                if (equipment.getStatus() == 1 || equipment.getStatus() == 2)
                    throw new InvalidOperationException(String.valueOf(account.getID()),
                                                        "Accounts with completed transactions cannot be deleted!");
            }
            this.accounts.remove(account);
            String fileName = "";
            if (this.accountPath.endsWith("/"))
                    fileName = "account-" + String.valueOf(account.getID()) + ".yaml";
            else
                    fileName = "/account-" + String.valueOf(account.getID()) + ".yaml";
            File f = new File(this.accountPath + fileName);
            f.delete();
            success = true;
            break;
        }
     }
     if (!success)
        throw new IllegalArgumentException("Account does not exist!");
  }
}