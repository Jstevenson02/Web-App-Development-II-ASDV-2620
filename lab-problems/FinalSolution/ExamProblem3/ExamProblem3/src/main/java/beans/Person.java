package beans;

import java.util.Date;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

@Named(value = "person")
@RequestScoped
public class Person
{
    public Person()
    {
        
    }
    private String name = "John";
    
    private int age = 21;


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
