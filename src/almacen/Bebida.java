package almacen;
public class Bebida {
    private String id,marca;
    private double cantidad,precio;

    public Bebida() {}
    public Bebida(String id, String marca, double cantidad, double precio) {
        this.id = id;
        this.marca = marca;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    public void setId(String id) {this.id = id;}
    public void setMarca(String marca) {this.marca = marca;}
    public void setCantidad(double cantidad) {this.cantidad = cantidad;}
    public void setPrecio(double precio) {this.precio = precio;}
    
    public String getId() {return id;}
    public String getMarca() {return marca;}
    public double getCantidad() {return cantidad;}
    public double getPrecio() {return precio;}
    
    public String informacion() {return "";}
}