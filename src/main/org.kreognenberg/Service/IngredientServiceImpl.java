package Service;

import Model.Ingredient;
import dao.IngredientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("ingredientService")
@Transactional
public class IngredientServiceImpl implements IngredientService {
    @Autowired
    IngredientDao ingredientDao;

    @Override
    public List<Ingredient> findAll() {

        return ingredientDao.findAll();
    }

    @Override
    public Ingredient findOne(Integer id) {

        return ingredientDao.findById(id);
    }

    @Override
    public Ingredient saveOrUpdateIngredient(Ingredient ingredient) {
        if (ingredient.getId() == null) {
            ingredient = ingredientDao.save(ingredient);
        }
        else {
            ingredient = ingredientDao.update(ingredient);
        }
        return ingredient;
    }

    @Override
    public void delete(Integer id) {
        ingredientDao.delete(id);
    }

    @Override
    public void incPriceOfEveryIngredient(String category) {
        ingredientDao.incPriceOfIngredient(category);
    }
}
