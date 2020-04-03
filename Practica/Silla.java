
/**
 * Write a description of class Silla here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Silla extends Mueble
{
    /**
     * Constructor for objects of class Silla
     */
    public Silla()
    {
        super();
    }
    
    /**
     * Constructor for objects of class Mesa
     */
    public Silla(double precio)
    {
        super(precio);
    }

    public String toString() {
        return "Mueble tipo silla. "+super.toString();
    }
}
