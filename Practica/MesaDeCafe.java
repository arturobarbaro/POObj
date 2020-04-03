
/**
 * Write a description of class MesaDeCafe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class MesaDeCafe extends Mesa
{
    /**
     * Constructor for objects of class Mesa
     */
    public MesaDeCafe()
    {
        super();
    }
    
    /**
     * Constructor for objects of class Mesa
     */
    public MesaDeCafe(double precio)
    {
        super(precio);
    }

    public String toString() {
        return super.toString() + " Destinada para tomar café.";
    }
}
