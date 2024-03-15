package br.fiap.gff.orders.domain.exceptions;

public class ProductNotFoundException extends BussinessException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
