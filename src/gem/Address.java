
package gem;

import java.util.Map;

/**
 * A class holding the information for an Owner's address
 *
 * @author Zachary Cappella
 */
public class Address {

  private String zipcode;  // the zipcode of the address
  private String street;  // the street of the address
  private String city;  // the city of the address
  private String state;  // the state of the address
  
  // Address constructor
  public Address(String zipcode, String street, String city, String state) {
	 // Ensure that none of the params are null or empty strings
     if (street == null || city == null || state == null || zipcode == null
            || street.length() <= 0 || city.length() <= 0 || state.length() <= 0 || zipcode.length() <= 0)
            throw new IllegalArgumentException("Address values cannot be null/empty strings!");

        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
  }

  // Address constructor
  public Address(Map yamlContent) {
     // Ensure that none of the params are null or empty strings
     street = String.valueOf(yamlContent.get("zipcode"));
     city = (String) yamlContent.get("street");
     state = (String) yamlContent.get("city");
     zipcode = (String) yamlContent.get("state");
     if (street == null || city == null || state == null || zipcode == null
            || street.length() <= 0 || city.length() <= 0 || state.length() <= 0 || zipcode.length() <= 0)
            throw new IllegalArgumentException("Address values cannot be null/empty strings!");

        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
  }

  // set the address's zipcode
  public void setZipcode(String zipcode) {
     if (zipcode == null || zipcode.length() <= 0)
        throw new IllegalArgumentException("Zipcode cannot be null/empty string!");

     this.zipcode = zipcode;
  }

  // get the address's zipcode
  public String getZipcode() {
     return this.zipcode;
  }

  // set the address's street
  public void setStreet(String street) {
     if (street == null || street.length() <= 0)
        throw new IllegalArgumentException("Street cannot be null/empty string!");

     this.street = street;
  }

  // get the address's street
  public String getStreet() {
     return this.street;
  }

  // set the address's city
  public void setCity(String city) {
     if (city == null || city.length() <= 0)
        throw new IllegalArgumentException("City cannot be null/empty string!");

     this.city = city;
  }

  // get the address's city
  public String getCity() {
     return this.city;
  }

  // set the address's state
  public void setState(String state) {
     if (state == null || state.length() <= 0)
        throw new IllegalArgumentException("State cannot be null/empty string!");

     this.state = state;
  }

  // get the address's state
  public String getState() {
     return this.state;
  }

  // format the address into a presentable string
  public String toString() {
	  return this.zipcode + " : " +
             this.street + " : " +
             this.city + " : " +
             this.state;
  }

  // create and return a copy of the address
  public Address clone() {
	  return new Address(
            this.zipcode,
            this.street,
            this.city,
            this.state);
  }
}