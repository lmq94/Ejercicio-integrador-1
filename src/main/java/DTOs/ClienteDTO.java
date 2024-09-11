package DTOs;

public class ClienteDTO {
    private String nombre;
    private float totalFacturado;

    public ClienteDTO(String nombre, float totalFacturado) {
        this.nombre = nombre;
        this.totalFacturado = totalFacturado;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getTotalFacturado() {
        return totalFacturado;
    }

    public void setTotalFacturado(float totalFacturado) {
        this.totalFacturado = totalFacturado;
    }

    @Override
    public String toString() {
        return
                this.nombre + '\'' +
                ", Total Facturado=" + this.totalFacturado;
    }
}
