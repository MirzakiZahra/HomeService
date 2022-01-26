package service;

import exception.InputException;
import dao.ExpertDb;
import dao.OrderDb;
import dao.ServiceDb;
import dto.ExpertDto;
import dto.OrderDto;
import model.Orders;
import model.services.MainService;
import model.services.SubService;
import model.user.Expert;
import service.mapper.ExpertMapper;
import service.mapper.OrderMapper;

import java.util.List;


public class ExpertService {
    ExpertDb expertDb = new ExpertDb();
    ServiceDb serviceDb = new ServiceDb();
    OrderService orderService = new OrderService();
    ExpertMapper expertMapper = new ExpertMapper();
    ExpertDto expertDto=new ExpertDto();
    OrderDb orderDb=new OrderDb();
    OrderMapper orderMapper=new OrderMapper();

    public void createExpert(String firstName, String lastName, String email) {
        Expert expert = new Expert(firstName, lastName, email);
        expertDb.addExpert(expert);
    }
    public ExpertDto findExpertByEmail(String email){
        Expert expert = expertDb.findExpertByEmail(email);
        return expertMapper.convertExpertToExpertDto(expert);
    }

    public void deleteExpert(String email) {
        Expert expert = expertDb.findExpertByEmail(email);
        expertDb.deleteExpert(expert);

    }

 /*   public void addMoneyForExpert(String email, float money) {
        Expert expert = expertDb.findExpertByEmail(email);
        float temp = expert.getCreditExpert() + money;
        expert.setCreditExpert(temp);
        expertDb.updateExpert(expert);
    }*/

    public void printShowExpert() {
        List<Expert> experts = expertDb.showExpert();
        experts.stream().forEach(i -> System.out.println(i.getLastName()));

    }

    public void deleteExpertFromService(String subServiceName, String email) {
        Expert expert = expertDb.findExpertByEmail(email);
        MainService mainService = serviceDb.findServiceByName(subServiceName).get(0);
        expert.getSubServiceList().remove(mainService);
    }

    public void updateExpertScore(float score, int orderID) {
        Orders orders = orderService.findOrderByIdReturnOrder(orderID);
        Expert expert = orders.getPreferredOffer().getExpert();
        if (expert.getCountOfOrder() == 0) {
            expert.setScore(score);
            int temp = expert.getCountOfOrder() + 1;
            expert.setCountOfOrder(temp);
        } else {
            int count = expert.getCountOfOrder();
            float sum = expert.getScore() * count;
            int temp = count + 1;
            float newSum = sum + score;
            float num = newSum / temp;
            expert.setScore(num);
            expert.setCountOfOrder(temp);
        }
        expertDb.updateExpert(expert);
    }
    public void checkOldExpertPassword(String password) {
        if (expertDb.checkExistOfExpertPassword(password) == 0) {
            throw new InputException("Password is Incorrect");
        }
    }
    public void changePassword(String password, String email) {
        Expert expert = expertDb.findExpertByEmail(email);
        expert.setPassword(password);
        expertDb.updateExpert(expert);
    }
    public List<OrderDto>expertRelatedOrders(){
        List<SubService> subServices = expertDto.getSubServiceList();
        List<Orders> ordersList =
                orderDb.allOrdersWithStatusWAITINGFOREXPERTSUGGESTION();
        for (SubService subService : subServices) {
            for (Orders orders : ordersList) {
                if (orders.getSubService().equals(subService)) {
                    ordersList.add(orders);
                }
            }

        }
        return orderMapper.convertOrderToOrderDto(ordersList);

    }


}
