package gem;

import java.util.ArrayList;

/**
 * A class holding the information for a given Account
 *
 * @author Zachary Cappella
 */

import java.util.List;

public class Account {

  private int ID;  // unique way of identifying accounts from one another
  private int accountStatus;  // status of the account - either active or inactive
  private List equipmentList;   // list of equipment owned or rented by the account owner
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
      /* verify file ID is equal to the ID in the object
       * if not, throw IllegalArgumentException
       * Assign parameter values to attributes 
       * Create empty list of equipment objects
       * Set account to active
       */
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
  public List getEquipmentList() {
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
