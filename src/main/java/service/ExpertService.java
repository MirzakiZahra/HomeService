package service;

import dao.ExpertDb;
import model.people.Customer;
import model.people.Expert;

import java.util.List;
import java.util.stream.Collectors;


public class ExpertService {
    ExpertDb expertDb = new ExpertDb();

    public void createExpert(String firstName, String lastName, String email) {
        Expert expert = new Expert(firstName, lastName, email);
        expertDb.addExpert(expert);
    }
    public void deleteExpert(String email){
      Expert expert=  expertDb.findExpertByEmail(email);
      expertDb.deleteExpert(expert);

    }

    public void addMoneyForExpert(String email, float money) {
        Expert expert=expertDb.findExpertByEmail(email);
        float temp = expert.getCreditExpert() + money;
        expert.setCreditExpert(temp);
        expertDb.updateExpertCredit(expert);
    }

    public void printShowExpert(){
        List<Expert>experts=expertDb.showExpert();
        experts.stream().forEach(i -> System.out.println(i.getLastName()));

    }

}
