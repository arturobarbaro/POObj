
/**
 * Write a description of class MesaDeComedor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MesaDeComedor extends Mesa
{
    /**
     * Constructor for objects of class Mesa
     */
    public MesaDeComedor()
    {
        super();
    }
    
    /**
     * Constructor for objects of class Mesa
     */
    public MesaDeComedor(double precio)
    {
        super(precio);
    }

    public String toString() {
        return super.toString()+" Mesa de comedor.";
    }
}
