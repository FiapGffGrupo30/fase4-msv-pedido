package br.fiap.gff.orders.domain.entities;

import br.fiap.gff.orders.domain.enums.OrderStatus;
import br.fiap.gff.orders.infra.shared.utils.Coalesce;

import java.util.List;

public record Order(
        String id,
        Long customerId,
        List<Item> items,
        Boolean paid,
        OrderStatus status) {

    public Order setOrderPaid() {
        return new Order(id, customerId, items, true, OrderStatus.CREATED);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public Double getTotalPrice() {
        return items.stream().mapToDouble(Item::price).sum();
    }

    public Integer getTotalQuantity() {
        return items.stream().mapToInt(Item::quantity).sum();
    }

    public Order updateTo(Order order) {
        List<Item> items = Coalesce.of(order.items, this.items);
        Boolean paid = Coalesce.of(order.paid, this.paid);
        OrderStatus status = Coalesce.of(order.status, this.status);
        return new Order(this.id, this.customerId, items, paid, status);
    }

}
