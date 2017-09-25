package Model;

import java.util.List;

public class Ingredient {
    private Integer id;

    private String name;
    private String category;
    private int amount;
    private List<IngredientAttribute> attributes;
    private int pricePerKilo;

    public Ingredient() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<IngredientAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<IngredientAttribute> attributes) {
        this.attributes = attributes;
    }

    public int getPricePerKilo() {
        return pricePerKilo;
    }

    public void setPricePerKilo(int pricePerKilo) {
        this.pricePerKilo = pricePerKilo;
    }

    public boolean isNew() {
        if (id == null) {
            return true;
        }
        return false;
    }
}
