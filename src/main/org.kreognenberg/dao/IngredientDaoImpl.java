package dao;

import Model.Ingredient;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

public class IngredientDaoImpl extends HibernateDaoSupport implements IngredientDao {

    @Override
    public Ingredient findById(Integer id) {
        return (Ingredient) getHibernateTemplate().find("from Ingredient where id = ?", id).get(0);
    }

    private Ingredient lastAdded() {
        return (Ingredient) getHibernateTemplate().find("from Ingredient order by id desc").get(0);
    }
    @Override
    public Ingredient save(Ingredient ingredient) {
        getHibernateTemplate().save(ingredient);
        return lastAdded();
    }

    @Override
    public Ingredient update(Ingredient ingredient) {
        getHibernateTemplate().update(ingredient);
        return findById(ingredient.getId());
    }

    @Override
    public void delete(Integer id) {
        getHibernateTemplate().delete(findById(id));
    }

    @Override
    public List<Ingredient> findAll() {
        return (List<Ingredient>) getHibernateTemplate().find("from Ingredient");
    }

    @Override
    public void incPriceOfIngredient(String category) {
        List<Ingredient> ingredients = (List<Ingredient>) getHibernateTemplate().find("from Ingredient where category = ?", category);
        for(Ingredient ingredient: ingredients) {
            ingredient.setPricePerKilo(ingredient.getPricePerKilo() + 20);
            getHibernateTemplate().update(ingredient);
        }
    }
}
