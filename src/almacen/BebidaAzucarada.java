package almacen;
public class BebidaAzucarada extends Bebida {
    private double porcentajeAzucar;
    private boolean promo;

    public BebidaAzucarada() {}
    public BebidaAzucarada(String id, String marca, double cantidad, double precio, double porcentajeAzucar, boolean promo) {
        super(id, marca, cantidad, precio);
        setPrecio(promo ? getPrecio()*0.9 : getPrecio());
        this.porcentajeAzucar = porcentajeAzucar;
        this.promo = promo;
    }
    public void setPromo(boolean promo) {this.promo = promo;}
    public void setPorcentajeAzucar(double porcentajeAzucar) {this.porcentajeAzucar = porcentajeAzucar;}
    
    public boolean getPromo() {return promo;}
    public double getPorcentajeAzucar() {return porcentajeAzucar;}
    @Override
    public String informacion() {return promo ? "\nIdentificador: #"+getId()+"\nMarca: "+getMarca()+"\nCantidad: "+getCantidad()+" lts.\nPrecio: $"+getPrecio()+" (Con promo)\nAzucar: "+getPorcentajeAzucar()+"%\nPromocion: Si": "\nIdentificador: #"+getId()+"\nMarca: "+getMarca()+"\nCantidad: "+getCantidad()+" lts.\nPrecio: $"+getPrecio()+"\nAzucar: "+getPorcentajeAzucar()+"%\nPromocion: No";}
}