package Controller;

import Service.IngredientService;
import Validator.IngredientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import Model.Ingredient;

@Controller
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private IngredientValidator ingredientFormValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(ingredientFormValidator);
    }


    @RequestMapping(value = "/ingredients", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("ingredients", ingredientService.findAll());
        return "/ingredients/index";
    }

    @RequestMapping(value = "/ingredients/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") int id, Model model) {
        Ingredient ingredient = ingredientService.findOne(id);

        if (ingredient == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "Ingredient not found");
        }
        model.addAttribute("ingredient", ingredient);
        return "/ingredients/ingredientInfo";
    }

    @RequestMapping(value = "/ingredient/add", method = RequestMethod.GET)
    public String userForm(Model model) {
        Ingredient ingredient = new Ingredient();

        ingredient.setName("Wheat");
        ingredient.setAmount(400);
        ingredient.setCategory("Carbohydrates");
        ingredient.setPricePerKilo(100);
        model.addAttribute("ingredientForm", ingredient);

        populateModel(model);
        return "ingredient/ingredientForm";
    }

    @RequestMapping(value = {"/ingredients"}, method = RequestMethod.POST)
    public String addUser(@ModelAttribute("ingredientForm") @Validated Ingredient ingredient,
                          BindingResult result, Model model,
                          final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            populateModel(model);
            return "ingredient/ingredientForm";
        }
        else {
            redirectAttributes.addFlashAttribute("css", "success");
            if (ingredient.isNew()) {
                redirectAttributes.addFlashAttribute("msg","Ingredient added successfully");
            }
            else {
                redirectAttributes.addFlashAttribute("msg", "Ingredient has been successfully updated");
            }

            ingredientService.saveOrUpdateIngredient(ingredient);

            return "redirect:/ingredient/"+ingredient.getId();
        }
    }

    @RequestMapping(value = "/ingredient/{id}/delete", method = RequestMethod.POST)
    private String deleteUser(@PathVariable("id") int id,
                              final RedirectAttributes redirectAttributes) {
        ingredientService.delete(id);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Ingredient is deleted");

        return "redirect:/ingredient";
    }

    @RequestMapping(value = "/ingredient/{id}/update", method = RequestMethod.GET)
    private String showUpdateUserForm(@PathVariable("id") int id, Model model) {
        Ingredient ingredient = ingredientService.findOne(id);
        model.addAttribute("ingredientForm", ingredient);

        populateModel(model);

        return "ingredient/ingredientForm";
    }

    private void populateModel(Model model) {

        Map<String, String> categories = new LinkedHashMap<String, String>();
        categories.put("Carbohydrates", "Carbohydrates");
        categories.put("Protein", "Protein");
        categories.put("Vitamin", "Vitamin");

        model.addAttribute("categories", categories);
    }
}
