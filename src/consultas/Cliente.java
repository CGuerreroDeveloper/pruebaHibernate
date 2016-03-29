
package consultas;

import java.io.Serializable;

/**
 *
 * @author Cristian Guerrero
 */
public class Cliente implements Serializable{
    //private long id;
    private String cedula ,nombre, email,telefono;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Cliente(){}
    
    public Cliente(String cedula,String nombre,String telefono,
            String email){
        this.cedula= cedula;
        this.nombre= nombre;
        this.telefono= telefono;
        this.email= email;        
    }
    
}
