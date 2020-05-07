package modelo.mueble.mesa;

import modelo.mueble.Mueble;
/**
 * Subclase de Mesa. Clase Abstracta
 * 
 * @author Arturo Barba
 */
public abstract class MesaDeCafe extends Mesa
{
    /**
     * Constructor MesaDeCafe
     */
    public MesaDeCafe()
    {
        super();
    }
    
    /**
     * Constructor MesaDeCafe que recibe un precio
     * @param precio El precio
     */
    public MesaDeCafe(double precio)
    {
        super(precio);
    }

    /**
     * Método toString
     * @return String Información
     */
    public String toString() {
        return super.toString() + " Destinada para tomar café.";
    }
}
