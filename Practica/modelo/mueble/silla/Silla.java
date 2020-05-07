package modelo.mueble.silla;

import modelo.mueble.Mueble;

/**
 * Subclase de Mueble que engloba a todas las sillas
 * 
 * @author Arturo Barba
 */
public abstract class Silla extends Mueble
{
    /**
     * Constructor Silla
     */
    public Silla()
    {
        super();
    }
    
    /**
     * Constructor Silla que recibe un precio
     * @param precio el precio
     */
    public Silla(double precio)
    {
        super(precio);
    }

    /**
     * Método toString
     * @return String Información
     */
    public String toString() {
        return "Mueble tipo silla. "+super.toString();
    }
}
