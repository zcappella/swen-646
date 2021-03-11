package gem;

import java.util.Map;

/**
 * A class holding the information for a stationary bike
 *
 * @author Zachary Cappella
 */

public class StationaryBike extends Equipment {

  private int resistanceLevels;  // the number of resistance levels available for the piece of equipment
  private int height;  // the height of the stationary bike
  
  // Stationary Bike constructor
  public StationaryBike(String serialNumber, String brand, String model, double equipPrice, int resistanceLevels, int height) {
	  super(serialNumber, brand, model, equipPrice);
	  
      // validate parameters
      if (resistanceLevels <= 0 || height <= 0)
          throw new IllegalArgumentException("Stationary Bike values must be non-zero values!");
    
      this.resistanceLevels = resistanceLevels;
      this.height = height;
  }

  // Stationary Bike constructor
  public StationaryBike(Map yamlContent) {
      super((String) yamlContent.get("serialNumber"),
            (String) yamlContent.get("brand"),
            (String) yamlContent.get("model"),
            (double) yamlContent.get("equipmentPrice"));
      
      resistanceLevels = (int) yamlContent.get("resistanceLevels");
      height = (int) yamlContent.get("height");
      // validate parameters
      if (resistanceLevels <= 0 || height <= 0)
          throw new IllegalArgumentException("Stationary Bike values must be non-zero values!");
    
      this.resistanceLevels = resistanceLevels;
      this.height = height;
  }

  // get the equipment's resistance levels
  public int getResistanceLevels() {
     return this.resistanceLevels;
  }

  // get the equipment's height
  public int getHeight() {
     return this.height;
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