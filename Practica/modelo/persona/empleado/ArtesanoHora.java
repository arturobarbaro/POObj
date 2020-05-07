package modelo.persona.empleado;

import modelo.persona.Persona;

/**
 * Subclase de Artesano. Artesano que trabaja por horas.
 * 
 * @author Arturo Barba
 */
public class ArtesanoHora extends Artesano
{
    /**
     * Constructor de ArtesanoHora
     */
    public ArtesanoHora() {
       super();
    }
    
    /**
     * Constructor de ArtesanoHora que recibe un nombre
     * @param nombre El nombre
     */
    public ArtesanoHora(String nombre) {
       super(nombre);
    }
    
    /**
     * Método toString
     * @return String Información
     */
    public String toString() {
        return super.toString() + ". Puesto: artesano con contrato por hora";
    }
}
