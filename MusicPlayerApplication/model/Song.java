package MusicPlayerApplication.model;

public class Song {
    private String title;
    private String singer;
    private String path;


    public Song(String title, String singer, String path){
        this.title = title;
        this.singer = singer;
        this.path = path;
    }

    public String getTitle(){
        return title;
    }

    public String getSinger(){
        return singer;
    }

    public String getPath(){
        return path;
    }
}
