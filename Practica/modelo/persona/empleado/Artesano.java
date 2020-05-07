package modelo.persona.empleado;


import modelo.persona.Persona;
import modelo.pedido.Pedido;
import modelo.enumerable.*;
import servicio.*;

import java.util.*;

/**
 * Abstract class Artesano - Subclase de Empleado 
 * 
 * @author: Arturo Barba
 */
public abstract class Artesano extends Empleado
{
    /**
     * Listado de pedidos en los que trabaja o ha trabajado el Artesano
     */
    private List<Pedido> pedidos;
    
    /**
     * Constructor de Artesano
     */
    public Artesano() {
       super();
       this.pedidos = new ArrayList <Pedido>();
    }
    
    /**
     * Constructor de Artesano que recibe el nombre
     * @param nombre El nombre
     */
    public Artesano(String nombre) {
       super(nombre);
       this.pedidos = new ArrayList <Pedido>();
    }
    
    /**
     * Getter de pedidos
     * @return List<Pedido> Los pedidos
     */
    public List<Pedido> getPedidos() {
        return this.pedidos;
    }
    
    /**
     * Lista todos los pedidos del artesano en un estado
     * @param e El estado de los pedidos a obtener
     * @return List<Pedido> Los pedidos
     */
    public List<Pedido> getPedidos(Estado e) {
        return RegistroPedido.getPedidos(e, this);
    }
    
    /**
     * Lista todos los pedidos en fabricación por el artesano
     */
    public void verPedidosPendientes() {
        RegistroPedido.listarPedidos(Estado.COLA_FABRICACION, this);
    }
    
    /**
     * Método que asigna un Pedido a un artesano 
     * @param Pedido El pedido
     */
    public void asignarTrabajo(Pedido pedido)
    {
        this.pedidos.add(pedido);
        pedido.setEstado(Estado.COLA_FABRICACION);
        comenzarSiguienteTrabajo();
    }
    
    /**
     * Método que actualiza el estado de un Pedido cuando el Artesano ha
     * terminado con su fabricación y comienza con la fabricación del
     * siguiente, siempre que haya pendientes
     * @param Pedido El pedido
     */
    public void finalizarTrabajo(Pedido pedido)
    {
        pedido.setEstado(Estado.FABRICADO);
        comenzarSiguienteTrabajo();
    }
    
    /**
     * Método que actualiza el estado de un Pedido a Estado.PARADO
     * y comienza con la fabricación el siguiente, siempre que haya 
     * pendientes
     * @param Pedido El pedido
     */
    public void detenerTrabajo(Pedido p) {
        p.setEstado(Estado.PARADO);
        comenzarSiguienteTrabajo();
    }
    
    /**
     * Método que actualiza el estado de un Pedido a Estado.PARADO por falta de
     * piezas y comienza con la fabricación el siguiente, siempre que haya 
     * pendientes
     * @param pedido El pedido
     * @param piezas El listado con las piezas que faltan
     */
    public void detenerTrabajo(Pedido pedido, ArrayList<Pieza> piezas) {
        pedido.setEstado(Estado.PARADO);
        pedido.setPiezas(piezas);
        comenzarSiguienteTrabajo();
    }
    
    /**
     * Devuelve el siguiente pedido con el que debe comenzar a trabajar 
     * un artesano, devolverá el pedido que lleve mas tiempo en el sistema,
     * es decir, el que tiene menor ID
     * @return Pedido El pedido
     */
    private Pedido getSiguientePedido() {
        return RegistroPedido.getSiguientePedido(getPedidos(Estado.COLA_FABRICACION));
    }
   
    /**
     * Consulta en el sistema la siguiente tarea a realizar, y en el caso de
     * que exista una y el artesano no este involucrado en otra tarea
     * se comienza con la fabricación de esta
     */
    private void comenzarSiguienteTrabajo() {
        if (getPedidos(Estado.FABRICACION).size() == 0 && getPedidos(Estado.COLA_FABRICACION).size() > 0) {
            getSiguientePedido().setEstado(Estado.FABRICACION);
        }
    }
}
