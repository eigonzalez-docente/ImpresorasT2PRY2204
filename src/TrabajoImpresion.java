public class TrabajoImpresion {

    private final int id;
    private final String nombreArchive;
    private final String paginas;

    public TrabajoImpresion(int id, String nombreArchive, String paginas) {
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

    public String getPaginas() {
        return paginas;
    }

    @Override
    public String toString() {
        return "Trabajo #" + id + " - " + "Nombre archivo: " + nombreArchive + " - " + "Numero paginas: "+ paginas;
    }
}
