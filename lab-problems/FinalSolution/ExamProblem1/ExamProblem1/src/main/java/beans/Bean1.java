/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import bl.Class1;
import bl.Interface1;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;

/**
 *
 * @author A. V. Markou
 */
@Named(value = "bean1")
@RequestScoped
public class Bean1
{
    private Interface1 interface1;
    
    public Bean1()
    {
        interface1 = new Class1( 1, "john");
    }

    public Interface1 getInterface1()
    {
        return interface1;
    }
    
    
}
