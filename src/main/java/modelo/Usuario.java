package modelo;

public class Usuario
{
    private String username;
    private String password;
    private String nombre;
    public Usuario(String username, String password,String nombre){
        this.username=username;
        this.password=password;
        this.nombre=nombre;
    }

    public Usuario()
    {
        this("Invitado","invitado","Invitado");
    }
//Verifica si las credenciales ingresadas pertenecen al usuario
    public boolean validarCredenciales(String u,String p){
        return this.username.equals(u)&&this.password.equals(p);
    }
    public String getNombre(){
        return nombre;
    }
}
