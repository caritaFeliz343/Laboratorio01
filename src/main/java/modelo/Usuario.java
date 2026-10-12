package modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario
{
    private List<Resultado> historialResultados;
    private String username;
    private String password;
    private String nombre;

    public Usuario(String username, String password,String nombre){
        historialResultados = new ArrayList<>();
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

    public String getUsername()
    {
        return username;
    }
    public void setNombre(String nombre)
    {
        if (nombre == null || nombre.isEmpty())
        {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        this.nombre=nombre;
    }

    public List<Resultado> getHistorialResultados()
    {
        return historialResultados;
    }

}
