public class Impresora implements Runnable{
    private final String nombre;
    private final BandejaImpresion bandeja;

    public Impresora(String nombre, BandejaImpresion bandeja) {
        this.nombre = nombre;
        this.bandeja = bandeja;
    }

    @Override
    public void run(){
        while (true){
            TrabajoImpresion trabajo = bandeja.retirarTrabajo();
            if (trabajo == null){
                System.out.println("[" + nombre + "] No quedan trabajos. Finaliza.");
                return;
            }

            System.out.println("Nombre [INICIA] -->" + trabajo);

            try{
                // Simulamos el tiempo de impresion
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println("[" + nombre + "] Fue interrumpida.");
                return;
            }

            System.out.println("[" + nombre + "] TERMINA -> Trabajo #" + trabajo.getId());
        }
    }
}
