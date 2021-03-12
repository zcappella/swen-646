package gem;

import java.util.Map;

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
	  
      // validate parameters
      if (height <= 0)
          throw new IllegalArgumentException("Stepper values must be non-zero values!");
    
      this.heartMonitor = heartMon;
      this.height = height;
  }

  // Stepper constructor
  public Stepper(Map yamlContent) {
      super((String) yamlContent.get("serialNumber"),
            (String) yamlContent.get("brand"),
            (String) yamlContent.get("model"),
            (double) yamlContent.get("equipmentPrice"));
      
      boolean heartMon = (boolean) yamlContent.get("heartMonitor");
      height = (int) yamlContent.get("height");
      // validate parameters
      if (height <= 0)
          throw new IllegalArgumentException("Stepper values must be non-zero values!");
    
      this.heartMonitor = heartMon;
      this.height = height;
  }

  // get the equipment's heart monitor value
  public boolean getHeartMonitor() {
     return this.heartMonitor;
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
  
 // format the stepper's information into a presentable string
 public String toString() {
	  return super.toString() + " : " +
             String.valueOf(this.heartMonitor) + " : " +
             String.valueOf(this.height);
 }

 // format the equipment's information into a YAML format
  public Map generateFileContent() {
     Map<String, Object> data = super.generateFileContent();
     data.put("heartMonitor", this.heartMonitor);
     data.put("height", this.height);
     return data;
  }

  // create and return a copy of the stepper object
  public Stepper clone() {
	  return new Stepper(
        this.serialNumber,
        this.brand,
        this.model,
        this.equipmentPrice,
        this.heartMonitor,
        this.height);
  }
}