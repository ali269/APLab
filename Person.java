/**
 * class that create a person info
 *
 * @author  alireza sahragard
 * @version 2020-3-18
 * @since 2020-3-18
 */
public class Person{
    private String firstName;
    private String lastName;

    /**
     * set's a person info
     * @param fName:first name String
     * @param lName: last name String
     */
    public Person(String fName, String lName){
        firstName = fName;
        lastName = lName;
    }

    /**
     *
     * @return a string that contains a person first name
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     *
     * @return a string that contains person last name
     */
    public String getLastName(){
        return lastName;
    }

    /**
     *
     * @return a string that contains person all info
     */
    public String toString(){
        return firstName + lastName;
    }
}