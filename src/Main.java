//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Clase orquestadora del ejercicio.
 */
public class Main {
    public static void main(String[] args) {
        BandejaImpresion bandeja = new BandejaImpresion();

        // Carga inicial de trabajos. Esta parte ocurre antes de iniciar los hilos.
        bandeja.agregarTrabajo(new TrabajoImpresion(1, "Informe.pdf", 4));
        bandeja.agregarTrabajo(new TrabajoImpresion(2, "GuiaPOO.pdf", 2));
        bandeja.agregarTrabajo(new TrabajoImpresion(3, "Diagrama.png", 3));
        bandeja.agregarTrabajo(new TrabajoImpresion(4, "Rubrica.pdf", 2));
        bandeja.agregarTrabajo(new TrabajoImpresion(5, "Presentacion.pdf", 5));
        bandeja.agregarTrabajo(new TrabajoImpresion(6, "Resumen.txt", 1));

        int cantidadImpresoras = 3;

        ExecutorService executor = Executors.newFixedThreadPool(cantidadImpresoras);

        System.out.println("=== CENTRO DE IMPRESION ===");
        System.out.println("Impresoras activas: " + cantidadImpresoras);
        System.out.println("Trabajos iniciales: " + bandeja.cantidadTrabajos());
        System.out.println();

        for (int i = 1; i <= cantidadImpresoras; i++) {
            executor.execute(new Impresora("Impresora-" + i, bandeja));
        }

        // No se aceptan nuevas tareas, pero las ya enviadas siguen ejecutandose.
        executor.shutdown();

        try {
            boolean termino = executor.awaitTermination(30, TimeUnit.SECONDS);
            if (!termino) {
                System.out.println("El sistema excedio el tiempo de espera. Se solicita cierre.");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println();
        System.out.println("Trabajos pendientes: " + bandeja.cantidadTrabajos());
        System.out.println("=== FIN DEL PROGRAMA ===");
    }
}