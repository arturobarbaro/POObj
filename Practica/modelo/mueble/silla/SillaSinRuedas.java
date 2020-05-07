package modelo.mueble.silla;

/**
 * Subclase de SillaOficina. Silla sin ruedas
 * 
 * @author Arturo Barba
 */
public class SillaSinRuedas extends SillaOficina
{
    /**
     * Constructor SillaSinRuedas que asigna un precio por defecto
     */
    public SillaSinRuedas()
    {
        super(95.95);
    }
    
    /**
     * Constructor SillaSinRuedas que recibe un precio
     * @param precio El precio
     */
    public SillaSinRuedas(double precio)
    {
        super(precio);
    }

    /**
     * Método toString
     * @return String Información
     */
    public String toString() {
        return super.toString()+ "No incorpora ruedas.";
    }
}
