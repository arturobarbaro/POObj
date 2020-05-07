package modelo.persona.empleado;

import modelo.persona.Persona;

/**
 * Subclase de Artesano. Artesano que figura en la plantilla
 * 
 * @author Arturo Barba
 */
public class ArtesanoPlantilla extends Artesano
{
    /**
     * Constructor de ArtesanoPlantilla
     */
    public ArtesanoPlantilla() {
       super();
    }
    
    /**
     * Constructor de ArtesanoPlantilla que recibe un nombre
     * @param nombre El nombre
     */
    public ArtesanoPlantilla(String nombre) {
       super(nombre);
    }
    
    /**
     * Método toString
     * @return String Información
     */
    public String toString() {
        return super.toString() + ". Puesto: artesano en plantilla";
    }
}
