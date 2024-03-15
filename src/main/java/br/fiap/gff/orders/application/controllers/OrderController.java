package br.fiap.gff.orders.application.controllers;

import br.fiap.gff.orders.application.dto.RequestOrderDTO;
import br.fiap.gff.orders.domain.entities.Order;
import br.fiap.gff.orders.domain.usecases.OrderUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

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
        Order createdOrder = useCase.create(dto.toOrder());
        return ResponseEntity.created(
                        ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(createdOrder.id())
                                .toUri())
                .body(createdOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> update(@PathVariable String id, @RequestBody RequestOrderDTO dto) {
        Order updatedOrder = useCase.update(id, dto.toOrder());
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        useCase.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
