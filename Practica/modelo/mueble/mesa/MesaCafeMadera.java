package modelo.mueble.mesa;

import modelo.mueble.Mueble;
/**
 * Subclase de MesaDeCafe. Mesa de café de madera
 * 
 * @author Arturo Barba
 */
public class MesaCafeMadera extends MesaDeCafe
{
    /**
     * Constructor MesaCafeMadera que asigna un precio por defecto
     */
    public MesaCafeMadera()
    {
        super(59.95);
    }
    
    /**
     * Constructor MesaCafeMadera que recibe un precio
     * @param precio El precio
     */
    public MesaCafeMadera(double precio)
    {
        super(precio);
    }

    /**
     * Método toString
     * @return String Información
     */
    public String toString() {
        return super.toString() + " Fabricada de madera.";
    }
}
