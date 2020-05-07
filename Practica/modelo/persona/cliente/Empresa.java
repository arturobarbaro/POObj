package modelo.persona.cliente;

import modelo.persona.Persona;
/**
 * Subclase Cliente - Cliente a nombre de una empresa
 * 
 * @author Arturo Barba
 */
public class Empresa extends Cliente
{
    /**
     * Constructor de Empresa
     */
    public Empresa() {
       super();
    }
    
    /**
     * Constructor de Empresa que recibe el nombre
     * @param nombre El nombre de la empresa
     */
    public Empresa(String nombre) {
       super(nombre);
    }
    
    /**
     * Método toString
     * @return String Información
     */
    public String toString() {
        return super.toString() + ". Tipo cliente: empresa";
    }
}
