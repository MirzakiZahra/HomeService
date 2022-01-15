package service.mapper;

import dto.OrderDto;
import model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
    public List<OrderDto> convertOrderToOrderDto(List<Order> orderList) {
        List<OrderDto> orderDtoList = new ArrayList<>();
        for (Order order : orderList) {
            OrderDto orderDto = OrderDto.builder()
                    .id(order.getId())
                    .price(order.getPrice())
                    .subService(order.getSubService())
                    .explanation(order.getExplanation())
                    .beggingDate(order.getBeggingDate())
                    .endingTime(order.getEndingTime())
                    .address(order.getAddress())
                    .build();
            orderDtoList.add(orderDto);
        }
        return orderDtoList;
    }

    public List<Order> convertOrderDtoToOrder(List<OrderDto> orderDtoList) {
        List<Order> orderList = new ArrayList<>();
        for (OrderDto orderDto : orderDtoList) {
            Order order = Order.builder()
                    .price(orderDto.getPrice())
                    .subService(orderDto.getSubService())
                    .explanation(orderDto.getExplanation())
                    .beggingDate(orderDto.getBeggingDate())
                    .endingTime(orderDto.getEndingTime())
                    .address(orderDto.getAddress())
                    .build();
            orderList.add(order);
        }
        return orderList;
    }
}
