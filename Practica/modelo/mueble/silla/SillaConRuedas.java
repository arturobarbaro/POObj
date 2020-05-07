package modelo.mueble.silla;

/**
 * Subclase de SillaOficina. Silla con ruedas.
 * 
 * @author Arturo Barba
 */
public class SillaConRuedas extends SillaOficina
{
    /**
     * Constructor SillaConRuedas que asigna un precio por defecto
     */
    public SillaConRuedas()
    {
        super(99.95);
    }
    
    /**
     * Constructor SillaConRuedas que recibe un precio
     * @param precio El precio
     */
    public SillaConRuedas(double precio)
    {
        super(precio);
    }

    /**
     * Método toString
     * @return String Información
     */
    public String toString() {
        return super.toString()+ "Incorpora ruedas.";
    }
}
