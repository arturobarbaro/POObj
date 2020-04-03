
/**
 * Write a description of class SillaOficina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class SillaOficina extends Silla
{
    /**
     * Constructor for objects of class Silla
     */
    public SillaOficina()
    {
        super();
    }
    
    /**
     * Constructor for objects of class Silla
     */
    public SillaOficina(double precio)
    {
        super(precio);
    }

    public String toString() {
        return super.toString()+ "Silla destinada para oficinas.";
    }
}
