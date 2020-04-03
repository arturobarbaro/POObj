
/**
 * Write a description of class Comercial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Comercial extends Empleado
{
    public Comercial() {
       super();
    }
    
    public Comercial(String nombre) {
       super(nombre);
    }
    
    public String toString() {
        return super.toString() + ". Puesto: comercial";
    }
}
