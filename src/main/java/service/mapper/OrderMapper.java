package service.mapper;

import dto.OrderDto;
import model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
    public OrderDto convertOrderToOrderDto(Order order){
        OrderDto orderDto = OrderDto.builder()
                .id(order.getId())
                .price(order.getPrice())
                .subService(order.getSubService())
                .explanation(order.getExplanation())
                .beggingDate(order.getBeggingDate())
                .endingTime(order.getEndingTime())
                .address(order.getAddress())
                .offerList(order.getOfferList())
                .build();
        return orderDto;
    }
    public List<OrderDto> convertOrderToOrderDto(List<Order> orderList) {
        List<OrderDto> orderDtoList = new ArrayList<>();
        for (Order order : orderList) {
            OrderDto orderDto = convertOrderToOrderDto(order);
            orderDtoList.add(orderDto);
        }
        return orderDtoList;
    }

   /* public List<Order> convertOrderDtoToOrder(List<OrderDto> orderDtoList) {
        List<Order> orderList = new ArrayList<>();
        for (OrderDto orderDto : orderDtoList) {
            Order order = Order.builder()
                    .price(orderDto.getPrice())
                    .subService(orderDto.getSubService())
                    .explanation(orderDto.getExplanation())
                    .beggingDate(orderDto.getBeggingDate())
                    .endingTime(orderDto.getEndingTime())
                    .address(orderDto.getAddress())
                    .offerList(orderDto.getOfferList())
                    .build();
            orderList.add(order);
        }
        return orderList;
    }*/
}
