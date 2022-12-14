/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package practice.labjeaneaumessagesvalidation.beans;

import java.util.Date;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * @author juneau
 */
@SessionScoped
@Named
public class MessageController implements java.io.Serializable {

    int hitCounter = 0;
    private String javaText;

    /**
     * Creates a new instance of MessageController
     */
    public MessageController() {
        javaText = null;
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Managed Bean         ", null);

        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public void newMessage() {
        String hitMessage = null;
        hitCounter++;
        if (hitCounter > 1) {
            hitMessage = hitCounter + " times";
        } else {
            hitMessage = hitCounter + " time";
        }

        Date currDate = new Date();
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "You've pressed that button " + hitMessage + "! The current date and time: "
                + currDate, null);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        if (getJavaText()
                .equalsIgnoreCase("java")) {
            FacesMessage javaTextMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
                    "Good Job, that is the correct text!", null);
            FacesContext.getCurrentInstance().addMessage("componentForm:javaText", javaTextMsg);
        } else {
            FacesMessage javaTextMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Sorry, that is NOT the correct text!", null);
            FacesContext.getCurrentInstance().addMessage("componentForm:javaText", javaTextMsg);
        }
    }

    /**
     * @return the javaText
     */
    public String getJavaText() {
        return javaText;
    }

    /**
     * @param javaText the javaText to set
     */
    public void setJavaText(String javaText) {
        this.javaText = javaText;
    }

}
