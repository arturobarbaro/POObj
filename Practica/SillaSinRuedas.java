
/**
 * Write a description of class SillaSinRuedas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SillaSinRuedas extends SillaOficina
{
    /**
     * Constructor for objects of class Silla
     */
    public SillaSinRuedas()
    {
        super();
    }
    
    /**
     * Constructor for objects of class Silla
     */
    public SillaSinRuedas(double precio)
    {
        super(precio);
    }

    public String toString() {
        return super.toString()+ "No incorpora ruedas.";
    }
}
