package ir.service;

import ir.data.dto.ExpertDto;
import ir.data.dto.OrderDto;
import ir.data.model.Orders;
import ir.data.model.services.SubService;
import ir.data.model.user.Expert;
import ir.data.repository.ExpertRepository;
import ir.data.repository.OrderRepository;
import ir.data.repository.ServiceRepository;
import ir.data.repository.SubServiceRepository;
import ir.exception.InputException;
import ir.service.mapper.ExpertMapper;
import ir.service.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpertService {
    @Autowired
    ExpertRepository expertRepository;
    ServiceRepository serviceRepository;
    OrderService orderService = new OrderService();
    ExpertMapper expertMapper = new ExpertMapper();
    ExpertDto expertDto = new ExpertDto();
    @Autowired
    OrderRepository orderRepository;
    OrderMapper orderMapper = new OrderMapper();
    @Autowired
    SubServiceRepository subServiceRepository;

    public void createExpert(String firstName, String lastName, String email) {
        Expert expert = new Expert(firstName, lastName, email);
        expertRepository.save(expert);
    }

    public ExpertDto findExpertByEmail(String email) {
        List<Expert> expertList = expertRepository.findAllByEmail(email);
        if (expertList.size() == 0) {
            throw new InputException("Expert DoesNot Exist");
        }
        return expertMapper.convertExpertToExpertDto(expertList.get(0));
    }

    public void deleteExpert(String email) {
        Expert expert = expertRepository.findAllByEmail(email).get(0);
        expertRepository.delete(expert);
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
        expertRepository.save(expert);
    }

    public void checkOldExpertPassword(String password) {
        if (expertRepository.findAllByPassword(password).size() == 0) {
            throw new InputException("Password is Incorrect");
        }
    }

    public void changePassword(String password, String email) {
        Expert expert = expertRepository.findAllByEmail(email).get(0);
        expert.setPassword(password);
        expertRepository.save(expert);
    }

    public List<OrderDto> expertRelatedOrders() {
        List<SubService> subServices = expertDto.getSubServiceList();
        List<Orders> ordersList =
                orderRepository.findAllByOrderStatus();
        for (SubService subService : subServices) {
            for (Orders orders : ordersList) {
                if (orders.getSubService().equals(subService)) {
                    ordersList.add(orders);
                }
            }

        }
        return orderMapper.convertOrderToOrderDto(ordersList);

    }

    public void addServiceToExpert(String email, String subServiceName) {
        if (expertRepository.findAllByEmail(email).size() == 0) {
            throw new InputException("Expert DoesNot Exist");
        } else {
            Expert expert = expertRepository.findAllByEmail(email).get(0);
            if (checkNotExistenceOfSubServiceInExpertSubServiceList(
                    expertMapper.convertExpertToExpertDto(expert), subServiceName) == false) {
                SubService foundSubService = subServiceRepository.findByName(subServiceName);
                expert.getSubServiceList().add(foundSubService);
                expertRepository.save(expert);
                foundSubService.getExpertSet().add(expert);
                subServiceRepository.save(foundSubService);
            }
        }
    }

    public void deleteServiceFromExpert(String email, String subServiceName) {
        if (expertRepository.findAllByEmail(email).size() == 0) {
            throw new InputException("Expert DoesNot Exist");
        } else {
            Expert expert = expertRepository.findAllByEmail(email).get(0);
            if (checkExistenceOfSubServiceInExpertSubServiceList(
                    expertMapper.convertExpertToExpertDto(expert), subServiceName) == true) {
                SubService foundSubService = subServiceRepository.findByName(subServiceName);
                expert.getSubServiceList().remove(foundSubService);
                expertRepository.save(expert);
                foundSubService.getExpertSet().remove(expert);
                subServiceRepository.save(foundSubService);
            }
        }
    }

    public boolean checkExistenceOfSubServiceInExpertSubServiceList(ExpertDto expertDto, String subServiceName) {
        for (SubService subService : expertDto.getSubServiceList()) {
            if (subService.getName().equalsIgnoreCase(subServiceName)) {
                return true;
            }
        }
        throw new InputException("Expert hasn't such Service");
    }

    public boolean checkNotExistenceOfSubServiceInExpertSubServiceList(ExpertDto expertDto, String subServiceName) {
        for (SubService subService : expertDto.getSubServiceList()) {
            if (subService.getName().equalsIgnoreCase(subServiceName)) {
                throw new InputException("Expert has such Service");
            }
        }
        return false;
    }
}
