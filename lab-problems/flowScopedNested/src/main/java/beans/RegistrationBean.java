package beans;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;

@Named (value = "registrationBean")
@FlowScoped(value = "registration")
public class RegistrationBean implements Serializable
{

    private String firstName;
    private String lastName;

    public RegistrationBean()
    {
    }
    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getReturnValue()
    {
        return "/done";
    }

    public String registrationAction()
    {
        boolean makeRegistrationFail = false;

        if (makeRegistrationFail )
          {
            firstName = "";
            lastName = "";
            FacesContext.getCurrentInstance().addMessage("type of message", 
                    new FacesMessage(FacesMessage.SEVERITY_WARN, "Registration failed!", ""));
            return "registration";
          }
        else
          {
            return "confirm";
          }
    }


}
