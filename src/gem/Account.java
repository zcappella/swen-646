package gem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
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
     this.equipmentList = new ArrayList<>();
  }

  // Account constructor
  public Account(int ID, Owner owner, int accountStatus, List<Equipment> equipmentList) {
     // Ensure that none of the params are null or zero values
     if (ID == 0 || owner == null)
            throw new IllegalArgumentException("Account values cannot be null/zero values!");

     this.ID = ID;
     this.owner = owner.clone();
     this.accountStatus = accountStatus;
     List<Equipment> equipList = new ArrayList<>();
     for (Equipment equipment : equipmentList)
    	 equipList.add(equipment.clone());
     this.equipmentList = equipList;
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
	    		 Treadmill loadedEquipment = new Treadmill(equipment);
	    		 fileList.add(loadedEquipment.clone());
	    		 continue;
	    	 }
	    	 
	    	 if (serialNumber.substring(0,2).equals("ST")) {
	    		 Stepper loadedEquipment = new Stepper(equipment);
	    		 fileList.add(loadedEquipment.clone());
	    		 continue;
	    	 }
	    	 
	    	 if (serialNumber.substring(0,2).equals("SB")) {
	    		 StationaryBike loadedEquipment = new StationaryBike(equipment);
	    		 fileList.add(loadedEquipment.clone());
	    		 continue;
	    	 }
	    	 
	    	 throw new IllegalArgumentException("Serial Number did not conform to standard!");
	     }

	     Address ownerAddress = new Address((Map) ((Map) yamlAccount.get("owner")).get("address"));
	
	     fileOwner = new Owner(
                (Map) yamlAccount.get("owner"),
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
     List<Equipment> equipmentList = new ArrayList<>();
     for (Equipment equipment : this.equipmentList) {
        equipmentList.add(equipment.clone());
     }
     return equipmentList;
  }

  // get the account owner
  public Owner getOwner() {
     return this.owner.clone();
  }

  // set the owner of the account
  public void setOwner(Owner owner) {
      if (this.accountStatus == 1)
            throw new InvalidOperationException(owner.getName(), "Account is inactive", this.ID);
      
      this.owner = owner.clone();
  }
  
  // add equipment to the account
  public void addEquipment(Equipment equipment) {
      if (equipment == null)
            throw new IllegalArgumentException("Equipment object was null!");

      if (this.accountStatus == 1)
            throw new InvalidOperationException(equipment.getSerialNumber(),
                                                "Inactive accounts cannot add new equipment objects",
                                                this.ID);

      if (equipment.status == 1 || equipment.status == 2)
            throw new IllegalArgumentException("Equipment with completed transactions cannot be re-purchase/rented.");

      for (Equipment eq : this.equipmentList) {
           if (eq.getSerialNumber() == equipment.getSerialNumber())
                throw new DuplicateObjectException(equipment.getSerialNumber(),
                                               	   this.ID);
      }

      this.equipmentList.add(equipment.clone());
  }

  // remove equipment from the account
  public void removeEquipment(String serialNumber) {
      if (serialNumber == null || serialNumber.length() == 0)
            throw new IllegalArgumentException("Serial Number was null/empty!");

      if (this.accountStatus == 1)
            throw new InvalidOperationException(serialNumber,
                                                "Inactive accounts cannot remove equipment objects",
                                                this.ID);

      boolean found_flag = false;
      for (int i=0; i < equipmentList.size(); i++) {
           if (equipmentList.get(i).getSerialNumber().equalsIgnoreCase(serialNumber)) {
               equipmentList.remove(i);
               found_flag = true;
               break;
           }
      }

      if (!found_flag)
            throw new InvalidOperationException(serialNumber,
                                                "Equipment does not exist in this account",
                                                this.ID);
  }

  // complete an equipment transaction
  public void completeTransaction(String serialNumber, int status) {
      if (serialNumber == null || serialNumber.length() == 0)
            throw new IllegalArgumentException("Serial Number was null/empty!");

      if (this.accountStatus == 1)
            throw new InvalidOperationException(serialNumber,
                                                "Inactive accounts cannot complete transactions",
                                                this.ID);
      boolean success_flag = false;
      List<Equipment> equipmentList = new ArrayList<>();
      for (Equipment eq : this.equipmentList) {
           if (eq.getSerialNumber() == serialNumber) {
                eq.completeTransaction(status);
                equipmentList.add(eq.clone());
                success_flag = true;
           }
           else
                equipmentList.add(eq.clone());
      } 

      if (!success_flag)
          throw new IllegalArgumentException("Equipment object '" +
                                             serialNumber +
                                             "' does not exist in this account");
      else
          this.equipmentList = equipmentList;
  }

  // set the account status to inactive
  public void deactivateAccount() {
      if (this.accountStatus == 1)
            throw new IllegalStateException("Account is already inactive!");

      this.accountStatus = 0;
  }

  // format the equipment's information into a YAML format
  public Map generateFileContent() {
     Map<String, Object> data = new HashMap<String, Object>();
     data.put("accountID", this.ID);
     data.put("accountStatus", this.accountStatus);
     List<Map> equipmentList = new ArrayList<>();
     for (Equipment equipment : this.equipmentList) {
         equipmentList.add(equipment.generateFileContent());
     }
     data.put("equipmentList", equipmentList);
     data.put("owner", this.owner.generateFileContent());
     return data;
  }

  // create and return a copy of the Account object
  public Account clone() {
      return new Account(
        this.ID,
        this.owner.clone(),
        this.accountStatus,
        this.equipmentList);
  }
}
