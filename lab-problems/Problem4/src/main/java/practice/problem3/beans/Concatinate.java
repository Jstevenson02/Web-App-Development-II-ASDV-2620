/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package practice.problem3.beans;

import javax.faces.application.FacesMessage;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import practice.problem3.resources.BestFriend;

/**
 *
 * @author jacob
 */
@Named(value = "concatinate")
@RequestScoped
public class Concatinate {

    private String Name;
    private int Age;
    private String result = "";
    private String friend = "nobody";

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

    public String showBestFriend() {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, friend + "", "");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, msg);

        return null;
    }

    public void changeBestFriendName(String name) {
        this.friend = friend;
    }

    public String outPutConcatinated() {

        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, this.Name + " " + this.Age, "");
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, msg);

        return null;
    }
}
