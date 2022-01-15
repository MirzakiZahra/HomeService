package dto.mapper;

import dto.OrderDto;
import model.Order;


import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
    public List<OrderDto> convertOrderToOrderDto(List<Order> orderList) {
        List<OrderDto> orderDtoList = new ArrayList<>();
        for (Order order : orderList) {
            OrderDto orderDto = new OrderDto(order.getId(), order.getPrice(),
                    order.getSubService(), order.getExplanation(), order.getBeggingDate(),
                    order.getEndingTime(), order.getAddress());
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
