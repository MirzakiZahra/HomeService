package service.mapper;

import dto.OrderDto;
import model.Orders;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
    public OrderDto convertOrderToOrderDto(Orders orders){
        OrderDto orderDto = OrderDto.builder()
                .id(orders.getId())
                .price(orders.getPrice())
                .subService(orders.getSubService())
                .explanation(orders.getExplanation())
                .beggingDate(orders.getBeggingDate())
                .endingTime(orders.getEndingTime())
                .address(orders.getAddress())
                .offerList(orders.getOfferList())
                .build();
        return orderDto;
    }
    public List<OrderDto> convertOrderToOrderDto(List<Orders> ordersList) {
        List<OrderDto> orderDtoList = new ArrayList<>();
        for (Orders orders : ordersList) {
            OrderDto orderDto = convertOrderToOrderDto(orders);
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
