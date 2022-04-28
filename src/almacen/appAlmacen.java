package almacen;
import java.util.Scanner;
public class appAlmacen {
    public static void main(String[] args) {
        System.out.println("Que tamaño desea que tenga el Almacen?");
        int filas=inicializarFilas(),columnas=inicializarColumnas();
        Datos almacen=new Datos(filas,columnas); menu(almacen);
    }
    public static int inicializarFilas() {
        int f=-1; Scanner entrada=new Scanner(System.in);
        do{ System.out.print("\nFilas: "); f=entrada.nextInt();
            if(f<1) System.out.println("\nERROR - Los numeros deben de ser mayores que cero");
        }while(f<1); return f;
    }
    public static int inicializarColumnas() {
        int c=-1; Scanner entrada=new Scanner(System.in);
        do{ System.out.print("\nColumnas: "); c=entrada.nextInt();
            if(c<1) System.out.println("\nERROR - Los numeros deben de ser mayores que cero");
        }while(c<1); return c;
    }
    public static void menu(Datos almacen) {
        int op=0; Scanner entrada=new Scanner(System.in);
        boolean seguir=true;
        do{ System.out.println("\n\n\tAplicacion de Almacen\n");
            System.out.println("1 - Agregar Producto");
            System.out.println("2 - Eliminar Producto");
            System.out.println("3 - Calcular Precio-Marca");
            System.out.println("4 - Calcular Precio-Total");
            System.out.println("5 - Mostrar Informacion");
            System.out.println("6 - Salir");
            do{ System.out.print("\nOpcion: "); op=entrada.nextInt();
                if(op<1||op>6) System.out.println("\nERROR - Opcion Invalida");
            }while(op<1||op>6);
            switch(op){
                case 1 -> agregarProducto(almacen);
                case 2 -> eliminarProducto(almacen);
                case 3 -> precioMarca(almacen);
                case 4 -> almacen.calcularAlmacen();
                case 5 -> almacen.mostrarInformacion();
                case 6 -> seguir=false;
                default -> System.out.println("\nERROR - Opcion Invalida");
            }
        }while(seguir);
    }
    public static void agregarProducto(Datos almacen) {
        String id,marca,texto,origen; boolean promo;
        double cantidad,precio,porcentajeAzucar; int op=0;
        Scanner opInput=new Scanner(System.in),idInput=new Scanner(System.in),
                marcaInput=new Scanner(System.in),promoInput=new Scanner(System.in),
                origenInput=new Scanner(System.in),azucarInput=new Scanner(System.in),
                cantidadInput=new Scanner(System.in),precioInput=new Scanner(System.in);
        System.out.println("\n\n\tQue producto desea añadir\n");
        System.out.println("1 - AguaMineral");
        System.out.println("2 - BebidaAzucarada");
        System.out.println("3 - Salir");
        do{ System.out.print("\nOpcion: "); op=opInput.nextInt();
            if(op<1||op>3) System.out.println("\nERROR - Opcion Invalida");
        }while(op<1||op>3); if(op!=3) {
        System.out.print("Id del Producto: #"); id=idInput.nextLine();
        System.out.print("Marca del Producto: "); marca=marcaInput.nextLine();
        System.out.print("Cantidad del Producto (lts.): "); cantidad=cantidadInput.nextDouble();
        System.out.print("Precio del Producto: $"); precio=precioInput.nextDouble();
        switch(op){
            case 1 -> {
                System.out.print("Origen del Producto: "); origen=origenInput.nextLine();
                AguaMineral aguaMineral=new AguaMineral(id,marca,cantidad,precio,origen);
                almacen.agregarProducto(aguaMineral); break;}
            case 2 -> {
                System.out.print("Azucar del Producto: %"); porcentajeAzucar=azucarInput.nextDouble();
                System.out.print("Promocion (S/N): "); texto=promoInput.nextLine();
                switch(texto){ case "s" -> promo=true; case "S" -> promo=true;
                               case "n" -> promo=false; case "N" -> promo=false;
                               default -> {promo=false; System.out.print("\nOpcion de Promocion incorrecta, por default sera False");}}
                BebidaAzucarada bebidaAzucarada=new BebidaAzucarada(id,marca,cantidad,precio,porcentajeAzucar,promo);
                almacen.agregarProducto(bebidaAzucarada); break;}
            default -> System.out.println("\nERROR - Opcion Invalida");
        }}
    }
    public static void eliminarProducto(Datos almacen) { 
        String id; Scanner entrada=new Scanner(System.in);
        System.out.print("\nQue producto desea eliminar?\nSeleccione por ID: "); id=entrada.nextLine();
        if(almacen.eliminarProducto(id)) System.out.println("Producto eliminado satisfactoriamente");
        else System.out.println("ERROR - ID incorrecta o producto no existente");
    }
    public static void precioMarca(Datos almacen) {
        String marca; Scanner entrada=new Scanner(System.in);
        System.out.print("\nQue marca de producto desea calcular?\nIntroduzca marca: ");
        marca=entrada.nextLine(); almacen.calcularMarca(marca);
    }
}