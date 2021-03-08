package gem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

/**
 * A class holding the information for a given Account
 *
 * @author Zachary Cappella
 */

public class Account {

  private int ID;  // unique way of identifying accounts from one another
  private int accountStatus;  // status of the account - either active or inactive
  private List<Equipment> equipmentList;   // list of equipment owned or rented by the account owner
  private Owner owner;  // the owner of the account
  
  // Account constructor
  public Account(int ID, Owner owner) {
     // Ensure that none of the params are null or zero values
     if (ID == 0 || owner == null)
            throw new IllegalArgumentException("Account values cannot be null/zero values!");

     this.ID = ID;
     this.owner = owner.clone();
     this.accountStatus = 0;
     List<Equipment> emptyList = new ArrayList<>();
     this.equipmentList = emptyList;
  }

  // Account constructor
  public Account(String fileName) {
     // Ensure that none of the params are null or zero values
     if (fileName == null || fileName.length() == 0)
            throw new IllegalArgumentException("Account values cannot be null/zero values!");

     int fileID = 0;
     int fileStatus = 0;
     Owner fileOwner;
     List<Equipment> fileList = new ArrayList<>();
     
     FileInputStream inputStream;
	 try {
		 Yaml yaml = new Yaml();
		 // Loading the YAML file from the file name
	     inputStream = new FileInputStream(fileName);
	
		 Map yamlAccount = yaml.load(inputStream);
		 fileID = (int) yamlAccount.get("accountID");
		 fileStatus = (int) yamlAccount.get("accountStatus");

	     List<Map> yamlEquipment = (List) yamlAccount.get("equipmentList");
	     for (Map equipment : yamlEquipment) {
	    	 String serialNumber = (String) equipment.get("serialNumber");
	    	 if (serialNumber.substring(0,2).equals("TH")) {
	    		 Treadmill loadedEquipment = new Treadmill(
	    				 serialNumber,
	    				 (String) equipment.get("brand"),
	    				 (String) equipment.get("model"),
	    				 (double) equipment.get("equipmentPrice"),
	    				 (double) equipment.get("maxSpeed"));
	    		 fileList.add(loadedEquipment);
	    		 continue;
	    	 }
	    	 
	    	 if (serialNumber.substring(0,2).equals("ST")) {
	    		 Stepper loadedEquipment = new Stepper(
	    				 serialNumber,
	    				 (String) equipment.get("brand"),
	    				 (String) equipment.get("model"),
	    				 (double) equipment.get("equipmentPrice"),
	    				 (boolean) equipment.get("heartMonitor"),
	    				 (int) equipment.get("height"));
	    		 fileList.add(loadedEquipment);
	    		 continue;
	    	 }
	    	 
	    	 if (serialNumber.substring(0,2).equals("SB")) {
	    		 StationaryBike loadedEquipment = new StationaryBike(
	    				 serialNumber,
	    				 (String) equipment.get("brand"),
	    				 (String) equipment.get("model"),
	    				 (double) equipment.get("equipmentPrice"),
	    				 (int) equipment.get("resistanceLevels"),
	    				 (int) equipment.get("height"));
	    		 fileList.add(loadedEquipment);
	    		 continue;
	    	 }
	    	 
	    	 throw new IllegalArgumentException("Serial Number did not conform to standard!");
	     }

	     Map yamlOwner = (Map) yamlAccount.get("owner");
	     Map yamlAddress = (Map) yamlOwner.get("address");
	     Address ownerAddress = new Address(
	    		 String.valueOf(yamlAddress.get("zipcode")),
	    		 (String) yamlAddress.get("street"),
	    		 (String) yamlAddress.get("city"),
	    		 (String) yamlAddress.get("state"));
	
	     fileOwner = new Owner(
	    		 (String) yamlOwner.get("name"),
	    		 (String) yamlOwner.get("emailAddress"),
	    		 (String) yamlOwner.get("phoneNumber"),
	    		 ownerAddress.clone());
	 } catch(FileNotFoundException fnfe) {
		 throw new IllegalArgumentException("Account file: '" + fileName + "' could not be found!");
	 }

     // Mapping the account from the YAML file to the Employee class
	 this.ID = fileID;
	 this.owner = fileOwner.clone();
	 this.accountStatus = fileStatus;
	 this.equipmentList = fileList;
  }

// get the ID of the account
  public int getID() {
     return this.ID;
  }

  // get the account status
  public int getAccountStatus() {
     return this.accountStatus;
  }

  // get the list of equipment associated to the account
  public List<Equipment> getEquipmentList() {
     return this.equipmentList;
  }

  // get the account owner
  public Owner getOwner() {
     return this.owner;
  }

  // set the owner of the account
  public void setOwner(Owner owner) {
      /*
       * if account is inactive, throw InvalidOperationException
       * set the Owner to the object's clone
       */
  }
  
  // add equipment to the account
  public void addEquipment(Equipment equipment) {
      /*
       * validate parameters
       * if account is inactive, throw throw InvalidOperationException
       * if serial number has completed transaction, throw IllegalArgumentException
       * check that the account doesn't have the given piece of equipment
       * if not found, add the equipment by cloning it to the account's equipment list
       * if found, throw the DuplicateObjectException
       */
  }

  // remove equipment from the account
  public void removeEquipment(String serialNumber) {
      /*
       * if account is inactive, throw InvalidOperationException
       * validate parameters
       * if parameters are invalid, throw IllegalArgumentException
       * if serial number does not exist, throw IllegalArgumentException
       * if equipment already has completed transaction, throw IllegalArgumentException
       * check if the account has the given piece of equipment
       * if found, remove it from the account's equipment list
       * if not, throw InvalidOperationException
       *
       */
  }

  // complete an equipment transaction
  public Double completeTransaction(String serialNumber, int status) {
      /*
       * if serialNumber does not exist, throw IllegalArgumentException
       * if account is inactive, throw InvalidOperationException
       * return the equipment's completeTransaction function
       *
       */
	  return null;
  }

  // set the account status to inactive
  public void deactivateAccount() {
       /*
        * if account is already inactive, throw IllegalStateException
        * change account status to inactive
        */
  }
}
