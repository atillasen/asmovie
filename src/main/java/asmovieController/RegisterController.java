package asmovieController;

import asmovieDao.Customer;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.io.Serializable;

@Named
@RequestScoped
public class RegisterController  implements Serializable {


    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager em;

    @Resource
    private UserTransaction ut;

    @Inject
    Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String persist(){

     try{
         ut.begin();
         em.persist(customer);
         ut.commit();
         FacesMessage m = new FacesMessage("Successfully registered!");
         FacesContext.getCurrentInstance().addMessage("registerForm",m);


     }catch (Exception e){
         e.printStackTrace();
         FacesContext.getCurrentInstance().addMessage("registerForm", new FacesMessage(e.getMessage()));

     }
     return "/register/register.xhtml";
    }
}
