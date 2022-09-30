package asdv.slcc.utilities;

import asdv.slcc.beans.Author;
import asdv.slcc.beans.Authors;
import asdv.slcc.beans.VirtualDatabase;
import java.io.Serializable;
import java.util.Locale;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named(value = "authorController")
@SessionScoped
public class AuthorController implements Serializable {

    private String firstName;
    private String lastName;
    private String bio;
    private VirtualDatabase vdb;

    public AuthorController() {
        vdb = new Authors();
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public VirtualDatabase getVdb() {
        return vdb;
    }

    public String greekLocale() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("el"));
        return null;
    }

    public String russianLocale() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("ru"));
        return null;
    }

    public String englishLocale() {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale("en"));
        return null;
    }
    public void add() {
        vdb.addAuthor(new Author(this.getFirstName(), this.getLastName(), this.getBio()));
    }
    
        public void remove() {
         vdb.removeAuthor(new Author(this.getFirstName(), this.getLastName(), this.getBio()));
    }
}
