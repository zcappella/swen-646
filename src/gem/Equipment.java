package gem;

import java.util.HashMap;
import java.util.Map;

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
      // validate parameters
      if (serialNumber == null || serialNumber.length() == 0 || brand == null || brand.length() == 0
              || model == null || model.length() == 0 || equipPrice <= 0)
          throw new IllegalArgumentException("Equipment values cannot be null/zero values!");

      this.serialNumber = serialNumber;
      this.brand = brand;
      this.model = model;
      this.equipmentPrice = equipPrice;
      this.status = 0;
      this.transactionPrice = 0.0;
  }

  // get the equipment's serial number
  public String getSerialNumber() {
     return this.serialNumber;
  }

  // get the equipment's brand
  public String getBrand() {
     return this.brand;
  }

  // get the equipment's model
  public String getModel() {
     return this.model;
  }

  // get the equipment's equipment price
  public double getEquipmentPrice() {
     return this.equipmentPrice;
  }

  // get the equipment's transaction price
  public double getTransactionPrice() {
     return this.transactionPrice;
  }

  // get the equipment's status
  public int getStatus() {
     return this.status;
  }
  
  // calculate shipping costs
  public double calculateShipping() {
     return 29.99;
  }

  // calculate the price for a transaction
  public double calculateTransactionPrice() {
      if (this.status == 0)
         throw new InvalidOperationException(this.serialNumber,
                                                "The equipment's status is not set!");
      return this.equipmentPrice + calculateShipping();
  }

  // complete an equipment transaction
  public void completeTransaction(int status) {
      if (status != 0)
         throw new InvalidCompletionException(this.serialNumber,
                                              "The equipment already has a completed transaction!");
      this.status = status;
      this.transactionPrice = calculateTransactionPrice();
  }

  // set the status of a given piece of equipment and return whether the action was successful
  public void setStatus(int status) {
	  if (status == this.status)
        throw new IllegalArgumentException("Status cannot be null or the same as the current status!");

      this.status = status;
  }
  
  // format the equipment's information into a presentable string
  public String toString() {
	  return this.serialNumber + " : " +
             this.brand + " : " +
             this.model + " : " +
             String.valueOf(this.equipmentPrice) + " : " +
             String.valueOf(this.transactionPrice) + " : " +
             String.valueOf(this.status);
  }

  // format the equipment's information into a YAML format
  public Map generateFileContent() {
     Map<String, Object> data = new HashMap<String, Object>();
     data.put("serialNumber", this.serialNumber);
     data.put("brand", this.brand);
     data.put("model", this.model);
     data.put("equipmentPrice", this.equipmentPrice);
     data.put("transactionPrice", this.transactionPrice);
     data.put("status", this.status);
     return data;
  }
  
  // create and return a copy of the equipment object
  public abstract Equipment clone();
}