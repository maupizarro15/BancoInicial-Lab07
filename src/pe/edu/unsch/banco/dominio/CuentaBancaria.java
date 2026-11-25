
package pe.edu.unsch.banco.dominio;

import java.math.BigDecimal;

public class CuentaBancaria {

    private final String titular;
    private BigDecimal saldo;

    public CuentaBancaria(String titular, BigDecimal saldo) {

        if (titular == null || titular.isBlank()) {
            throw new IllegalArgumentException("Titular invalido");
        }

        if (saldo.signum() < 0) {
            throw new IllegalArgumentException("Saldo inicial invalido");
        }

        this.titular = titular;
        this.saldo = saldo;
    }

    public void depositar(BigDecimal monto) {

        if (monto.signum() <= 0) {
            throw new IllegalArgumentException("Monto invalido");
        }

        saldo = saldo.add(monto);
    }

    public void retirar(BigDecimal monto) {

        if (monto.signum() <= 0) {
            throw new IllegalArgumentException("Monto invalido");
        }

        if (monto.compareTo(saldo) > 0) {
            throw new IllegalArgumentException("Fondos insuficientes");
        }

        saldo = saldo.subtract(monto);
    }

    public String getTitular() {
        return titular;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }
}
