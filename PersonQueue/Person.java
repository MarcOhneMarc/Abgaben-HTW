/**
 * Class to create a person
 */
public class Person {
    //initialize attributes
    public String firstname;
    public String lastname;
    
    /**
     * Constructor to create a person
     */
    public Person(String firstname, String nachname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
    
    /**
     * get-Method to get the firstname
     */
    public String getVorname() {
        return firstname;
    }
    
    /**
     * get-Method to get the lastname
     */
    public String getNachname() {
        return lastname;
    }
}