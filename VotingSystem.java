import java.util.ArrayList;

/**
 * adds a voting handler to system and could present a voting
 *
 * @author alireza sahragard
 * @version 1.0
 * @since 2020-3-18
 */
public class VotingSystem {
    private ArrayList<Voting> votingList = new ArrayList<>();

    /**
     * create a voting
     * @param type:type of voting
     * @param question:question of voting(String)
     * @param choices:choices of voting(ArrayList<String>)
     */
    public void createVoting(int type, String question, ArrayList<String> choices){
        Voting voting = new Voting(type, question);
        for (String choice: choices){
            voting.createChoice(choice);
        }
        votingList.add(voting);
    }

    /**
     * gets voting type of voting x if not found voting return 10
     * @param index : int x
     * @return: voting type
     */
    public int getVotingType(int index){
        if(index - 1 < votingList.size() && votingList.size() != 0){
            return votingList.get(index - 1).getType();
        }
        else{
            System.out.println("voting not found");
            return 10;
        }
    }

    /**
     * gets voting x's number of choices
     * @param index: int x
     * @return int number of choices
     */
    public int getVotingSize(int index){
        if(index - 1 < votingList.size() && votingList.size() != 0){
            return votingList.get(index - 1).getChoices().size();
        }
        else{
            System.out.println("voting not found");
            return 0;
        }
    }

    /**
     * prints all voting questions
     */
    public void printVotingQuestions(){
        int i = 1;
        System.out.println("----  VOTING QUESTIONS ----");
        for (Voting voting:votingList){
            System.out.print("[" + i +"]");
            System.out.println(voting.getQuestion());
            i++;
            System.out.println("\n\n");
        }
        System.out.println("-------    end    ---------");
    }

    /**
     * print voting index's question and choices
     * @param index
     */
    public void printVoting(int index){
        if(index - 1 < votingList.size() && votingList.size() != 0){
            System.out.println("------ VOTING" + index + "-------");
            Voting voting = votingList.get(index - 1);
            System.out.println("QUESTION:");
            System.out.println(voting.getQuestion());
            ArrayList<String> choices = voting.getChoices();
            System.out.println("CHOICES:");
            int i = 1;
            for (String choice: choices){
                System.out.print("[" + i + "]");
                System.out.println(choice);
                i++;
            }
            System.out.println("------       end       ------");
        }
        else{
            System.out.println("there is no voting with that number");
        }
    }

    /**
     * add a new vote to voting
     * @param index of voting(int)
     * @param person :voter(Person)
     * @param choices:the choices one select(String)
     */
    public void vote(int index, Person person, ArrayList<String> choices){
        if(index - 1 < votingList.size() && votingList.size() != 0){
            Voting voting = votingList.get(index - 1);
            voting.vote(person, choices);
        }
        else{
            System.out.println("there is no voting with that index");
        }
    }

    /**
     * print the result of voting x
     * @param index:int x
     */
    public void printResults(int index){
        if(index - 1 < votingList.size() && votingList.size() != 0){
            Voting voting = votingList.get(index - 1);
            voting.printVotes();
        }
        else{
            System.out.println("there is no voting with that index");
        }
    }

    /**
     * print all of persons that they have voted to voting x
     * @param index:int x
     */
    public void printVoters(int index){
        if(index - 1 < votingList.size() && votingList.size() != 0){
            ArrayList<Person> voters = votingList.get(index - 1).getVoters();
            for (Person voter: voters){
                System.out.println("first name:" + voter.getFirstName());
                System.out.println("last name:" + voter.getLastName());
            }
        }
        else{
            System.out.println("there is no voting with that index");
        }
    }
}
