
/**
 * Write a description of class MesaDeDormitorio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MesaDeDormitorio extends Mesa
{
    /**
     * Constructor for objects of class Mesa
     */
    public MesaDeDormitorio()
    {
        super();
    }
    
    /**
     * Constructor for objects of class Mesa
     */
    public MesaDeDormitorio(double precio)
    {
        super(precio);
    }

    public String toString() {
        return super.toString()+" Para interiores, especialmente dormitorios.";
    }
}
