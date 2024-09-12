package DTOs;

public class ProductoDTO {

    private String nombre;
    private float valor;
    private int cantidadVendida;
    private float recaudacion;

    public ProductoDTO(String nombre, float valor, int cantidadVendida, float recaudacion) {
        this.nombre = nombre;
        this.valor = valor;
        this.cantidadVendida = cantidadVendida;
        this.recaudacion = recaudacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public float getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(float recaudacion) {
        this.recaudacion = recaudacion;
    }
}
