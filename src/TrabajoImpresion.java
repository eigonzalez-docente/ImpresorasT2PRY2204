public class TrabajoImpresion {

    private final int id;
    private final String nombreArchive;
    private final int paginas;

    public TrabajoImpresion(int id, String nombreArchive, int paginas) {
        this.id = id;
        this.nombreArchive = nombreArchive;
        this.paginas = paginas;
    }

    public int getId() {
        return id;
    }


    public String getNombreArchive() {
        return nombreArchive;
    }

    public int getPaginas() {
        return paginas;
    }

    @Override
    public String toString() {
        return "Trabajo #" + id + " - " + "Nombre: " + nombreArchive + " - " + "Numero paginas: "+ paginas;
    }
}
