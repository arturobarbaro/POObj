
/**
 * Write a description of class SillaConRuedas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SillaConRuedas extends SillaOficina
{
    /**
     * Constructor for objects of class Silla
     */
    public SillaConRuedas()
    {
        super();
    }
    
    /**
     * Constructor for objects of class Silla
     */
    public SillaConRuedas(double precio)
    {
        super(precio);
    }

    public String toString() {
        return super.toString()+ "Incorpora ruedas.";
    }
}
