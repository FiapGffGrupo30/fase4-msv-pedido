package br.fiap.gff.orders.infra.shared.exceptions;

public class BussinessException extends RuntimeException {

    public BussinessException(String message) {
        super(message);
    }

}
