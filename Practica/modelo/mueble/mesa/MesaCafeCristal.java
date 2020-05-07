package modelo.mueble.mesa;

import modelo.mueble.Mueble;
/**
 * Subclase de MesaDeCafe. Mesa de café de cristal
 * 
 * @author Arturo Barba
 */
public class MesaCafeCristal extends MesaDeCafe
{
    /**
     * Constructor MesaCafeCristal que asigna un precio por defecto
     */
    public MesaCafeCristal()
    {
        super(69.95);
    }
    
    /**
     * Constructor MesaCafeCristal que recibe un precio
     * @param precio El precio
     */
    public MesaCafeCristal(double precio)
    {
        super(precio);
    }

    /**
     * Método toString
     * @return String Información
     */
    public String toString() {
        return super.toString() + " Fabricada con cristal.";
    }
}
