package gem;

/**
 * A class for implementing the user-defined exception when encountering invalid equipment
 *
 * @author Zachary Cappella
 */

public class InvalidEquipmentException extends RuntimeException {

  private String equipmentData; // the piece of equipment data that is incorrectly formatted
  private String errorMsg;    // the detailed reason why the equipment data is incorrectly formatted

  // format the error message into a presentable string
  public String toString() {
      /*
       * return "The equipment data " + equipmentData + " is not properly formatted because " + errorMsg;
       */
     return null;
  }

  // InvalidEquipmentException constructor
  public InvalidEquipmentException(String equipmentData, String errorMsg) {
      /* super();
       * Validate parameters 
       * Assign parameter values to attributes 
       * this.toString()
       */
  }
}