/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package practice.problem3.beans;

import javax.faces.application.FacesMessage;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author jacob
 */
@Named(value = "concatinate")
@RequestScoped
public class Concatinate {

    String Name;
    int Age;
    String result = "";

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String outPutConcatinated() {
        
          FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, this.Name + " " + this.Age, "");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, msg);
            
            return null;
    }
}
