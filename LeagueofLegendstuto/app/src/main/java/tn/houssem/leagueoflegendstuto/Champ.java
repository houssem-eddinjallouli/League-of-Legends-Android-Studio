package tn.houssem.leagueoflegendstuto;

public class Champ {
    private int id;
    private String name;
    private String[] roles;
    private int image;

    public Champ(int id, String name, String[] roles, int image) {
        this.id = id;
        this.name = name;
        this.roles = roles;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
