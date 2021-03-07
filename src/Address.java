public class Address {

  private String zipcode;  // the zipcode of the address
  private String street;  // the street of the address
  private String city;  // the city of the address
  private String state;  // the state of the address
  
  // Address constructor
  public Address(String zipcode, String street, String city, String state) {
	  /* Validate parameters
       * if any invalid or missing parameters, throw IllegalArgumentException
	   * Assign parameter values to attributes 
	   */
  }

  // set the address's zipcode
  public void setZipcode(String zipcode) {
     /*
      * if the zipcode is the same as the current state, throw IllegalArgumentException
      * else, set the zipcode attribute
      */
  }

  // get the address's zipcode
  public String getZipcode() {
     /*
      * return this.zipcode
      */
     return null;
  }

  // set the address's street
  public void setStreet(String street) {
     /*
      * if the state is the same as the current state, throw IllegalArgumentException
      * else, set the street attribute
      */
  }

  // get the address's street
  public String getStreet() {
     /*
      * return this.street
      */
     return null;
  }

  // set the address's city
  public void setCity(String city) {
     /*
      * if the city is the same as the current state, throw IllegalArgumentException
      * else, set the city attribute
      */
  }

  // get the address's city
  public String getCity() {
     /*
      * return this.city
      */
     return null;
  }

  // set the address's state
  public void setState(String state) {
     /*
      * if the state is the same as the current state, throw IllegalArgumentException
      * else, set the state attribute
      */
  }

  // get the address's state
  public String getState() {
     /*
      * return this.state
      */
     return null;
  }

  // format the address into a presentable string
  public String toString() {
	  /*
	   * return "<zipcode>" + "<street>" + "<city>" + "<state>"
	   */
	  return null;
  }

  // create and return a copy of the address
  public Address clone() {
	  /*
	   * return new Address(this.zipcode, ...)
	   */
	  return null;
  }
}