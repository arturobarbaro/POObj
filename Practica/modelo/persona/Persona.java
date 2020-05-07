package modelo.persona;

/**
 * Abstract class Persona - Clase que engloba a todos los empleados y clientes
 * 
 * @author: Arturo Barba
 */
public abstract class Persona
{
    /**
     * Variable nombre de la clase Persona.
     */
    private String nombre;

    /**
     * Constructor que asigna un nombre por defecto
     */
    public Persona(){
        setNombre("");
    }

    /**
     * Contructor de Persona, que recibe el nombre
     * @param nombre El nombre 
     */
    public Persona(String nombre){
        setNombre(nombre);
    }

    /**
     * Getter para devolver el nombre
     * @return nombre
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Setter para asignar o cambiar el nombre
     * @param nombre El nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método toString encargado de devolver información de la clase Persona
     * @return String información
     */
    public String toString() {
        return "Nombre: "+getNombre();
    }
}
