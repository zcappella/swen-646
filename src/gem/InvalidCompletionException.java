package gem;

/**
 * A class for implementing the user-defined exception when encountering invalid transaction completions
 *
 * @author Zachary Cappella
 */

public class InvalidCompletionException extends RuntimeException {

  private String equipmentID;  // the ID of the equipment that was unable to be rented/bought
  private String errorMsg;    // the detailed reason why the transaction could not be completed
  private int accountID;     // the ID of the account that had a problem

  // format the error message into a presentable string
  public String toString() {
      /*
       * return "The transaction for equipment ID " + this.equipmentID + ", with account ID, " + this.accountID + ", could not be completed because " + this.errorMsg;
       */
     return null;
  }

  // InvalidCompletionException constructor
  public InvalidCompletionException(String equipmentID, String errorMsg, int accountID) {
      /* super();
       * Validate parameters 
       * Assign parameter values to attributes 
       * this.toString()
       */
  }
}