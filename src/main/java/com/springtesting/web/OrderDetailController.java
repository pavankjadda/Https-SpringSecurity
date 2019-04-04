package com.springtesting.web;

import com.springtesting.dto.OrderDetailDTO;
import com.springtesting.model.OrderDetail;
import com.springtesting.repo.OrderDetailRepository;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderDetailController
{
    private OrderDetailRepository orderDetailRepository;

    private final ModelMapper modelMapper;

    public OrderDetailController(OrderDetailRepository orderDetailRepository, ModelMapper modelMapper)
    {
        this.orderDetailRepository = orderDetailRepository;
        this.modelMapper = modelMapper;
    }

    @PostMapping(path = "/create")
    public void createOrderDetail(@RequestBody OrderDetailDTO orderDetailDTO)
    {
        OrderDetail orderDetail = modelMapper.map(orderDetailDTO, OrderDetail.class);
        orderDetailRepository.saveAndFlush(orderDetail);
    }

    @GetMapping(value = "/list")
    public List<OrderDetail> getOrderDetails()
    {
        return orderDetailRepository.findAll();
    }

    @GetMapping(value = "/find/{id}")
    public Optional<OrderDetail> getOrderDetailById(@PathVariable long id)
    {
        return orderDetailRepository.findById(id);
    }

}
