
/**
 * Write a description of class SillaPlegable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SillaPlegable extends Silla
{
    /**
     * Constructor for objects of class Silla
     */
    public SillaPlegable()
    {
        super();
    }
    
    /**
     * Constructor for objects of class Silla
     */
    public SillaPlegable(double precio)
    {
        super(precio);
    }

    public String toString() {
        return super.toString()+ "Silla plegable.";
    }
}
