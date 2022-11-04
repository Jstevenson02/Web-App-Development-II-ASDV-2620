/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.event.ActionEvent;

/**
 *
 * @author jacob
 */
@Named(value = "formSettings")
@SessionScoped
public class formSettings implements Serializable {

    private boolean isNormalSize = true;
    private boolean isLargeSize = false;

    public boolean isIsLargeSize() {
        return isLargeSize;
    }

    public void setIsLargeSize(boolean isLargeSize) {
        this.isLargeSize = isLargeSize;
    }

    public String getBodyStyleClass() {
        if (isNormalSize) {
            return ("normalSize");
        } else {

            return ("largeSize");
        }
    }

    public void setNormalSize(ActionEvent event) {
        isNormalSize = true;
    }

    public formSettings() {
    }

}
