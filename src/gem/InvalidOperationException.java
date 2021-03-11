package gem;

/**
 * A class for implementing the user-defined exception when encountering invalid operations
 *
 * @author Zachary Cappella
 */

public class InvalidOperationException extends RuntimeException {

  private String objectID;    // the name of the object that could not be removed
  private String errorMsg;    // the detailed reason why the object could not be removed
  private int accountID;      // the ID of the account that had an invalid operation

  // format the error message into a presentable string
  public String toString() {
     if (this.accountID > 0)
    	 return this.getClass().getSimpleName() + "The object with ID " + this.objectID + " could not be removed because " + this.errorMsg + ", and the account " + this.accountID + " tried to remove it!";
     else
    	return this.getClass().getSimpleName() + "The object with ID " + this.objectID + " could not be removed because " + this.errorMsg;
        
  }

  // InvalidOperationException constructor
  public InvalidOperationException(String objectID, String errorMsg) {
      super();
      if (objectID == null || objectID.length() == 0 || errorMsg == null || errorMsg.length() == 0)
          throw new IllegalArgumentException("InvalidOperationException values cannot be null/zero values!");
      this.objectID = objectID;
      this.errorMsg = errorMsg;
      System.out.println(this.toString());
  }

  // InvalidOperationException constructor
  public InvalidOperationException(String objectID, String errorMsg, int accountID) {
      super();
      if (objectID == null || objectID.length() == 0 || errorMsg == null || errorMsg.length() == 0
              || accountID <= 0)
          throw new IllegalArgumentException("InvalidOperationException values cannot be null/zero values!");
      this.objectID = objectID;
      this.errorMsg = errorMsg;
      this.accountID = accountID;
      System.out.println(this.toString());
  }
}