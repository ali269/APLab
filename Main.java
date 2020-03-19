import java.text.ParseException;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Main {
    public static Music setAMusic(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Address:");
        String address = scanner.next();
        System.out.println("singer:");
        String singer = scanner.next();
        Music music = new Music(address, singer);
        return music;
    }
    public static void controlList(MusicCollection musics, MusicCollection favorites){
        boolean flag = true;
        while(flag){
            Scanner scanner = new Scanner(System.in);
            System.out.println("please choose process:");
            System.out.println("[1] add a music");
            System.out.println("[2] remove a music");
            System.out.println("[3] print musics");
            System.out.println("[4] search music");
            System.out.println("[5] add to favorites");
            System.out.println("[6] list favorites");
            System.out.println("[7] remove from favorites");
            System.out.println("[0] exit");
            int processKey = scanner.nextInt();
            switch (processKey){
                case 1:{
                    Music music = setAMusic();
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    System.out.println("Date:");
                    String day = scanner.next();
                    Date date = new Date();
                    try{
                        date = format.parse(day);
                    }catch (ParseException e){
                        System.out.println("date format is wrong");
                    }

                    music.setPublishingYear(date);
                    musics.addMusic(music);
                    break;
                }
                case 2:{
                   Music music = setAMusic();
                   musics.removeMusic(music);
                   break;
                }
                case 3:{
                    System.out.println("         *******" + musics.getType() + "*******");
                    musics.listMusics();
                    System.out.println("____________ list end ____________");
                    break;
                }
                case 4:{
                    musics.searchMusic(setAMusic());
                    break;
                }
                case 5:{
                    Music music = setAMusic();
                    Music musicToAdd = musics.searchMusic(music);
                    if(music == musicToAdd){
                        System.out.println("not found");
                    }
                    else{
                        favorites.addMusic(musicToAdd);
                    }
                    break;
                }
                case 6:{
                    System.out.println("      *******  favorite list *******");
                    favorites.listMusics();
                    System.out.println("           ///// list end //////");
                    break;
                }
                case 7:{
                    Music music = setAMusic();
                    favorites.removeMusic(music);
                    break;
                }
                case 0:{
                    flag = false;
                    break;
                }
            }
        }
    }

    public static void main(String[] args){
        MusicCollection[] collections = new MusicCollection[5];
        collections[0] = new MusicCollection("jazz");
        collections[1] = new MusicCollection("pop");
        collections[2] = new MusicCollection("rock");
        collections[3] = new MusicCollection("country");
        collections[4] = new MusicCollection("favorites");
        boolean flag = true;
        while(flag){
            int processKey;
            Scanner scanner = new Scanner(System.in);
            System.out.println("please choose the choice:");
            System.out.println("[1] jazz music");
            System.out.println("[2] pop music");
            System.out.println("[3] rock music");
            System.out.println("[4] country music");
            System.out.println("[0] exit");
            processKey = scanner.nextInt();
            switch (processKey){
                case 0:{
                    flag = false;
                    break;
                }
                case 1:{
                    controlList(collections[0], collections[4]);
                    break;
                }
                case 2:{
                    controlList(collections[1], collections[4]);
                    break;
                }
                case 3:{
                    controlList(collections[2], collections[4]);
                    break;
                }
                case 4: {
                    controlList(collections[3], collections[4]);
                    break;
                }
                default:{
                    System.out.println("invalid input");
                    break;
                }

            }
        }
    }
}
