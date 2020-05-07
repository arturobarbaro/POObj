
package modelo.persona.empleado;

import modelo.persona.Persona;


/**
 * Abstract class Empleado - Clase que engloba a todos los empleados y hereda 
 * de Persona
 * 
 * @author: Arturo Barba
 */
public abstract class Empleado extends Persona
{
    /**
     * Variable estática encargada de almacenar un id único y autoincremetado
     */
    private static int idActual = 1;
    /**
     * El id del empleado
     */
    private int empleadoId;

    /**
     * Constructor de Empleado
     */
    public Empleado() {
       super();
       this.empleadoId = this.idActual;
       this.idActual++;
    }
    
    /**
     * Constructor de Empleado que recibe un nombre
     * @param nombre El nombre
     */
    public Empleado(String nombre) {
       super(nombre);
       this.empleadoId = this.idActual;
       this.idActual++;
    }
    
    /**
     * Getter del ID del empleado
     * @return int El ID
     */
    public int getEmpleadoId() {
        return this.empleadoId;
    }
    
    /**
     * Método toString
     * @return String Información del empleado
     */
    public String toString() {
        return super.toString() + " id: "+getEmpleadoId();
    }
}
