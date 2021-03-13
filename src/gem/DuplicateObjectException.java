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
     if (this.accountID > 0)
    	 return this.getClass().getSimpleName() +
                "The object with ID " +
                this.objectID +
                " already exists, and the account "+
                this.accountID +
                " tried to add it!";
     else
    	return this.getClass().getSimpleName() +
               "The object with ID " +
               this.objectID +
               " already exists!";
  }

  // DuplicateObjectException constructor
  public DuplicateObjectException(String objectID) {
      super("The object with ID " +
            objectID +
            " already exists!");
      this.objectID = objectID;
  }

  // DuplicateObjectException constructor
  public DuplicateObjectException(String objectID, int accountID) {
      super("The object with ID " +
            objectID +
            " already exists, and the account "+
            String.valueOf(accountID) +
            " tried to add it!");
      this.objectID = objectID;
      this.accountID = accountID;
  }
}