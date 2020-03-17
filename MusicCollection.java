import java.util.ArrayList;
import java.util.Iterator;

/**
 * a class organize our musics
 * @author alireza sahragard
 * @version 1.0
 * @since 2020.3.17
 */
public class MusicCollection{
    private String type;
    private ArrayList<Music> musics = new ArrayList<Music>();

    /**
     * sets music collection with type
     * @param type
     */
    public MusicCollection(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }
    /**
     * adds a music
     * @param music
     */
    public void addMusic(Music music){
        boolean flag = true;
        for (Music music1:musics){
            if (music1.equals(music))
                flag = false;
        }
        if(flag)
            musics.add(music);
        else
            System.out.println("music exist");
    }

    /**
     * removes a music from list
     * @param music
     */
    public void removeMusic(Music music){
        Iterator<Music> iterator = musics.iterator();
        while(iterator.hasNext()){
            Music music1 = iterator.next();
            if(music1.equals(music))
                iterator.remove();
        }
    }

    /**
     * returns number of musics in the list
     * @return
     */
    public int getNumberOfMusics(){
        return musics.size();
    }

    /**
     * prints all of the musics
     */
    public void listMusics(){
        System.out.println("                 MUSICS");
        for (Music music: musics){
            music.print();
        }
    }

    /**
     * search music if found print it
     * @param music1
     */
    public Music searchMusic(Music music1){
        for(Music music: musics){
            if (music.equals(music1)) {
                music.print();
                return  music;
            }
        }
        return music1;
    }
}