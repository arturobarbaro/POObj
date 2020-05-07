package modelo.persona.empleado;

import java.util.*;
import modelo.persona.Persona;
import modelo.pedido.*;
import modelo.enumerable.*;

/**
 * Clase Jefe - Subclase de Empleado con el rol de Jefe
 * 
 * @author Arturo Barba
 */
public class Jefe extends Empleado
{
    /**
     * Constructor de Jefe
     */
    public Jefe() {
       super();
    }
    
    /**
     * Constructor de Jefe que recibe el nombre
     * @param nombre El nombre
     */
    public Jefe(String nombre) {
       super(nombre);
    }

    /**
     * Método que asigna un pedido a un Artesano para que comience a trabajar 
     * en él.
     * @param Pedido El pedido
     * @param Artesano El empleado artesano
     */
    public void asignarPedido(Pedido pedido, Artesano artesano)
    {
        pedido.setEstado(Estado.COLA_FABRICACION);
        pedido.setArtesano(artesano);
        artesano.asignarTrabajo(pedido);
    }
    
    /**
     * Método que repone las piezas de un pedido y lo reasigna a su
     * Artesano para que comience a trabajar en él.
     * @param Pedido El pedido
     */
    public void reponerPiezas(Pedido pedido)
    {
        pedido.setEstado(Estado.COLA_FABRICACION);
        pedido.setPiezas(new ArrayList<Pieza>());
    }
    
    /**
     * Método toString
     * @return String información
     */
    public String toString() {
        return super.toString() + ". Puesto: jefe";
    }
}
