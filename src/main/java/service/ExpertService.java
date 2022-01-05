package service;

import dao.ExpertDb;
import model.people.Customer;
import model.people.Expert;


public class ExpertService {
    ExpertDb expertDb = new ExpertDb();
    public void createExpert(String firstName, String lastName, String email) {
        Expert expert = new Expert(firstName, lastName, email);
        expertDb.addExpert(expert);
    }
    public void addMoneyForExpert(String email, float money) {
        Expert expert=expertDb.findExpertByEmail(email);
        float temp = expert.getCreditExpert() + money;
        expert.setCreditExpert(temp);
        expertDb.updateExpertCredit(expert);


    }
}
