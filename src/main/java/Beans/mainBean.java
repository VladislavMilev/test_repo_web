package Beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.Objects;

@ManagedBean(name = "mainBean")
@SessionScoped
public class mainBean {

private String email;
private String password;

public void message(){
    FacesContext context = FacesContext.getCurrentInstance();
    if(Objects.equals(email, "vlad_milev1@mail.ru") && Objects.equals(password, "dofemu37")){
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Success", "Hello admin"));
    }else {
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Wrong", "Wrong email or password"));
    }
}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
