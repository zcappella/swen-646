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
      return this.getClass().getSimpleName() + "The account with file name " + this.fileName + " could not be loaded because " + this.errorMsg;
  }

  // InvalidLoadException constructor
  public InvalidLoadException(String fileName, String errorMsg) {
	  super();
      if (fileName == null || fileName.length() == 0 || errorMsg == null || errorMsg.length() == 0)
          throw new IllegalArgumentException("InvalidLoadException values cannot be null/zero values!");
      this.fileName = fileName;
      this.errorMsg = errorMsg;
      System.out.println(this.toString());
  }
}