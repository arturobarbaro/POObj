
/**
 * Write a description of class Particular here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Particular extends Cliente
{
    // instance variables - replace the example below with your own
    public Particular() {
       super();
    }
    
    public Particular(String nombre) {
       super(nombre);
    }
    
    public String toString() {
        return super.toString() + ". Tipocliente: particular.";
    }
}
