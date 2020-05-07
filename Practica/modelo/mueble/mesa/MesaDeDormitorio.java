package modelo.mueble.mesa;

import modelo.mueble.Mueble;
/**
 * Sublcase de Mesa
 * @author Arturo Barba
 */
public class MesaDeDormitorio extends Mesa
{
    /**
     * Constructor de MesaDeDormitorio que asigna un precio por defecto
     */
    public MesaDeDormitorio()
    {
        super(109.95);
    }
    
    /**
     * Constructor MesaDeDormitorio que recibe un precio
     * @param precio El precio
     */
    public MesaDeDormitorio(double precio)
    {
        super(precio);
    }

    /**
     * Método toString
     * @return String Información
     */
    public String toString() {
        return super.toString()+" Para interiores, especialmente dormitorios.";
    }
}
