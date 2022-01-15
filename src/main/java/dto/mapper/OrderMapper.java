package dto.mapper;

import dto.OrderDto;
import model.Order;
import model.builder.OrderBuilder;

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
            Order order = OrderBuilder.getBuilder()
                    .withPrice(orderDto.getPrice())
                    .withSubService(orderDto.getSubService())
                    .withExplanation(orderDto.getExplanation())
                    .withBeggingDate(orderDto.getBeggingDate())
                    .withEndingTime(orderDto.getEndingTime())
                    .withAddress(orderDto.getAddress())
                    .build();
            orderList.add(order);
        }
        return orderList;
    }
}
