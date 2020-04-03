
/**
 * Write a description of class ArtesanoHora here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArtesanoHora extends Artesano
{
    // instance variables - replace the example below with your own
    public ArtesanoHora() {
       super();
    }
    
    public ArtesanoHora(String nombre) {
       super(nombre);
    }
    
    public String toString() {
        return super.toString() + ". Puesto: artesano con contrato por hora";
    }
}
