public class Owner {
  private String name;  // the name of the account owner
  private String emailAddress;  // the email address of the account owner
  private String phoneNumber;  // the phone number of the account owner
  private Address address;  // the address of the account owner

  // Owner constructor
  public Owner(String name, String emailAddress, String phoneNumber, Address address) {
	  /* Validate parameters
       * if any invalid or missing parameters, throw IllegalArgumentException
	   * Assign parameter values to attributes 
	   */
  }

  // get the owner's name
  public String getName() {
     /*
      * return this.name
      */
     return null;
  }

  // get the owner's email address
  public String getEmailAddress() {
     /*
      * return this.emailAddress
      */
     return null;
  }

  // get the owner's phone number
  public String getPhoneNumber() {
     /*
      * return this.phoneNumber
      */
     return null;
  }

  // get the owner's address
  public Address getAddress() {
     /*
      * return this.address
      */
     return null;
  }
  
  // set the owner's name
  public void setName(String name) {
	  /*
	   * validate parameters
	   * if the name is the same as the current name, throw IllegalArgumentException
	   * else, set the name
	   */
  }

  // set the owner's email address
  public void setEmailAddress(String email) {
	  /*
	   * validate parameters
	   * if the email address is the same as the current email, throw IllegalArgumentException
	   * else, set the email
	   */
  }

  // set the owner's phone number
  public void setPhoneNumber(String phoneNumber) {
	  /*
	   * validate parameters
	   * if the phone mumber is the same as the current number, throw IllegalArgumentException
	   * else, set the phone number
	   */
  }

  // set the owner's phone number
  public void setAddress(String zipcode) {
      /*
       * validate parameters
       * if the zipcode is the same as the current zipcode, throw IllegalArgumentException
       * else, set the address by getting a clone of the correct
       * address associated to the zipcode
       */
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
	  /*
	   * return new Owner(this.name, ...)
	   */
	  return null;
  }
}