package modelo.persona.cliente;

import modelo.persona.Persona;
/**
 * Subclase Cliente - Cliente particular
 * 
 * @author Arturo Barba
 */
public class Particular extends Cliente
{
    /**
     * Constructor de Particular
     */
    public Particular() {
       super();
    }
    
    /**
     * Constructor de Particular que recibe un nombre
     * @param nombre El nombre del empresario
     */
    public Particular(String nombre) {
       super(nombre);
    }
    
    /**
     * Método toString
     * @return String Información
     */
    public String toString() {
        return super.toString() + ". Tipo cliente: particular";
    }
}
