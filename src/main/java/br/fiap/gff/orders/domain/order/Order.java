package br.fiap.gff.orders.domain.order;

import java.util.List;

import br.fiap.gff.orders.domain.items.Item;
import br.fiap.gff.orders.shared.utils.Coalesce;

public record Order(String id, Long customerId, List<Item> items, Boolean paid) {

    public Order setOrderPaid() {
        return new Order(id, customerId, items, true);
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
        return new Order(this.id, this.customerId, items, paid);
    }
}
