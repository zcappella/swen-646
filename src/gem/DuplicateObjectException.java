package gem;

/**
 * A class for implementing the user-defined exception when encountering duplicate objects
 *
 * @author Zachary Cappella
 */

public class DuplicateObjectException extends RuntimeException {

  private String objectID;    // the ID of the object that already exists
  private int accountID;      // the ID of the account that tried to add a duplicate equipment object

  // format the error message into a presentable string
  public String toString() {
      /*
       * return "The object with ID " + objectID + " already exists!"
       */
     return null;
  }

  // DuplicateObjectException constructor
  public DuplicateObjectException(String objectID) {
      /* super();
       * Validate parameters 
       * Assign parameter values to attributes 
       * this.toString()
       */
  }

  // DuplicateObjectException constructor
  public DuplicateObjectException(String objectID, int accountID) {
      /* super();
       * Validate parameters 
       * Assign parameter values to attributes 
       * this.toString()
       */
  }
}