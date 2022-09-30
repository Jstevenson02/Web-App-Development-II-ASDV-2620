package asdv.slcc.beans;
import java.util.ArrayList;

/**
 *
 * @author jacob
 */
public class Authors implements VirtualDatabase {

    private ArrayList<Author> authorList;

    public Authors() {
        authorList = new ArrayList();
        populateAuthorList();
    }

    private void populateAuthorList() {
        System.out.println("initializng authors");
        authorList = new ArrayList<>();
        authorList.add(new Author("Josh", "Juneau",  "Helo"));
        authorList.add(new Author("Carl", "Dea", "Helo"));
        authorList.add(new Author("Mark", "Beaty", "Helo"));
        authorList.add(new Author("John", "O'Conner", "Helo"));
        authorList.add(new Author("Freddy", "Guime", "Helo"));
    }

    @Override
    public void addAuthor(Author a) {
        this.authorList.add(a);
    }

    @Override
    public void removeAuthor(Author a) {
        this.authorList.remove( a);
    }

    @Override
    public ArrayList<Author> getList() {
        return this.authorList;
    }
}
