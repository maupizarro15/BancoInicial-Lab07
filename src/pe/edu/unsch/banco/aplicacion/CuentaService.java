
package pe.edu.unsch.banco.aplicacion;

import pe.edu.unsch.banco.dominio.CuentaBancaria;
import java.math.BigDecimal;

public class CuentaService {

    private CuentaBancaria cuenta;
    private final MovimientoRepository repository;

    public CuentaService(MovimientoRepository repository) {
        this.repository = repository;
    }

    public void registrar(String titular, BigDecimal saldo) {

        if (cuenta != null) {
            throw new IllegalStateException("Ya existe una cuenta activa");
        }

        cuenta = new CuentaBancaria(titular, saldo);

        repository.guardar(
                "Cuenta creada | Titular: " + titular
                        + " | Saldo inicial: S/ " + saldo
        );
    }

    public void depositar(BigDecimal monto) {

        verificarCuenta();
        cuenta.depositar(monto);

        repository.guardar(
                "Titular: " + cuenta.getTitular()
                        + " | Deposito: S/ " + monto
                        + " | Saldo actual: S/ " + cuenta.getSaldo()
        );
    }

    public void retirar(BigDecimal monto) {

        verificarCuenta();
        cuenta.retirar(monto);

        repository.guardar(
                "Titular: " + cuenta.getTitular()
                        + " | Retiro: S/ " + monto
                        + " | Saldo actual: S/ " + cuenta.getSaldo()
        );
    }

    public CuentaBancaria consultar() {
        verificarCuenta();
        return cuenta;
    }

    private void verificarCuenta() {

        if (cuenta == null) {
            throw new IllegalStateException("No existe una cuenta activa");
        }
    }
}
