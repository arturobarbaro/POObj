package modelo.pedido;

import modelo.persona.empleado.*; 
import modelo.persona.cliente.Cliente;
import modelo.mueble.Mueble; 
import modelo.enumerable.*;

import java.util.*;

/**
 * Clase Pedido. Clase encarga de instanciar un nuevo pedido realizado 
 * por un un cliente que figure en el sistema, fabricado por un artesano,
 * con un precio asignado por un comercial y con productos de tipo Mueble
 * 
 * @author Arturo Barba
 */
public class Pedido
{
    /**
     * Variable estática encargada de almacenar un id único y autoincremetado
     */
    private static int idActual = 1;
    /**
     * El ID del pedido
     */
    private int id;
    /**
     * Cliente que ha realizado el pedido
     */
    private Cliente cliente;
    /**
     * Comercial encargado de la gestión del pedido
     */
    private Comercial comercial;
    /**
     * Artesano encargado de la fabricación de los muebles del pedido siempre 
     * que proceda, es decir, que el cliente haya aceptado el presupuesto
     * dado por el comercial
     */
    private Artesano artesano;
    /**
     * Listado de todos los muebles que forman parte del pedido
     */
    private ArrayList <Mueble> muebles;
    /**
     * Estado del pedido.
     */
    private Estado estado;
    /**
     * Precio del pedido
     */
    private double precio = 0;
    /**
     * Variable que indica si el precio ha sido asignado por el comercial
     * correspondiente. Si aún no ha sido asginado se reflajará en el estado
     * y el precio será el de por defecto
     */
    private boolean precioAsignado = false;
    /**
     * Listado de piezas necesarias para fabricar un pedido.
     * Sera nulo si el estado no es Estado.PARADO
     */
    private ArrayList <Pieza> piezasPendientes;

    /**
     * Constructor Pedido. Crea un pedido con el cliente y los muebles
     * recibidos, asigna un ID al pedido y le asigna el estado Estado.NUEVO
     * @param muebles Los muebles del pedido
     * @param cliente El cliente que ha realizado el pedido
     */
    public Pedido(ArrayList <Mueble> muebles, Cliente cliente)
    {
        this.muebles = new ArrayList <Mueble>(muebles);
        this.id = this.idActual;
        this.idActual++;
        this.estado = Estado.NUEVO;
        this.cliente = cliente;
        this.piezasPendientes = new ArrayList <Pieza>();
    }
    
    /**
     * Getter del ID
     * @return int ID del pedido
     */
    public int getId() {
        return this.id;
    }

    /**
     * Getter del precio. Devuelve 0 si el precio aun no ha sido asignado 
     * por un comercial.
     * @return double precio
     */
    public double getPrecio() {
        if (this.precioAsignado) return this.precio;
        return 0;
    }
    
    /**
     * Getter de los muebles del pedido
     * @return ArrayList<Mueble> Los muebles
     */
    public ArrayList<Mueble> getMuebles() {
        return this.muebles;
    }
    
    /**
     * Getter del artesano
     * @return Artesano El artesano
     */
    public Artesano getArtesano() {
        return this.artesano;
    }
    
    /**
     * Getter del cliente
     * @return Cliente El cliente
     */
    public Cliente getCliente() {
        return this.cliente;
    }
    
    /**
     * Getter del estado
     * @return Estado El estado del pedido
     */
    public Estado getEstado() {
        return this.estado;
    }
    
     /**
     * Getter de las piezas necesarias para continuar el pedido.
     * @return ArrayList<Pieza> Las piezas
     */
    public ArrayList<Pieza> getPiezas() {
        return this.piezasPendientes;
    }
    
    /**
     * Setter estado
     * @param estado El nuevo estado del pedido
     */
    public void setEstado(Estado estado) {
        if (estado!=null)
            this.estado = estado;
    }
    
    /**
     * Setter de piezas pendientes
     * @param p Las piezas
     */
    public void setPiezas(ArrayList<Pieza> p) {
        if (p!=null)
            this.piezasPendientes = p;
    }
    
    /**
     * Setter precio
     * @param precio El nuevo precio del pedido
     */
    public void setPrecio(double v) {
        this.precio = v;
        this.precioAsignado = true;
    }
    
    /**
     * Setter artesano
     * @param artesano El artesano encargado de la fabricación de los muebles 
     * del pedido
     */
    public void setArtesano(Artesano artesano) {
        if (artesano!=null)
            this.artesano = artesano;
    }
    
    /**
     * Método toString
     * @return String Información del pedido
     */
    public String toString() {
        if (this.precioAsignado)
        return "Pedido con ID: "+ this.id +". "+"Comprado por "
        +this.cliente.toString()+". Precio: "+this.getPrecio()+"€. "+
        "Estado "+getEstado().toString().toLowerCase();
        return "Pedido con ID: "+ this.id +". "+"Comprado por "
        +this.cliente.toString()+
        ". Estado "+getEstado().toString().toLowerCase();
    }
}
