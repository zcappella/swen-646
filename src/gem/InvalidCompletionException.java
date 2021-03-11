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
      return this.getClass().getSimpleName() + "The transaction for equipment ID " + this.equipmentID + ", with account ID, " + this.accountID + ", could not be completed because " + this.errorMsg;
  }

  // InvalidCompletionException constructor
  public InvalidCompletionException(String equipmentID, String errorMsg, int accountID) {
      super();
      if (equipmentID == null || equipmentID.length() == 0 || errorMsg == null || errorMsg.length() == 0
              || accountID <= 0)
          throw new IllegalArgumentException("InvalidCompletionException values cannot be null/zero values!");
      this.equipmentID = equipmentID;
      this.errorMsg = errorMsg;
      this.accountID = accountID;
      System.out.println(this.toString());
  }
}