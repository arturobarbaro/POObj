
/**
 * Write a description of class Mesa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Mesa extends Mueble
{
    
    /**
     * Constructor for objects of class Mesa
     */
    public Mesa()
    {
        super();
    }
    
    /**
     * Constructor for objects of class Mesa
     */
    public Mesa(double precio)
    {
        super(precio);
    }

    public String toString() {
        return "Mueble tipo mesa. "+super.toString();
    }
}
