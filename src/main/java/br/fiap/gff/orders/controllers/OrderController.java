package br.fiap.gff.orders.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.fiap.gff.orders.domain.order.Order;
import br.fiap.gff.orders.domain.order.OrderUseCase;
import br.fiap.gff.orders.domain.order.dto.RequestOrderDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderUseCase useCase;

    @GetMapping()
    public ResponseEntity<List<Order>> findAll() {
        return ResponseEntity.ok(useCase.findAll());
    }

    @GetMapping("/order/customer/{customerId}")
    public ResponseEntity<List<Order>> findByCustomerId(@PathVariable Long customerId) {
        return ResponseEntity.ok(useCase.findByCustomerId(customerId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> findById(@PathVariable String id) {
        return ResponseEntity.ok(useCase.findById(id));
    }

    @PostMapping()
    public ResponseEntity<Order> create(@RequestBody RequestOrderDTO dto) {
        Order createdOrder = useCase.create(dto);
        return ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(createdOrder.id())
                        .toUri())
                .body(createdOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> update(@PathVariable String id, @RequestBody RequestOrderDTO dto) {
        Order updatedOrder = useCase.update(id, dto);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        useCase.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
