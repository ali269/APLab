public class Student {
    private String firstName;
    private String lastName;
    private String id;
    private int grade;
    public Student(String fName, String lname, String sID){
        firstName = fName;
        lastName = lname;
        id = sID;
        grade = 0;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getId(){
        return id;
    }
    public int getGrade(){
        return grade;
    }
    public void setFirstName(String fname){
        firstName = fname;
    }
    public void setLastName(String lname){
        lastName = lname;
    }
    public void setId(String i){
         id = i;
    }
    public void setGrade(int gra){
        grade = gra;
    }
    public void print(){
        System.out.println(lastName + " ID :" + id + "GRADE :" + grade);
    }

}
