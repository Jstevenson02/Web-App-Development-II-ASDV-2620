package beans;

import java.io.Serializable;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;

@Named
@FlowScoped(value = "orientation")
public class OrientationBean implements Serializable {

    private String day;
    private String time;
    private String regCode;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRegCode() {
        return regCode;
    }

    public void setRegCode(String regcode) {
        this.regCode = regcode;
    }

    public String getReturnValue() {
        return "/done";
    }
}
