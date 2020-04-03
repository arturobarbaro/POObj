/**
 * Abstract class Empleado - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class Empleado extends Persona
{
    
    private static int idActual = 1;
    private int empleadoId;

    public Empleado() {
       super();
       this.empleadoId = this.idActual;
       this.idActual++;
    }
    
    public Empleado(String nombre) {
       super(nombre);
       this.empleadoId = this.idActual;
       this.idActual++;
    }
    
    public int getEmpleadoId() {
        return this.empleadoId;
    }
    
    public String toString() {
        return super.toString() + " id: "+getEmpleadoId();
    }
}
