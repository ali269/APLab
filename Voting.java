import ir.huri.jcal.JalaliCalendar;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * handles a voting events
 * like designing question & choices & voting to a choice
 * and get the voting result
 * @author alireza sahragard
 * @version 1.0
 * @since 2020-3-18
 */
public class Voting{
    private int type;
    private String question;
    private ArrayList<String> choices = new ArrayList<>();
    private ArrayList<Person> voters = new ArrayList<>();
    private HashMap<String, HashSet<Vote>> listOfVotesToChoices = new HashMap<String, HashSet<Vote>>();

    /**
     * create a voting
     * @param type: declare that a person's how many could vote
     * @param question: voting question(string)
     * @param choices: voting choices(ArrayList<String>)
     */
//    public Voting(int type, String question, ArrayList<String> choices){
//        this.type = type;
//        this.question = question;
//        this.choices = choices;
//    }

    /**
     * create only question and type of voting
     * @param type
     * @param question
     */
    public Voting(int type, String question){
        this.type = type;
        this.question = question;
    }

    /**
     * create a list to all choices and
     * declare the votes to those choices
     */
//    public void createChoicesList(){
//        for (String element: choices){
//            listOfVotesToChoices.put(element, new HashSet<Vote>());
//        }
//    }

    /**
     * gets voting type
     * @return
     */
    public int getType(){
        return type;
    }

    /**
     * gets voting question
     * @return String that is question of voting
     */
    public String getQuestion(){
        return question;
    }
    /**
     * add a choice to choices
     * @param choice
     */
    public void createChoice(String choice){
        boolean flag = true;
        for (String element: choices){
            if(element.equals(choice))
                flag = false;
        }
        if(flag) {
            choices.add(choice);
            listOfVotesToChoices.put(choice, new HashSet<Vote>());
        }
        else
            System.out.println("Choice existing");
    }

    /**
     * register a person's votes
     * @param person : the vote is for him
     * @param selects: the choices that person selected
     */
    public void vote(Person person, ArrayList<String> selects){
        if(!(voters.contains(person))){
            voters.add(person);
            //System.out.println("here");
            JalaliCalendar calendar = new JalaliCalendar();
            Vote vote = new Vote(person, calendar.toString());
            for (String choice: selects){
                HashSet<Vote> votes = listOfVotesToChoices.get(choice);
                votes.add(vote);
                //System.out.println("yes");
            }
        }
        else{
            System.out.println("this person had register his/her vote");
        }
    }

    /**
     * gets the persons that they had voted
     * @return
     */
    public ArrayList<Person> getVoters(){
        return voters;
    }

    /**
     * gets the choices one can select
     * @return
     */
    public ArrayList<String> getChoices(){
        return choices;
    }

    /**
     * print all votes to all choices
     *
     * then print the selected choice
     */
    public void printVotes(){
        System.out.println("********      VOTES     **********");
        String winner = null;
        int numOfVotes = 0;
        for (String choice: choices){
            System.out.println("# " + choice);
            HashSet<Vote> votes = listOfVotesToChoices.get(choice);
            if (votes.size()>numOfVotes){
                winner = choice;
                numOfVotes = votes.size();
            }

            System.out.print("[");
            for (Vote vote: votes){
                System.out.print(vote.getPerson());
                System.out.print(" ||");
            }
            System.out.println("]");
        }
        System.out.println("\n\n\n\n");
        if(winner != null){
            System.out.println("winner:" + winner);
        }
        System.out.println("______________END_____________");
    }


}