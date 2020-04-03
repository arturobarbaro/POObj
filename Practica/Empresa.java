
/**
 * Write a description of class Empresa here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Empresa extends Cliente
{
    public Empresa() {
       super();
    }
    
    public Empresa(String nombre) {
       super(nombre);
    }
    
    public String toString() {
        return super.toString() + ". Tipo cliente: empresa";
    }
}
