package modelo.mueble.silla;

/**
 * Subclase de Silla. Silla de cocina
 * 
 * @author Arturo Barba
 */
public class SillaCocina extends Silla
{
    /**
     * Constructor SillaCocina que asigna un precio por defecto
     */
    public SillaCocina()
    {
        super(39.95);
    }
    
    /**
     * Constructor SillaCocina que recibe un precio
     * @param precio El precio
     */
    public SillaCocina(double precio)
    {
        super(precio);
    }

    /**
     * Método toString
     * @return String Información
     */
    public String toString() {
        return super.toString()+ "Silla destinada para cocinas.";
    }
}
