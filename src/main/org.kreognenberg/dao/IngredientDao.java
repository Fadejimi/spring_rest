package dao;

import Model.Ingredient;

import java.util.List;

public interface IngredientDao {
    Ingredient findById(Integer id);

    Ingredient save(Ingredient ingredient);

    Ingredient update(Ingredient ingredient);

    void delete(Integer id);

    List<Ingredient> findAll();

    void incPriceOfIngredient(String category);

}
