package gem;

/**
 * A class holding the information for a treadmill
 *
 * @author Zachary Cappella
 */

public class Treadmill extends Equipment {

  private float maxSpeed;  // the maximum speed the piece of equipment can reach
  
  // Treadmill constructor
  public Treadmill(String serialNumber, String brand, String model, double equipPrice, float maxSpeed) {
	  super(serialNumber, brand, model, equipPrice);
	  /*
	   * call Equipment constructor
	   * Validate parameters 
       * if any invalid or missing parameters, throw IllegalArgumentException
	   * Assign parameter values to attributes
	   */
  }

  // get the equipment's max speed
  public float getMaxSpeed() {
     /*
      * return this.maxSpeed
      */
     return 0;
  }
  
  // format the treadmill's information into a presentable string
  public String toString() {
	  /*
	   * return super.toString() + "<maxSpeed>"
	   */
	  return null;
  }
 
  // create and return a copy of the treadmill object
  public Treadmill clone() {
	  /*
	   * return new Treadmill(this.serialNumber, ...)
	   */
	  return null;
  }
}