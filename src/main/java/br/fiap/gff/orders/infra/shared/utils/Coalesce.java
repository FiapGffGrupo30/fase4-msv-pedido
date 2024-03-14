package br.fiap.gff.orders.infra.shared.utils;

import java.util.Objects;

public class Coalesce {
    private Coalesce() {
    }

    public static <T> T of(T target, T defaultValue) {
        return Objects.isNull(target) ? defaultValue : target;
    }
}
