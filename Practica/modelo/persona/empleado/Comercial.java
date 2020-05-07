package modelo.persona.empleado;

import modelo.persona.Persona;
import modelo.pedido.Pedido;
import modelo.enumerable.Estado;
import modelo.persona.empleado.*; 
import modelo.persona.cliente.Cliente;
import modelo.mueble.Mueble; 
import modelo.enumerable.Estado;

import java.util.*;

/**
 * Clase Comercial - Subclase de Empleado que especifica un empleado que 
 * trabaja como comercial
 * 
 * @author Arturo Barba
 */
public class Comercial extends Empleado
{
    /**
     * Constructor de subclase Comercial
     */
    public Comercial() {
       super();
    }
    
    /**
     * Constructor de subclase Comercial que recibe el nombre
     * @param nombre El nombre
     */
    public Comercial(String nombre) {
       super(nombre);
    }
    
    /**
     * Método que actualiza el estado de un Pedido a Estado.RECOGER
     * @param Pedido El pedido
     */
    public void notificarClienteRecoger(Pedido p) {
        p.setEstado(Estado.RECOGER);
    }
    
    /**
     * Método que actualiza el estado de un Pedido a Estado.ENTREGAR
     * @param Pedido El pedido
     */
    public void notificarClienteEntregar(Pedido p) {
        p.setEstado(Estado.ENTREGAR);
    }
    
    /**
     * Método que establece un precio a un Pedido
     * @param Pedido El pedido
     */
    public void establecerPrecio(Pedido p) {
        double total = 0;
        ArrayList<Mueble> m = p.getMuebles();
        for (int i = 0; i < m.size(); i++) {
            total += m.get(i).getPrecio();
        }
        double scale = Math.pow(10, 2);

        total = Math.round(total * scale) / scale;
        p.setPrecio(total);
        p.setEstado(Estado.PENDIENTE);
    }
    
    /**
     * Método toString
     * @return String Información
     */
    public String toString() {
        return super.toString() + ". Puesto: comercial";
    }
}
