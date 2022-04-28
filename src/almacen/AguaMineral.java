package almacen;
public class AguaMineral extends Bebida {
    private String origen;

    public AguaMineral() {}
    public AguaMineral(String id, String marca, double cantidad, double precio, String origen) {
        super(id, marca, cantidad, precio);
        this.origen = origen;
    }
    public void setOrigen(String origen) {this.origen = origen;}
    public String getOrigen() {return origen;}
    @Override
    public String informacion() {return "\nIdentificador: #"+getId()+"\nMarca: "+getMarca()+"\nCantidad: "+getCantidad()+" lts.\nPrecio: $"+getPrecio()+"\nOrigen: "+getOrigen();}
}