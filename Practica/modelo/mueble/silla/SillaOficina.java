package modelo.mueble.silla;

/**
 * Subclase de Silla. Clase Abstracta Silla Oficina
 * 
 * @author Arturo Barba
 */
public abstract class SillaOficina extends Silla
{
    /**
     * Constructor SillaOficina
     */
    public SillaOficina()
    {
        super();
    }
    
    /**
     * Constructor SillaOficina que recibe un precio
     * @param precio El precio
     */
    public SillaOficina(double precio)
    {
        super(precio);
    }

    /**
     * Método toString
     * @return String Información
     */
    public String toString() {
        return super.toString()+ "Silla destinada para oficinas.";
    }
}
