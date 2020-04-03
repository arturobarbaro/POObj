
/**
 * Write a description of class MesaCafeMadera here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MesaCafeMadera extends MesaDeCafe
{
    /**
     * Constructor for objects of class Mesa
     */
    public MesaCafeMadera()
    {
        super();
    }
    
    /**
     * Constructor for objects of class Mesa
     */
    public MesaCafeMadera(double precio)
    {
        super(precio);
    }

    public String toString() {
        return super.toString() + " Fabricada de madera.";
    }
}
