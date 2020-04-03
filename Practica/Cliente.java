/**
 * Abstract class Cliente - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class Cliente extends Persona
{
    private static int idActual = 1;
    private int clienteId;

    public Cliente() {
       super();
       this.clienteId = this.idActual;
       this.idActual++;
    }
    
    public Cliente(String nombre) {
       super(nombre);
       this.clienteId = this.idActual;
       this.idActual++;
    }
    
    public int getClienteId() {
        return this.clienteId;
    }
    
    public String toString() {
        return super.toString() + " id: "+getClienteId();
    }
}
