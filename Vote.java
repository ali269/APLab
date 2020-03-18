import java.util.Objects;

/**
 * class that define a specific vote
 * @author alireza sahragard
 * @version 1.0
 * @since 2020-3-18
 */
public class Vote{
    private Person person;
    private String date;

    /**
     * create a person's vote
     * @param person
     * @param date
     */
    public Vote(Person person, String date){
        this.person = person;
        this.date = date;
    }

    /**
     * gets a person that this vote is for him
     * @return Person
     */
    public Person getPerson(){
        return person;
    }

    /**
     * return the date of this vote
     * @return String that contains date of vote
     */
    public String getDate(){
        return date;
    }

    /**
     * check two votes
     * @param object
     * @return if same return true else return false
     */
    public boolean equals(Object object){
        if(this == object)
            return true;
        else if(!(object instanceof Vote))
            return false;
        else{
            return person.equals(((Vote) object).getPerson()) &&
                    date.equals(((Vote)object).getDate());
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, date);
    }
}
