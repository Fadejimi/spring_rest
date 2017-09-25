package Validator;

import Model.IngredientAttribute;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class IngredientAttributeValidator implements Validator {
    public boolean supports(Class<?> clazz) {
        return IngredientAttribute.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {

        IngredientAttribute ingredientAttribute = (IngredientAttribute) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.ingredientAttributeForm.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "taste", "NotEmpty.ingredientAttributeForm.taste");

        if(ingredientAttribute.getId()==null || ingredientAttribute.getId()<=0){
            errors.rejectValue("id", "NotEmpty.ingredientAttributeForm.id");
        }

        if(ingredientAttribute.getName().equals("none")) {
            errors.rejectValue("name", "NotEmpty.ingredientAttributeForm.name");
        }

        if(ingredientAttribute.getTaste().equals("none")) {
            errors.rejectValue("taste", "NotEmpty.ingredientAttributeForm.taste");
        }

    }
}
