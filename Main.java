import java.io.Reader;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        VotingSystem vm = new VotingSystem();
        boolean flag = true;
        while(flag){
            int processKey;
            System.out.println("please choose the process key:");
            System.out.println("[1] add a voting");
            System.out.println("[2] vote");
            System.out.println("[3] print voting questions");
            System.out.println("[4] print voting");
            System.out.println("[5] print result");
            System.out.println("[6] print voters");
            System.out.println("[0] exit");
            processKey = scanner.nextInt();
            switch (processKey){
                case 1:{
                    int type;
                    System.out.println("please enter voting type:");
                    type = scanner.nextInt();
                    System.out.println("please enter voting question:");
                    String ques = reader.readLine();
                    ArrayList<String> choi = new ArrayList<>();
                    boolean s = true;
                    while(s){
                        int process;
                        System.out.println("[1] add a choice");
                        System.out.println("[2] exit");
                        process = scanner.nextInt();
                        switch (process){
                            case 1:{
                                System.out.println("please enter choice:");
                                String c = reader.readLine();
                                choi.add(c);
                                break;
                            }
                            case 2:{
                                s = false;
                                break;
                            }
                        }
                    }
                    vm.createVoting(type, ques, choi);
                    break;
                }
                case 2:{
                    System.out.println("please enter a voting number");
                    int votx = scanner.nextInt();
                    System.out.println("please enter voter's first name:");
                    String fName = reader.readLine();
                    System.out.println("please enter voter's last name:");
                    String lName = reader.readLine();
                    Person person = new Person(fName, lName);
                    ArrayList<String> selects = new ArrayList<>();
                    if(vm.getVotingType(votx) == 0){
                        System.out.println("please enter your choice");
                        String sel = reader.readLine();
                        selects.add(sel);
                    }
                    else{
                        boolean s = true;
                        while(s && selects.size() < vm.getVotingSize(votx)){
                            int process;
                            System.out.println("[1] add a vote");
                            System.out.println("[2] exit");
                            process = scanner.nextInt();
                            switch (process){
                                case 1:{
                                    System.out.println("please enter a choice:");
                                    String c = reader.readLine();
                                    selects.add(c);
                                    break;
                                }
                                case 2:{
                                    s = false;
                                    break;
                                }
                            }
                        }
                    }
                    vm.vote(votx, person, selects);
                    break;
                }
                case 3:{
                    vm.printVotingQuestions();
                    break;
                }
                case 4:{
                    System.out.println("please enter a voting number");
                    int votx = scanner.nextInt();
                    vm.printVoting(votx);
                    break;
                }
                case 5:{
                    System.out.println("please enter a voting number");
                    int votx = scanner.nextInt();
                    vm.printResults(votx);
                    break;
                }
                case 6:{
                    System.out.println("please enter a voting number");
                    int votx = scanner.nextInt();
                    vm.printVoters(votx);
                    break;
                }
                case 0:{
                    flag = false;
                    break;
                }
            }
        }
    }
}