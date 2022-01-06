package service;

import dao.ExpertDb;
import dao.ServiceDb;
import model.people.Customer;
import model.people.Expert;
import model.services.HomeServices;

import java.util.List;
import java.util.stream.Collectors;


public class ExpertService {
    ExpertDb expertDb = new ExpertDb();
    ServiceDb serviceDb = new ServiceDb();

    public void createExpert(String firstName, String lastName, String email) {
        Expert expert = new Expert(firstName, lastName, email);
        expertDb.addExpert(expert);
    }

    public void deleteExpert(String email) {
        Expert expert = expertDb.findExpertByEmail(email);
        expertDb.deleteExpert(expert);

    }

    public void addMoneyForExpert(String email, float money) {
        Expert expert = expertDb.findExpertByEmail(email);
        float temp = expert.getCreditExpert() + money;
        expert.setCreditExpert(temp);
        expertDb.updateExpertCredit(expert);
    }

    public void printShowExpert() {
        List<Expert> experts = expertDb.showExpert();
        experts.stream().forEach(i -> System.out.println(i.getLastName()));

    }

    public void deleteExpertFromService(String serviceName, String email) {
        Expert expert = expertDb.findExpertByEmail(email);
        HomeServices homeServices = serviceDb.findServiceByName(serviceName);
        expert.getHomeServices().remove(homeServices);
       

    }

    public int advantageOfScore(int score, String email) {
        Expert expert = expertDb.findExpertByEmail(email);
        int count = expert.getCountOfOrder();
        int sum = expert.getScore() * count;
        int temp = count + 1;
        int newSum = sum + score;
        int num = newSum / temp;
        return num;

    }



}
