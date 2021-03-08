package gem;

/**
 * A class holding the information for an Account Owner
 *
 * @author Zachary Cappella
 */

public class Owner {
  private String name;  // the name of the account owner
  private String emailAddress;  // the email address of the account owner
  private String phoneNumber;  // the phone number of the account owner
  private Address address;  // the address of the account owner

  // Owner constructor
  public Owner(String name, String emailAddress, String phoneNumber, Address address) {
	  // validate parameters
      if (name == null || name.length() == 0 || emailAddress == null || emailAddress.length() == 0
              || phoneNumber == null || phoneNumber.length() == 0 || address == null)
          throw new IllegalArgumentException("Owner values cannot be null/zero values!");

      this.name = name;
      this.emailAddress = emailAddress;
      this.phoneNumber = phoneNumber;
      this.address = address.clone();
  }

  // get the owner's name
  public String getName() {
     return this.name;
  }

  // get the owner's email address
  public String getEmailAddress() {
     return this.emailAddress;
  }

  // get the owner's phone number
  public String getPhoneNumber() {
     return this.phoneNumber;
  }

  // get the owner's address
  public Address getAddress() {
     return this.address;
  }
  
  // set the owner's name
  public void setName(String name) {
      if (name == null || name == this.name)
          throw new IllegalArgumentException("Name cannot be null or the same as the current name!");

      this.name = name;
  }

  // set the owner's email address
  public void setEmailAddress(String email) {
	  if (email == null || email == this.emailAddress)
          throw new IllegalArgumentException("Email address cannot be null or the same as the current email address!");

      this.emailAddress = email;
  }

  // set the owner's phone number
  public void setPhoneNumber(String phoneNumber) {
	  if (phoneNumber == null || phoneNumber == this.phoneNumber)
          throw new IllegalArgumentException("Phone number cannot be null or the same as the current phone number!");

      this.phoneNumber = phoneNumber;
  }

  // set the owner's address
  public void setAddress(Address address) {
      if (address == null || address.toString() == this.address.toString())
          throw new IllegalArgumentException("Address cannot be null or the same as the current address!");

      this.address = address.clone();
  }

  // format the owner's information into a presentable string
  public String toString() {
	  /*
	   * return "<name>" + "<emailAddress>" + "phoneNumber" + "Address.toString()"
	   */
	  return null;
  }

  // create and return a copy of the owner information
  public Owner clone() {
	  return new Owner(this.name, this.emailAddress, this.phoneNumber, this.address);
  }
}