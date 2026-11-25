
package pe.edu.unsch.banco.infraestructura;

import pe.edu.unsch.banco.aplicacion.CuentaService;
import pe.edu.unsch.banco.aplicacion.MovimientoRepository;
import pe.edu.unsch.banco.dominio.CuentaBancaria;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        MovimientoRepository repository =
                new ArchivoMovimientoRepository();

        CuentaService service = new CuentaService(repository);

        Scanner entrada = new Scanner(System.in);

        int opcion = 0;

        System.out.println("=== CLEAN ARCHITECTURE ===");
        System.out.println("Laboratorio 07-A");
        System.out.println("Codigo: 27222109");
        System.out.println(
                "Aviso: la cuenta no se restaura automaticamente."
        );

        do {

            System.out.println("\n=== SISTEMA BANCARIO ===");
            System.out.println("1. Registrar cuenta");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Consultar saldo");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            try {

                opcion = Integer.parseInt(
                        entrada.nextLine().trim()
                );

                switch (opcion) {

                    case 1:
                        System.out.print("Ingrese titular: ");
                        String titular = entrada.nextLine();

                        System.out.print("Ingrese saldo inicial: ");
                        BigDecimal saldo = new BigDecimal(
                                entrada.nextLine().trim()
                        );

                        service.registrar(titular, saldo);
                        System.out.println("Cuenta registrada");
                        break;

                    case 2:
                        System.out.print("Monto a depositar: ");
                        BigDecimal deposito = new BigDecimal(
                                entrada.nextLine().trim()
                        );

                        service.depositar(deposito);
                        System.out.println("Deposito exitoso");
                        break;

                    case 3:
                        System.out.print("Monto a retirar: ");
                        BigDecimal retiro = new BigDecimal(
                                entrada.nextLine().trim()
                        );

                        service.retirar(retiro);
                        System.out.println("Retiro exitoso");
                        break;

                    case 4:
                        CuentaBancaria cuenta = service.consultar();

                        System.out.println(
                                "Titular: " + cuenta.getTitular()
                        );

                        System.out.println(
                                "Saldo: S/ " + cuenta.getSaldo()
                        );
                        break;

                    case 5:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opcion invalida");
                }

            } catch (NumberFormatException e) {

                System.out.println("Error: ingrese un numero valido");

            } catch (IllegalArgumentException |
                     IllegalStateException e) {

                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 5);

        entrada.close();
    }
}
