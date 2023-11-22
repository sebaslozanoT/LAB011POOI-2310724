package practica2xd;

public class Autor {
    private String name;
    private String email;
    private char genero;

    public Autor(String name, String email, char genero) {
        this.name = name;
        this.email = email;
        this.genero = genero;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }
}
    

