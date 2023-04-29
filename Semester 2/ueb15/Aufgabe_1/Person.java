/**
 * Class to create a person
 */
public class Person {
    //initialize attributes
    public String firstname;
    public String lastname;
    public Person next;
    
    /**
     * Constructor to create a person
     */
    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void setNext(Person person){
        this.next = person;
    }
    public Person getNext(){
        return this.next;
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