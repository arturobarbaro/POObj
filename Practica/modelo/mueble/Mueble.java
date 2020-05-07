package modelo.mueble;



/**
 * Abstract class Mueble - Clase que instancia un mueble del sistema
 * 
 * @author: Arturo Barba
 */
public abstract class Mueble
{
    /**
     * Precio del mueble
     */
    private double precio;
    /**
     * Variable estática encargada de almacenar un id único y autoincremetado
     */
    private static int idActual = 1;
    /**
     * ID del mueble
     */
    private int id;
    
    /**
     * Constructor de Mueble
     */
    public Mueble() {
        this.id = this.idActual;
        this.idActual++;
    }
    
    /**
     * Constructor de Mueble que recibe un precio
     * @param precio El precio
     */
    public Mueble(double precio) {
        this.id = this.idActual;
        this.idActual++;
        setPrecio(precio);
    }
    
    /**
     * Getter del precio
     * @return double El precio
     */
    public double getPrecio() {
        return this.precio;
    }
    
    /**
     * Setter del precio
     * @param precio El precio
     */
    public void setPrecio(double precio) {
        if (precio > 0)
            this.precio = precio;
    }
    
    /**
     * Getter del ID
     * @return int El ID
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * Método toString
     * @return String Información
     */
    public String toString() {
        return "ID: "+ getId() +". Precio: "+getPrecio()+" euros.";
    }
}
