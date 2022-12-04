package beans;

import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import pojo.BestFriend;

@Named(value = "person")
@RequestScoped
public class Person
{

    private String name = "John";
    private int age = 21;
    private BestFriend bestFriend = new BestFriend("nobody");
    
    public Person()
    {
        
    }   

    public BestFriend getBestFriend()
    {
        return bestFriend;
    }
    public void changeBestFriendName(String name)
    {
         bestFriend.setName(name);
    }
    public void setBestFriend(BestFriend bestFriend)
    {
        this.bestFriend = bestFriend;
    }
    


    public int getAge()
    {
        return age;
    }


    public void setAge ( int age)
    {
        this.age = age;
    }

    

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

   public void concatanate()
    {
        String s = this.name + " " + Integer.toString(age);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(s));
    }
    
}
