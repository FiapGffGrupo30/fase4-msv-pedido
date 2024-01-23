package br.fiap.gff.orders.domain.order.exceptions;

import br.fiap.gff.orders.shared.exceptions.BussinessException;

public class OrderNotFoundException extends BussinessException {

    public OrderNotFoundException(String message) {
        super(message);
    }

}
