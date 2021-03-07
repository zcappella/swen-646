package gem;

/**
 * A class holding the information for a stepper machine
 *
 * @author Zachary Cappella
 */

public class Stepper extends Equipment {

  private boolean heartMonitor;  // a value indicating whether or not the piece of equipment has a heart monitor
  private int height;  // the height of the stepper
  
  // Stepper constructor
  public Stepper(String serialNumber, String brand, String model, double equipPrice, boolean heartMon, int height) {
	  super(serialNumber, brand, model, equipPrice);
	  /*
	   * call Equipment constructor
	   * Validate parameters
       * if any invalid or missing parameters, throw IllegalArgumentException
	   * Assign parameter values to attributes
	   */
  }

  // get the equipment's heart monitor value
  public int getHeartMonitor() {
     /*
      * return this.heartMonitor
      */
     return 0;
  }

  // get the equipment's height
  public int getHeight() {
     /*
      * return this.height
      */
     return 0;
  }

  // calculate the shipping costs
  public double calculateShipping() {
	  /*
	   * return super.calculateShipping plus 9.99 if height > 60inches
	   */
	  return 0.0;
  }
  
 // format the stepper's information into a presentable string
 public String toString() {
	  /*
	   * return super.toString() + "<heartMonitor>" + "<height>"
	   */
	  return null;
 }

  // create and return a copy of the stepper object
  public Stepper clone() {
	  /*
	   * return new Stepper(this.serialNumber, ...)
	   */
	  return null;
  }
}