public class StationaryBike extends Equipment {

  private int resistanceLevels;  // the number of resistance levels available for the piece of equipment
  private int height;  // the height of the stationary bike
  
  // Stationary Bike constructor
  public StationaryBike(String serialNumber, String brand, String model, double equipPrice, int resistanceLevels, int height) {
	  super(serialNumber, brand, model, equipPrice);
	  /*
	   * call Equipment constructor
	   * Validate parameters
       * if any invalid or missing parameters, throw IllegalArgumentException
	   * Assign parameter values to attributes
	   */
  }

  // get the equipment's resistance levels
  public int getResistanceLevels() {
     /*
      * return this.resistanceLevels
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
  
  // format the stationary bike's information into a presentable string
  public String toString() {
	  /*
	   * return super.toString() + "<resistanceLevels>" + "<height>"
	   */
	  return null;
  }

  // create and return a copy of the stationary bike object
  public StationaryBike clone() {
	  /*
	   * return new StationaryBike(this.serialNumber, ...)
	   */
	  return null;
  }
}