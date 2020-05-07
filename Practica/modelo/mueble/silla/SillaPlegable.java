package modelo.mueble.silla;

/**
 * Subclase de Silla. Silla plegable
 * 
 * @author Arturo Barba
 */
public class SillaPlegable extends Silla
{
    /**
     * Constructor SillaPlegable que asigna un precio por defecto
     */
    public SillaPlegable()
    {
        super(35.95);
    }
    
    /**
     * Constructor SillaPlegable que recibe un precio
     * @param precio El precio
     */
    public SillaPlegable(double precio)
    {
        super(precio);
    }

    /**
     * Método toString
     * @return String Información
     */
    public String toString() {
        return super.toString()+ "Silla plegable.";
    }
}
