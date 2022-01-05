package service;

import dao.ExpertDb;
import model.people.Expert;


public class ExpertService {
    ExpertDb expertDb = new ExpertDb();
    public void createExpert(String firstName, String lastName, String email) {
        Expert expert = new Expert(firstName, lastName, email);
        expertDb.addExpert(expert);
    }
}
