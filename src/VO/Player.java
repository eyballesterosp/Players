package VO;

public class Player {

    private String nombre;
    private String email;

    public Player(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
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

    @Override
    public String toString() {
        int c = 0;
        return "Players: " + "\nnombre: " + nombre + "\nemail: " + email;
    }

}
