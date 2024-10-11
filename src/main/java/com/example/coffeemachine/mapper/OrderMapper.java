package com.example.coffeemachine.mapper;

import com.example.coffeemachine.dto.OrderDto;
import com.example.coffeemachine.entity.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderDto toDto(OrderEntity orderEntity) {
        return new OrderDto(
                orderEntity.getId(),
                orderEntity.getRecipe(),
                orderEntity.getDate()
        );
    }
}
