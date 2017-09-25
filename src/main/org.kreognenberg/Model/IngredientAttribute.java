package Model;

public class IngredientAttribute {
    private Integer id;
    private String name;
    private String taste;

    public IngredientAttribute() {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getTaste() {
        return this.taste;
    }
}
