import java.io.Serializable;

public abstract class Usuario implements Serializable {
    private String nombre;
    private String apellido;
    private String claveAcceso;
    private int dni;

    public Usuario(String nombre, String apellido, String claveAcceso, int dni){
        this.nombre = nombre;
        this.apellido = apellido;
        this.claveAcceso = claveAcceso;
        this.dni = dni;
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getClaveAcceso(){
        return claveAcceso;
    }
    public int getDni(){
        return dni;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setClaveAcceso(String claveAcceso){
        this.claveAcceso = claveAcceso;
    }
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public void setDni(int dni) {
        this.dni = dni;
    }
}
