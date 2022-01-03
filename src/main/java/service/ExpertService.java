package service;

import dao.ExpertDb;
import entity.Expert;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class ExpertService {
ExpertDb expertDb=new ExpertDb();
    public void createExpert(String firstName,String lastName,String email){
        Expert expert=new Expert(firstName,lastName,email);
        expertDb.addExpert(expert);

    }
}
