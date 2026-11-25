
package pe.edu.unsch.banco.infraestructura;

import pe.edu.unsch.banco.aplicacion.MovimientoRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ArchivoMovimientoRepository
        implements MovimientoRepository {

    @Override
    public void guardar(String movimiento) {

        try (FileWriter archivo =
                     new FileWriter("movimientos.txt", true)) {

            archivo.write(
                    LocalDateTime.now() + " | "
                            + movimiento + System.lineSeparator()
            );

        } catch (IOException e) {
            System.out.println(
                    "Advertencia: no se pudo guardar el movimiento"
            );
        }
    }
}

