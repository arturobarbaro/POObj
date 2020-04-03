
/**
 * Write a description of class ArtesanoPlantilla here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArtesanoPlantilla extends Artesano
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class ArtesanoPlantilla
     */
    public ArtesanoPlantilla() {
       super();
    }
    
    public ArtesanoPlantilla(String nombre) {
       super(nombre);
    }
    
    public String toString() {
        return super.toString() + ". Puesto: artesano en plantilla";
    }
}
