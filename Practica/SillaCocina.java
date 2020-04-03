
/**
 * Write a description of class SillaCocina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SillaCocina extends Silla
{
    /**
     * Constructor for objects of class Silla
     */
    public SillaCocina()
    {
        super();
    }
    
    /**
     * Constructor for objects of class Silla
     */
    public SillaCocina(double precio)
    {
        super(precio);
    }

    public String toString() {
        return super.toString()+ "Silla destinada para cocinas.";
    }
}
