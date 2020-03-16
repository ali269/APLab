/**
 * the lab class is a class that controls
 * students of a class could add, remove, get -
 * average grade of them
 *
 * @author alireza sahragard
 * @version 1.0
 */
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Lab {
    private ArrayList<Student> students = new ArrayList<Student>();
    private int avg;
    private String day;
    private int capacity;
    private int currentSize;
    public Lab(int cap, String d){
        capacity = cap;
        day = d;
    }

    /**
     *
     * @param std gets student and add it to the lab
     */
    public void enrollStudent(Student std){

        if(currentSize < capacity){
            students.add(std);
            currentSize++;
        }
        else{
            System.out.println("Lab is full!!!");
        }
    }

    /**
     * prints students of lab
     */
    public void print(){
        for(int i = 0; i < students.size(); i++){
            System.out.println("std fname:" + students.get(i).getFirstName()
            + " std id: " + students.get(i).getId()
            + " std grade:"+ students.get(i).getGrade());
        }
        System.out.println("Lab AVG:" + avg);
    }

    /**
     * gets the student that they're in lab
     * @return students : those who are in the lab
     */
    public ArrayList<Student> getStudents(){
        return students;
    }

    /**
     * set the students those are in the lab
     * @param students they're in the lab
     */
    public void setStudents(ArrayList<Student> students){
        this.students = students;
    }

    /**
     * gets the average grade of class
     * @return avg is the average grade of class
     */
    public int getAvg() {
        return avg;
    }

    /**
     * calculates the average grade of class
     */
    public void calculateAvg() {
        int sum = 0;
        for(int i = 0; i < students.size(); i++)
            sum += students.get(i).getGrade();
        avg = sum / capacity;
    }

    /**
     * gets the day in whitch lab will hold
     * @return day the Day in whitch lab will hold
     */
    public String getDay() {
        return day;
    }

    /**
     * sets the day in whitch lab will hold
     * @param day the Day in whitch lab will hold
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * gets the capacity of lab
     * @return the capacity of lab
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * sets the capacity of lab
     * @param capacity : the Capacity of lab
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}

