package modelo.persona.cliente;

import modelo.persona.Persona;
import modelo.pedido.Pedido;
import modelo.enumerable.*;

/**
 * Abstract class Cliente - Subclase de Persona con rol de Cliente
 * 
 * @author: Arturo Barba
 */
public abstract class Cliente extends Persona
{
    /**
     * Variable estática encargada de almacenar un id único y autoincremetado
     */
    private static int idActual = 1;
    /**
     * ID del cliente
     */
    private int clienteId;

    /**
     * Constructor de Cliente
     */
    public Cliente() {
        super();
        this.clienteId = this.idActual;
        this.idActual++;
    }

    /**
     * Constructor de Cliente que recibe un nombre
     * @param nombre El nombre
     */
    public Cliente(String nombre) {
        super(nombre);
        this.clienteId = this.idActual;
        this.idActual++;
    }

    /**
     * Getter del ID del cliente
     * @return int El ID
     */
    public int getClienteId() {
        return this.clienteId;
    }

    /**
     * Método encargado de rechazar el presupuesto de un pedido
     * @param Pedido El pedido
     */
    public void rechazarPresupuesto(Pedido p){
        p.setEstado(Estado.CANCELADO);
    }

    /**
     * Método encargado de aceptar el presupuesto de un pedido
     * @param Pedido El pedido
     */
    public void aceptarPresupuesto(Pedido p){
        p.setEstado(Estado.ACEPTADO);
    }

    /**
     * Método toString
     * @return String Información
     */
    public String toString() {
        return super.toString() + " id: "+getClienteId();
    }
}
