
/**
 * Abstract class Persona - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class Persona
{
    // instance variables - replace the example below with your own
    private String nombre;
    
    public Persona(){
        setNombre("");
    }

    public Persona(String nombre){
        setNombre(nombre);
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String toString() {
        return "Nombre: "+getNombre();
    }
}
