package modelo.mueble.mesa;

import modelo.mueble.Mueble;

/**
 * Sublcase de Mueble que engloba a todos los muebles de tipo mesa
 * @author Arturo Barba
 */
public abstract class Mesa extends Mueble
{
    /**
     * Constructor de Mesa
     */
    public Mesa()
    {
        super();
    }
    
    /**
     * Constructor de Mesa que recibe un precio
     * @param precio El precio
     */
    public Mesa(double precio)
    {
        super(precio);
    }

    /**
     * Método toString
     * @return String Información
     */
    public String toString() {
        return "Mueble tipo mesa. "+super.toString();
    }
}
