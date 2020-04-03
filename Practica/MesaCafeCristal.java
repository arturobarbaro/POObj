
/**
 * Write a description of class MesaCafeCristal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MesaCafeCristal extends MesaDeCafe
{
    /**
     * Constructor for objects of class Mesa
     */
    public MesaCafeCristal()
    {
        super();
    }
    
    /**
     * Constructor for objects of class Mesa
     */
    public MesaCafeCristal(double precio)
    {
        super(precio);
    }

    public String toString() {
        return super.toString() + " Fabricada con cristal.";
    }
}
