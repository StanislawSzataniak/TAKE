package ai.beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.Date;

@Named(value = "calculateBean")
@RequestScoped
public class CalculateBean {

    private int addFirst;
    private int addSecond;
    private int result;
    private Date date = new Date();

    public CalculateBean() {
    }

    public void calculate() {
        result = addFirst + addSecond;
        FacesMessage message = new FacesMessage("Calculation complete",
                addFirst + " + " + addSecond + " = " + result);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, message);
    }

    public int getAddFirst() {
        return addFirst;
    }

    public void setAddFirst(int addFirst) {
        this.addFirst = addFirst;
    }

    public int getAddSecond() {
        return addSecond;
    }

    public void setAddSecond(int addSecond) {
        this.addSecond = addSecond;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
