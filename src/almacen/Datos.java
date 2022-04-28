package almacen;
public class Datos {
    private final int r,c;
    private final Bebida [][] almacen;
    
    public Datos(int r,int c) {
        this.almacen=new Bebida[r][c];
        this.r=r ; this.c=c;
    }
    public void mostrarInformacion() {
        for(int x=0;x<r;x++) for(int y=0;y<c;y++)
        System.out.println(almacen[x][y]!=null ? almacen[x][y].informacion() : "\nEspacio vacio");
    }
    public void agregarProducto(Bebida nuevaBebida) {
        boolean seguir=true; for(int x=0;seguir&&x<r;x++) for(int y=0;seguir&&x<c;y++)
        if(almacen[x][y]==null) {almacen[x][y]=nuevaBebida;seguir=false;}
    }
    public boolean eliminarProducto(String id) { boolean check=false;
        boolean seguir=true; for(int x=0;seguir&&x<r;x++) for(int y=0;seguir&&x<c;y++)
        if(almacen[x][y]!=null) if(almacen[x][y].getId().equals(id)) {almacen[x][y]=null;seguir=false;check=true;}
        return check;
    }
    public void calcularAlmacen() {
        double precio=0; for(int x=0;x<r;x++) for(int y=0;y<c;y++)
        if(almacen[x][y]!=null) precio+=almacen[x][y].getPrecio();
        System.out.println("\nPrecio total del Almacen: $"+precio);
    }
    public void calcularMarca(String marca) {
        double precio=0; for(int x=0;x<r;x++) for(int y=0;y<c;y++)
        if(almacen[x][y]!=null) if(almacen[x][y].getMarca().equals(marca)) precio+=almacen[x][y].getPrecio();
        System.out.println("\nPrecio total de "+marca+": $"+precio);
    }
}