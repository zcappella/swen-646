package gem;

/**
 * A class for implementing the user-defined exception when unable to load an account
 *
 * @author Zachary Cappella
 */

public class InvalidLoadException extends RuntimeException {

  private String fileName;  // the name of the file that could not be loaded
  private String errorMsg;    // the detailed reason why the file could not be loaded

  // format the error message into a presentable string
  public String toString() {
      return this.getClass().getSimpleName() +
             " The account with file name " +
             this.fileName +
             " could not be loaded because " +
             this.errorMsg;
  }

  // InvalidLoadException constructor
  public InvalidLoadException(String fileName, String errorMsg) {
	  super("The account with file name " +
            fileName +
            " could not be loaded because " +
            errorMsg);
      this.fileName = fileName;
      this.errorMsg = errorMsg;
  }
}