package KsiegarniaFX;

/**
 * Created by Adam on 08.01.2017.
 */
public class Ksiazka {
    private int id;
    private boolean access=true;
    private String title,author,isbn;

    public Ksiazka(int _id, String _title, String _author, String _isbn){
        this.id=_id;
        this.title=_title;
        this.author=_author;
        this.isbn=_isbn;
        this.access=true;
    }

    public void changeAccess(boolean status){
        this.access=status;
    }

    public String getTitle(){
        return this.title;
    }

    public int getId(){
        return this.id;
    }
}
