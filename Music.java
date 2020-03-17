import java.util.Date;

/**
 * class that save a music's address & singer & publish date
 * @author alireza sahragard
 * @version 1.0
 * @since 2020-3-16
 */
public class Music {
    /**
     * saves the music file address
     */
    private String musicFileAddress;
    /**
     * saves the singer
     */
    private String singer;
    /**
     * saves the published year
     */
    private Date publishingYear;

    /**
     * sets a new music only with address & date
     * @param name
     * @param singer
     */
    public Music(String name, String singer){
        musicFileAddress = name;
        this.singer = singer;
    }

    /**
     * getMusicFileAddress
     * @return gets a string that contain music address
     */
    public String getMusicFileAddress(){
        return musicFileAddress;
    }

    /**
     * getSinger
     * @return gets a string that contains singer name
     */
    public String getSinger(){
        return singer;
    }

    /**
     * getPublishingYear
     * @return a Date that contains the date of publishing
     */
    public Date getPublishingYear(){
        return publishingYear;
    }

    /**
     * sets the publish year
     * @param date
     */
    public void setPublishingYear(Date date){
        publishingYear = date;
    }
    /**
     * check if this Music equals music or not
     * @param music
     * @return if they same returns true else false
     */
    public boolean equals(Music music){
        if (this == music)
            return true;
        else if(this.musicFileAddress.equals(music.getMusicFileAddress()) && this.singer.equals(music.getSinger()))
            return true;
        else
            return false;
    }
    public boolean equals(String address, String singer){
        if(musicFileAddress.equals(address) && this.singer.equals(singer))
            return true;
        else
            return false;
    }

    /**
     * prints a Music
     */
    public void print(){
        System.out.println("---  ----   ----   ----   ----");
        System.out.println("Address:" + musicFileAddress);
        System.out.println("Singer:" + singer);
        System.out.println("Date:" + publishingYear.toString());
    }
}
