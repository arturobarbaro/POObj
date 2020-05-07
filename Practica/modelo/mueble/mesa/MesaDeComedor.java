package modelo.mueble.mesa;

import modelo.mueble.Mueble;

/**
 * Subclase de Mesa
 * 
 * @author Arturo Barba
 */
public class MesaDeComedor extends Mesa
{
    /**
     * Constructor MesaDeComedor que asigna un precio por defecto
     */
    public MesaDeComedor()
    {
        super(199.95);
    }

    /**
     * Constructor MesaDeComedor que recibe un precio
     * @param precio El precio
     */
    public MesaDeComedor(double precio)
    {
        super(precio);
    }

    /**
     * Método toString
     * @return String Información
     */
    public String toString() {
        return super.toString()+" Mesa de comedor.";
    }
}
