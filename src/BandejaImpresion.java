import java.util.LinkedList;
import java.util.Queue;

public class BandejaImpresion {
    private final Queue<TrabajoImpresion> trabajos =  new LinkedList<>();

    public synchronized void agregarTrabajo(TrabajoImpresion trabajo){
        trabajos.offer(trabajo);
    }

    public synchronized TrabajoImpresion retirarTrabajo(){
        return trabajos.poll();
    }

    public synchronized int cantidadTrabajos(){
        return trabajos.size();
    }

}
