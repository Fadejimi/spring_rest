package Validator;

import Model.Ingredient;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class IngredientValidator implements Validator {
    public boolean supports(Class<?> clazz) {
        return Ingredient.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {

        Ingredient ingredient = (Ingredient) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.ingredientForm.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category", "NotEmpty.ingredientForm.category");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount", "NotEmpty.ingredientForm.amount");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pricePerKilo", "NotEmpty.ingredientForm.pricePerKilo");

        if(ingredient.getId()==null || ingredient.getId()<=0){
            errors.rejectValue("id", "NotEmpty.ingredientForm.id");
        }

        if(ingredient.getName().equals("none")) {
            errors.rejectValue("name", "NotEmpty.ingredientForm.name");
        }

        if(ingredient.getCategory().equals("none")) {
            errors.rejectValue("category", "NotEmpty.ingredientForm.category");
        }


    }


}
