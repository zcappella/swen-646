package gem;

/**
 * A abstract class for implementing all common equipment-related activities and attributes
 *
 * @author Zachary Cappella
 */

public abstract class Equipment {

  protected String serialNumber;  // serial number for the given piece of equipment
  protected String brand;   // the brand of the given piece of equipment
  protected String model;  // the model of the given piece of equipment
  protected double equipmentPrice;  // the base price of the piece of equipment
  protected double transactionPrice;  // the total price to acquire the piece of equipment
  protected int status;  // the status of the piece of equipment - either available, purchased, or rented

  // equipment class constructor
  public Equipment(String serialNumber, String brand, String model, double equipPrice) {
	  /*
	   * validate parameters
       * if parameters are missing or invalid, throw IllegalArgumentException
	   * set status to active
       *
       * throw InvalidEquipmentException if error is encountered during equipment creation
	   */
  }

  // get the equipment's serial number
  public String getSerialNumber() {
     /*
      * return this.serialNumber
      */
     return null;
  }

  // get the equipment's brand
  public String getBrand() {
     /*
      * return this.brand
      */
     return null;
  }

  // get the equipment's model
  public String getMode() {
     /*
      * return this.model
      */
     return null;
  }

  // get the equipment's equipment price
  public double getEquipmentPrice() {
     /*
      * return this.equipmentPrice
      */
     return 0.0;
  }

  // get the equipment's transaction price
  public double getTransactionPrice() {
     /*
      * return this.transactionPrice
      */
     return 0.0;
  }

  // get the equipment's status
  public int getStatus() {
     /*
      * return this.status
      */
     return 0;
  }
  
  // calculate shipping costs
  public double calculateShipping() {
      /*
       * return 29.99
       */
     return 0.0;
  }

  // calculate the price for a transaction
  public double calculateTransactionPrice() {
      /*
       * fail if status is not set
       * return equipmentPrice + calculateShipping
       */
      return 0.0;
  }

  // complete an equipment transaction
  public void completeTransaction(int status) {
      /*
       * throw InvalidCompletionException if status is not set
       * throw InvalidCompletionException if transaction is already completed
       * set the equipment status
       * set the transaction price by calling calculateTransactionPrice
       * throw InvalidCompletionException if error is encountered
       */
  }

  // set the status of a given piece of equipment and return whether the action was successful
  public boolean setStatus(int status) {
	  /*
	   * validate parameters
	   * if the status is the same as the current status, fail
	   * if not, set the status
	   */
        return false;
  }
  
  // format the equipment's information into a presentable string
  public String toString() {
	  /*
	   * return "<serialNumber>" + "<brand>" + "<model>" + "<equipmentPrice>" + "<transactionPrice>" + "<status>"
	   */
	  return null;
  }
  
  // create and return a copy of the equipment object
  public abstract Equipment clone();
}