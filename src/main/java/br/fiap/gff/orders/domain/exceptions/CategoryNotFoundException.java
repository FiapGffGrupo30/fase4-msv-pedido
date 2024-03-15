package br.fiap.gff.orders.domain.exceptions;

public class CategoryNotFoundException extends BussinessException {
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
