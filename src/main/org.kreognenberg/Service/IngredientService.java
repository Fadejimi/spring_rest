package Service;

import Model.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> findAll();
    Ingredient findOne(Integer id);
    Ingredient saveOrUpdateIngredient(Ingredient user);
    void delete(Integer id);
    void incPriceOfEveryIngredient(String category);
}
