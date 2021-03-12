package gem;

import java.util.Map;

/**
 * A class holding the information for a treadmill
 *
 * @author Zachary Cappella
 */

public class Treadmill extends Equipment {

  private double maxSpeed;  // the maximum speed the piece of equipment can reach
  
  // Treadmill constructor
  public Treadmill(String serialNumber, String brand, String model, double equipPrice, double maxSpeed) {
      super(serialNumber, brand, model, equipPrice);
	  
      // validate parameters
      if (maxSpeed <= 0.0)
          throw new IllegalArgumentException("Treadmill values must be non-zero values!");
    
      this.maxSpeed = maxSpeed;
  }

  // Treadmill constructor
  public Treadmill(Map yamlContent) {
      super((String) yamlContent.get("serialNumber"),
            (String) yamlContent.get("brand"),
            (String) yamlContent.get("model"),
            (double) yamlContent.get("equipmentPrice"));
      
      maxSpeed = (double) yamlContent.get("maxSpeed");
      // validate parameters
      if (maxSpeed <= 0.0)
          throw new IllegalArgumentException("Treadmill values must be non-zero values!");
    
      this.maxSpeed = maxSpeed;
  }

  // get the equipment's max speed
  public double getMaxSpeed() {
     return this.maxSpeed;
  }
  
  // format the treadmill's information into a presentable string
  public String toString() {
	  return super.toString() + " : " +
             String.valueOf(this.maxSpeed);
  }

  // format the equipment's information into a YAML format
  public Map generateFileContent() {
     Map<String, Object> data = super.generateFileContent();
     data.put("maxSpeed", this.maxSpeed);
     return data;
  }
 
  // create and return a copy of the treadmill object
  public Treadmill clone() {
	  return new Treadmill(
        this.serialNumber,
        this.brand,
        this.model,
        this.equipmentPrice,
        this.maxSpeed);
  }
}