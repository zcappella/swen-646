package gem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * A class to provide the UI with an API to access account information
 *
 * @author Zachary Cappella
 */

import java.util.List;
import java.util.Map;

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
     return this.accounts;
  }

  // load all of the user accounts into a list for management
  private void loadAccounts() {
	 List<Account> accountList = new ArrayList<>();

     File f = new File(this.accountPath);
     File fileList[] = f.listFiles();
     for (File file : fileList) {
        try {
            Account account = new Account(String.valueOf(file.getAbsolutePath()));
            accountList.add(account);
        } catch(IllegalArgumentException e) {
            throw new InvalidLoadException(String.valueOf(file.getAbsolutePath()), e.getMessage());
        }
     }
     this.accounts = accountList;
	  /*
	   * ensure the account path exists
       * if it doesn't exist, raise InvalidLoadException
       * if it does exist, get all of the accounts in the directory
       * loop through all of the files that meet the filename convention and call Account constructor
       * throw InvalidLoadException if error is encountered
	   * set the accounts attribute
	   */
  }

  //save the account information to a YAML file
  private void saveToFile(String fileName, Account account) {
     /*
       * verify the account exists
       * if not, throw IllegalArgumentException
       * if the file exists, overwrite it
       * if the file does not exist, create it
       * write out account in YAML format as key: value pairs
       * iterate through equipment list
       * call toString() for each equipment object and write the data to file
       * close file
       * catch any errors that may occur
       */
  }

  // add equipment to a given account
  public void addEquipmentToAccount(int accountID, Equipment equipment) {
	  /*
	   * validate parameters
	   * find the account in the list of accounts
	   * if not found, throw IllegalArgumentException 
	   *
       * call account object's addEquipment function
       *
       * update the account file
	   */
  }

  // remove equipment from a given account
  public void removeEquipmentFromAccount(int accountID, String serialNumber) {
	  /*
	   * validate parameters
	   * find the account in the list of accounts
	   * if not found, throw IllegalArgumentException 
	   *
       * call account object's removeEquipment function
       *
       * update the account file
	   */
  }

  // change an account from active to inactive
  public Account deactivateAccount(int accountID) {
	  /*
	   * validate parameters
	   * find the account in the list of accounts
	   * if not found, throw IllegalArgumentException 
	   * if found, call the account's deactivate function
       *
       * update the account file
	   */
	  return null;
  }

  // complete a transaction for a given account based on the equipment
  public Double completeTransactionForAccount(int accountID, String serialNumber, int status) {
	  /*
	   * validate parameters
	   * find the account in the list of accounts
	   * if not found, throw IllegalArgumentException 
	   *
       * call account object's completeTransaction function
       *
       * update the account file
	   */
	  return null;
  }

  // add a new account
  public void addAccount(Account account) {
	  /*
	   * validate parameters
	   * look for the account in the list of accounts
	   * if duplicate found, throw DuplicateObjectException
	   * if not found, create the account by cloning the Account object
       *
       * update the account file
	   */
  }

  // add a new account
  public void addAccount(String fileName) {
      /*
       * validate parameters
       * look for the account in account file location
       * if duplicate found, throw DuplicateObjectException
       * if not found, call Account(filename)
       *
       * addAccount(Account)
       */
  }

  // remove a given account
  public void removeAccount(int accountID) {
	  /*
	   * validate parameters
       * if parameters are invalid, throw IllegalArgumentException
	   * find the account in the list of accounts
	   * if not found, throw IllegalArgumentException
       * if account has completed transaction, throw InvalidOperationException
	   * if found, delete the account
       *
       * remove the account file
	   */
  }
}