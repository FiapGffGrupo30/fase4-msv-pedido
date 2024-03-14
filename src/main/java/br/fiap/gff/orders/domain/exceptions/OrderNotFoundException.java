package br.fiap.gff.orders.domain.exceptions;

import br.fiap.gff.orders.infra.shared.exceptions.BussinessException;

public class OrderNotFoundException extends BussinessException {

    public OrderNotFoundException(String message) {
        super(message);
    }

}
