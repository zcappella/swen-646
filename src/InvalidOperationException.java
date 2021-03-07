public class InvalidOperationException extends RuntimeException {

  private String objectID;    // the name of the object that could not be removed
  private String errorMsg;    // the detailed reason why the object could not be removed
  private int accountID;      // the ID of the account that had an invalid operation

  // format the error message into a presentable string
  public String toString() {
      /*
       * return "The object with ID " + objectID + " could not be removed because " + errorMsg;
       */
     return null;
  }

  // InvalidOperationException constructor
  public InvalidOperationException(String objectID, String errorMsg) {
      /* super();
       * Validate parameters 
       * Assign parameter values to attributes 
       * this.toString()
       */
  }

  // InvalidOperationException constructor
  public InvalidOperationException(String objectID, String errorMsg, int accountID) {
      /* super();
       * Validate parameters 
       * Assign parameter values to attributes 
       * this.toString()
       */
  }
}