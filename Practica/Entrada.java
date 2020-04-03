import java.util.*;
/**
 * Write a description of class Entrada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Entrada
{
    // instance variables - replace the example below with your own
    private Scanner lector;

    /**
     * Constructor for objects of class Entrada
     */
    public Entrada()
    {
        this.lector = new Scanner(System.in);
    }

    public int getInt() {
        lector.reset();
        return lector.nextInt();
    }
    
    public String getString() {
        lector.reset();
        return lector.nextLine().trim();
    }
    
    public void limpiar() {
        lector.next();
    }
}
