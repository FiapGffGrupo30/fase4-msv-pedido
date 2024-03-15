package br.fiap.gff.orders.domain.exceptions;

public class OrderNotFoundException extends BussinessException {

    public OrderNotFoundException(String message) {
        super(message);
    }

}
