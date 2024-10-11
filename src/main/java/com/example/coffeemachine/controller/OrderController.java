package com.example.coffeemachine.controller;

import com.example.coffeemachine.dto.OrderDto;
import com.example.coffeemachine.dto.RecipeStatisticDto;
import com.example.coffeemachine.entity.OrderEntity;
import com.example.coffeemachine.entity.RecipeStatistics;
import com.example.coffeemachine.mapper.OrderMapper;
import com.example.coffeemachine.mapper.RecipeStatisticMapper;
import com.example.coffeemachine.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RecipeStatisticMapper statisticMapper;

    @PostMapping("/{recipeId}")
    public ResponseEntity<OrderDto> createOrder(@PathVariable Long recipeId) {
        OrderEntity orderEntity = orderService.createOrder(recipeId);

        return new ResponseEntity<>(orderMapper.toDto(orderEntity), HttpStatus.CREATED);
    }

    @GetMapping("/allStatistic")
    public ResponseEntity<List<RecipeStatisticDto>> getAllOrders() {
        List<RecipeStatistics> orderEntity = orderService.getStatistics();

        return new ResponseEntity<>(orderEntity.stream()
                .map(statisticMapper::toDto).
                toList(),
                HttpStatus.OK);
    }

    @GetMapping("/popularRecipe")
    public ResponseEntity<List<RecipeStatisticDto>> getPopularRecipe() {
        List<RecipeStatistics> recipeStatistics = orderService.getMostPopularRecipe();

        return new ResponseEntity<>(recipeStatistics
                .stream()
                .map(statisticMapper::toDto)
                .toList(),
                HttpStatus.OK);
    }
}
