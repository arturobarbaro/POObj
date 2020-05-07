package servicio;

import java.util.*;

import modelo.persona.empleado.*;
import modelo.persona.cliente.*;
import modelo.pedido.Pedido;
import modelo.mueble.Mueble;
import modelo.mueble.mesa.*;
import modelo.mueble.silla.*;
import modelo.enumerable.*;
import servicio.RegistroEmpleado;
import servicio.RegistroMueble;
import servicio.RegistroPedido;
import servicio.Entrada;
import servicio.Salida;

/**
 * Clase encargada de almacenar, insertar los pedidos que figuran en el sistema.
 * 
 * @author Arturo Barba
 */
public class RegistroPedido
{
    /**
     * Variable estática con el listado de todos los pedidos
     */
    public static List<Pedido> pedidos = new ArrayList<Pedido>();

    /**
     * Devuelve un pedido
     * @param id El ID
     * return Pedido El pedido
     */
    public static Pedido getPedido(int id) {
        Iterator<Pedido> iter  = pedidos.iterator();
        boolean encontrado = false;
        Pedido p;
        while (iter.hasNext() && !encontrado) { 
            p = iter.next();
            if (id == p.getId()) {
                encontrado = !encontrado;
                return p;
            }
        }
        return null;
    }

    /**
     * Devuelve un pedido en un estado determinado
     * @param id El ID del pedido
     * @param estado El estado del pedido
     * @return Pedido El pedido
     */
    public static Pedido getPedido(int id, Estado estado) {
        Iterator<Pedido> iter  = pedidos.iterator();
        boolean encontrado = false;
        Pedido p;
        while (iter.hasNext() && !encontrado) { 
            p = iter.next();
            if (id == p.getId() && p.getEstado() == estado) {
                encontrado = !encontrado;
                return p;
            }
        }
        return null;
    }

    /**
     * Devuelve un pedido elaborado por un artesano en cualquier estado
     * @param id El ID del pedido
     * @param artesano El artesano
     * @return Pedido El pedido
     */
    public static Pedido getPedido(int id, Artesano a) {
        Iterator<Pedido> iter  = pedidos.iterator();
        Pedido p;
        while (iter.hasNext()) { 
            p = iter.next();
            if (id == p.getId() && p.getArtesano() == a) {
                return p;
            }
        }
        return null;
    }

    /**
     * Devuelve un pedido de un cliente en un estado 
     * determinado
     * @param id El ID del pedido
     * @param estado El estado del pedido
     * @param c El cliente
     * @return Pedido El pedido
     */
    public static Pedido getPedido(int id, Estado estado, Cliente c) {
        Iterator<Pedido> iter  = pedidos.iterator();
        Pedido p;
        while (iter.hasNext()) { 
            p = iter.next();
            if (id == p.getId() && p.getEstado() == estado 
            && p.getCliente() == c) {
                return p;
            }
        }
        return null;
    }
    
    /**
     * Devuelve un pedido elaborado por un artesano en un estado 
     * determinado
     * @param id El ID del pedido
     * @param estado El estado del pedido
     * @param artesano El artesano
     * @return Pedido El pedido
     */
    public static Pedido getPedido(int id, Estado estado, Artesano a) {
        Iterator<Pedido> iter  = pedidos.iterator();
        Pedido p;
        while (iter.hasNext()) { 
            p = iter.next();
            if (id == p.getId() && p.getEstado() == estado 
            && p.getArtesano() == a) {
                return p;
            }
        }
        return null;
    }
    
    /**
     * Devuelve un pedido en estado PARADO y pendiente de peizas
     * @param id El ID del pedido
     * @param estado El estado del pedido
     * @return Pedido El pedido
     */
    public static Pedido getPedidoPendientePiezas(int id) {
        Iterator<Pedido> iter  = pedidos.iterator();
        boolean encontrado = false;
        Pedido p;
        while (iter.hasNext() && !encontrado) { 
            p = iter.next();
            if (id == p.getId() && p.getEstado() == Estado.PARADO && 
                p.getPiezas().size() > 0) {
                encontrado = !encontrado;
                return p;
            }
        }
        return null;
    }
    
    /**
     * Devuelve el pedido que ha sido añadido antes al sistema
     * @param List<Pedido> Los pedidos a filtrar
     * @return Pedido El pedido mas longevo
     */
    public static Pedido getSiguientePedido(List<Pedido> p) {
        if (p.size()==0) return null;
        int i, pos = 0;
        for (i = 0; p.size() > i; i++) {
            if (p.get(pos).getId() > p.get(i).getId()) {
                pos = i;
            }
        }
        return p.get(pos);
    }

    /**
     * Devuelve todos los pedidos 
     * @return List<Pedido> Los pedidos
     */
    public static List<Pedido> getPedidos() {
        return pedidos;
    }

    /**
     * Devuelve todos los pedidos en un estado determinado
     * @param estado El estado del pedido
     * @return List<Pedido> Los pedidos
     */
    public static List<Pedido> getPedidos(Estado e) {
        ArrayList<Pedido> ps = new ArrayList<Pedido>();
        Iterator<Pedido> iter  = pedidos.iterator();
        boolean encontrado = false;
        Pedido p;
        while (iter.hasNext() && !encontrado) { 
            p = iter.next();
            if (e == p.getEstado()) {
                ps.add(p);
            }
        }
        return ps;
    }

    /**
     * Devuelve todos los pedidos de un cliente en un estado 
     * determinado
     * @param estado El estado del pedido
     * @param c El Cliente
     * @return List<Pedido> Los pedidos
     */
    public static List<Pedido> getPedidos(Estado estado, Cliente c) {
        ArrayList<Pedido> ps = new ArrayList<Pedido>();
        Iterator<Pedido> iter  = pedidos.iterator();
        Pedido p;
        while (iter.hasNext()) { 
            p = iter.next();
            if (p.getCliente() == c && p.getEstado() == estado) {
                ps.add(p);
            }
        }
        return ps;
    }
    
    /**
     * Devuelve todos los pedidos elaborados por un artesano en un estado 
     * determinado
     * @param estado El estado del pedido
     * @param artesano El artesano
     * @return List<Pedido> Los pedidos
     */
    public static List<Pedido> getPedidos(Estado estado, Artesano a) {
        ArrayList<Pedido> ps = new ArrayList<Pedido>();
        Iterator<Pedido> iter = pedidos.iterator();
        Pedido p;
        for (int i = 0; pedidos.size() > i; i++) {
            p = pedidos.get(i);
            if (p.getArtesano() == a && p.getEstado() == estado) {
                ps.add(p);
            }
        }
        return ps;
    }
    
    /**
     * Devuelve un listado con todos los pedidos parados pendientes de piezas
     * @return List<Pedido> La lista de pedidos
     */
    public static List<Pedido> getPedidosPendientesDePiezas(){
        List<Pedido> p = getPedidos(Estado.PARADO);
        List<Pedido> pedidosSinPiezas = new ArrayList<Pedido>();
        for (int i = 0; p.size() > i; i++) {
            if (p.get(i).getPiezas().size() > 0) {
                pedidosSinPiezas.add(p.get(i));
            }
        }
        return pedidosSinPiezas;
    }
    
    /**
     * Indica si figuran pedidos en el sistema
     * @return true|false si tiene pedidos
     */
    public static boolean tienePedidos() {
        return pedidos.size() > 0;
    }

    /**
     * Indica si figuran pedidos en el sistema en un estado
     * @param e El estado
     * @return true|false si tiene pedidos
     */
    public static boolean tienePedidos(Estado e) {
        return getPedidos(e).size() > 0;
    }

    /**
     * Muestra todos los pedidos 
     */
    public static void listarPedidos(){
        Salida.separadorGordo();
        Salida.mostrar("LISTA DE PEDIDOS");
        Salida.separadorFino();
        if (pedidos.size() == 0) {
            Salida.mostrar("No existe ningún pedido");
            Salida.separadorGordo();
            return;
        }
        
        for (int i = 0; Estado.values().length > i; i++) {
          listarPedidos(Estado.values()[i]); 
        }
    }

    /**
     * Muestra todos los pedidos en un estado determinado
     * @param estado El estado del pedido
     */
    public static void listarPedidos(Estado estado){
        Salida.salto();
        Salida.separadorGordo();
        Salida.mostrar("PEDIDOS EN ESTADO "+estado.toString().toUpperCase());
        Salida.separadorFino();
        if (getPedidos(estado).size() == 0) {
            Salida.mostrar("No existe ningún pedido en el estado "
                +estado.toString().toLowerCase());
            Salida.separadorGordo();
            return;
        }
        List<Pedido> p = getPedidos(estado);
        for (int i = 0; p.size() > i; i++) {
            Salida.mostrar(p.get(i).toString());
        }
        Salida.separadorGordo();
    }

    /**
     * Muestra todos los pedidos realizados por un cliente en un estado 
     * determinado
     * @param estado El estado del pedido
     * @param cliente El cliente
     */
    public static void listarPedidos(Estado estado, Cliente c) {
        List<Pedido> p = getPedidos(estado, c);
        Salida.salto();
        Salida.separadorGordo();
        Salida.mostrar("PEDIDOS EN ESTADO "+estado.toString().toUpperCase());
        Salida.separadorFino();
        if (p.size() == 0) {
            Salida.mostrar("No existen pedidos con estas características");
            return;
        }
        for (int i = 0; p.size() > i; i++) {
            Salida.mostrar(p.get(i).toString());
        }
        Salida.separadorGordo();
    }
    
    /**
     * Muestra todos los pedidos elaborados por un artesano en un estado 
     * determinado
     * @param estado El estado del pedido
     * @param artesano El artesano
     */
    public static void listarPedidos(Estado estado, Artesano a) {
        List<Pedido> p = getPedidos(estado, a);
        Salida.salto();
        Salida.salto();
        Salida.separadorGordo();
        Salida.mostrar("PEDIDOS EN ESTADO "+estado.toString().toUpperCase());
        Salida.separadorFino();
        if (p.size() == 0) {
            Salida.mostrar("No existen pedidos con estas características");
            return;
        }
        for (int i = 0; p.size() > i; i++) {
            Salida.mostrar(p.get(i).toString());
        }
        Salida.separadorGordo();
    }
    
    /**
     * Muestra todos los pedidos parados pendientes de piezas
     */
    public static void listarPedidosPendientesDePiezas(){
        Salida.salto();
        Salida.separadorGordo();
        Salida.mostrar("PEDIDOS  PARADOS POR FALTA DE PIEZAS");
        Salida.separadorFino();
        List<Pedido> p = getPedidosPendientesDePiezas();
        if (p.size() == 0) {
            Salida.mostrar("No hay pedidos pendientes de piezas");
            Salida.separadorGordo();
            return;
        }
        
        for (int i = 0; p.size() > i; i++) {
            if (p.get(i).getPiezas().size() > 0) {
                Salida.mostrar(p.get(i).toString());
            }
        }
        
        Salida.separadorGordo();
    }

    /**
     * Muestra un submenú de opciones con tipos de Estado
     */
    public static void listarEstadosPedido() {
        int index;
        for (int i = 0; i < Estado.values().length; i++) {
            index = i + 1;
            Salida.mostrar("["+index+"] " + Estado.values()[i].toString());
        }
    }

    /**
     * Muestra un menú de selección de opciones con todos los estados 
     * disponibles de un pedido y muestra todos los pedidos con el estado
     * seleccionado
     */
    public static void listarPedidosEstado() {
        listarEstadosPedido();
        Salida.mostrar("[0] Salir");
        int op = Entrada.getInt(0, Estado.values().length);
        if (op == 0) return;
        listarPedidos(Estado.values()[op - 1]);
    }
    
    /**
     * Muestra un menú de opciones y realiza una búsqueda de pedidos por 
     * estados en el sistema en función de la opción seleccionada
     */
    public static void menuBuscarPedido() {
        listarEstadosPedido();
        Salida.mostrar("[0] Salir");
        int op = Entrada.getInt(0, Estado.values().length);
        if (op==0) return;
        buscarPedido(Estado.values()[op-1]);
    }

    /**
     * Muestra la información de un pedido seleccionado
     */
    public static void buscarPedido() {
        listarPedidos();
        if (!tienePedidos()) return;
        Salida.mostrar("Introduzca el id del pedido");
        Pedido p = getPedido(Entrada.getInt());
        if (p==null) {
            Salida.mostrar("No existe ningun pedido con ese ID");
            return;
        }
        Salida.mostrar(p.toString());
    }

    /**
     * Muestra la información de un pedido seleccionado en un estado
     * @param e El estado
     */
    public static void buscarPedido(Estado e) {
        listarPedidos(e);
        if (!tienePedidos(e)) return;
        Salida.mostrar("Introduzca el id del pedido");
        Pedido p = getPedido(Entrada.getInt(), e);
        if (p==null) {
            Salida.mostrar("No existe ningun pedido con ese ID en ese estado");
            return;
        }
        Salida.mostrar(p.toString());
    }

    /**
     * Permite que un cliente que disponga de pedidos en el estado ENTREGAR o 
     * RECOGER confirme la recepción de este y se actualicen los datos del
     * sistema
     */
    public static void finalizarPedido() {
        if(!RegistroCliente.tieneClientes()) {
            Salida.mostrar("No existen clientes en el sistema");
            return;
        }

        if(!tienePedidos(Estado.ENTREGAR)||!tienePedidos(Estado.RECOGER)) {
            Salida.mostrar("No existen pedidos por recoger ni por entregar");
            return;
        }

        int id;
        Cliente cliente;
        do {
            Salida.mostrar("Introduzca el id del cliente o 0 para salir");
            id = Entrada.getInt();
            if (id == 0) return;
            cliente = RegistroCliente.getCliente(id);
        } while(cliente==null);

        listarPedidos(Estado.RECOGER, cliente);
        listarPedidos(Estado.ENTREGAR, cliente);
        if (getPedidos(Estado.RECOGER, cliente).size() == 0 &&
        getPedidos(Estado.ENTREGAR, cliente).size() == 0
        ) {
            Salida.mostrar("No tiene pedidos por recoger ni entregar");
            return;
        }

        Pedido p;
        do {
            Salida.mostrar("Introduzca el id del pedido o 0 para salir");
            id = Entrada.getInt();
            if (id == 0) return;
            p = getPedido(id,Estado.ENTREGAR,cliente);
            if (p == null)
                p = getPedido(id,Estado.RECOGER,cliente);
            if (p == null) {
                Salida.mostrar("ID erroneo");
            }
        } while(p==null);

        Salida.mostrar("Se ha confirmado la recepcion del pedio "+p.toString());
        p.setEstado(Estado.FINALIZADO);
    }

    /**
     * Permite que un cliente pueda realizar un nuevo pedido.
     * Muestra varios submenús y añade un nuevo pedido al sistema 
     */
    public static void anotarPedido() {
        ArrayList <Mueble> productos = new ArrayList <Mueble>();
        
        if (!RegistroCliente.tieneClientes()) {
            Salida.mostrar("No hay clientes en el sistema, registrese para iniciar un pedido");
            return;
        }

        int id;
        Cliente cliente;
        RegistroCliente.listarClientes();
        do {
            Salida.mostrar("Introduzca el id del cliente o 0 para salir");
            id = Entrada.getInt();
            if (id == 0) return;
            cliente = RegistroCliente.getCliente(id);
            if (cliente == null) {
                Salida.mostrar("ID erroneo");
            }
        } while(cliente==null);

        int opcion;
        do {
            do {
                Salida.mostrarOpcionesPedido();
                opcion = Entrada.getInt();
            } while (
            (opcion == 2 && productos.size() == 0)
            || opcion > 2 || opcion < 0);

            if (opcion == 0) return;

            switch (opcion) {
                case 1:
                productos = addProductos(productos);
                Salida.mostrar("Se ha añadido el mueble a la cesta");
                Salida.salto();
                break;
                case 2:
                addPedido(new Pedido(productos, cliente));
                Salida.mostrar("Se ha realizado el pedido correctamente");
                Salida.salto();
                return;
                default:
                return;
            }

        } while (opcion == 1);
    } 
    
    /**
     * Añade un pedido al sistema
     * @param p El pedido
     */
    public static void addPedido(Pedido p) {
        pedidos.add(p);
    }

    /**
     * Método auxiliar en anotarPedido().
     * Muestra un submenú y recoge datos para añadir muebles a un pedido
     */
    private static ArrayList<Mueble> addProductos(ArrayList<Mueble> p) {
        Salida.mostrarMensajeMuebles();
        int opcion = Entrada.getInt(0, 2);
        switch (opcion) {
            case 1:
            Salida.mostrarMensajeSillas();
            p = addSilla(p);
            break;
            case 2:
            Salida.mostrarMensajeMesas();
            p = addMesa(p);
            default:
            return p;
        }
        return p;
    }

    /**
     * Método auxiliar en addProductos().
     * Muestra un submenú y recoge datos para añadir sillas a un pedido
     */
    private static ArrayList<Mueble> addSilla(ArrayList<Mueble> p){
        int opcion = Entrada.getInt(0, 3);
        switch (opcion) {
            case 1:
            Salida.mostrarMensajeSillaOficina();
            opcion = Entrada.getInt(0, 3);
            if (opcion == 1) {
                p.add(new SillaConRuedas());
            } else if (opcion == 2) {
                p.add(new SillaSinRuedas());
            } else {
                return p;
            }
            break;
            case 2:
            p.add(new SillaCocina());
            case 3:
            p.add(new SillaPlegable());
            default:
            return p;
        }
        return p;
    }

    /**
     * Método auxiliar en addProductos().
     * Muestra un submenú y recoge datos para añadir mesas a un pedido
     */
    private static ArrayList<Mueble> addMesa(ArrayList<Mueble> p){
        int opcion = Entrada.getInt(0, 3);
        switch (opcion) {
            case 1:
            Salida.mostrarMensajeMesaCafe();
            opcion = Entrada.getInt(0, 3);
            if (opcion == 1) {
                p.add(new MesaCafeCristal());
            } else if (opcion == 2) {
                p.add(new MesaCafeMadera());
            } else {
                return p;
            }
            break;
            case 2:
            p.add(new MesaDeDormitorio());
            case 3:
            p.add(new MesaDeComedor());
            default:
            return p;
        }
        return p;
    }
}
