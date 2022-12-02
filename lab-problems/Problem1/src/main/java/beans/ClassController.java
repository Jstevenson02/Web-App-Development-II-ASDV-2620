/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import practice.problem1.Class_1;
import practice.problem1.resources.Interface_1;

/**
 *
 * @author jacob
 */
@Named(value = "requestBean")
@RequestScoped
public class ClassController {

    private Interface_1 intFace;

    public ClassController() {
        
        Class_1 guy1 = new Class_1(1, "John");
    }
}
