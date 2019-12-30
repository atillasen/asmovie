package asmovieController;

import asmovieDao.Customer;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
@Named
@RequestScoped
public class CustomerController implements Serializable {


    private static final long serialVersionUID = -2274940763911332400L;

    @Inject
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
