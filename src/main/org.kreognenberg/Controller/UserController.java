package Controller;

import Service.UserService;
import Validator.UserFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import Model.User;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    UserFormValidator userFormValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(userFormValidator);
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("users", userService.findAll());
        return "/users/index";
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") int id,  Model model) {
        User user = userService.findOne(id);

        if (user == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "User not found");
        }
        model.addAttribute("user", user);
        return "/users/userInfo";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.GET)
    public String userForm(Model model) {
        User user = new User();

        user.setUsername("Fadejimi");
        user.setEmail("fade@gmail.com");
        user.setBeerKind("Gulder");
        user.setGender("M");
        user.setInterests("Football, Dancing");
        user.setPassword("password");
        model.addAttribute("userForm", user);

        populateModel(model);
        return "users/userForm";
    }

    @RequestMapping(value = {"/users"}, method = RequestMethod.POST)
    public String addUser(@ModelAttribute("userForm") @Validated User user,
                          BindingResult result, Model model,
                          final RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            populateModel(model);
            return "users/userForm";
        }
        else {
            redirectAttributes.addFlashAttribute("css", "success");
            if (user.isNew()) {
                redirectAttributes.addFlashAttribute("msg","User added successfully");
            }
            else {
                redirectAttributes.addFlashAttribute("msg", "User has been successfully updated");
            }

            User user1= userService.saveOrUpdateUser(user);

            return "redirect:/users/"+user1.getId();
        }
    }

    @RequestMapping(value = "/users/{id}/delete", method = RequestMethod.POST)
    private String deleteUser(@PathVariable("id") int id,
                              final RedirectAttributes redirectAttributes) {
        userService.delete(id);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "User is deleted");

        return "redirect:/users";
    }

    @RequestMapping(value = "/users/{id}/update", method = RequestMethod.GET)
    private String showUpdateUserForm(@PathVariable("id") int id, Model model) {
        User user = userService.findOne(id);
        model.addAttribute("userForm", user);

        populateModel(model);

        return "users/userForm";
    }

    private void populateModel(Model model) {
        List<String> interests = new ArrayList<>();
        interests.add("Dancing");
        interests.add("Football");
        interests.add("Shooting");

        model.addAttribute("interests", interests);

        Map<String, String> beers = new LinkedHashMap<String, String>();
        beers.put("Gulder", "Gulder");
        beers.put("33", "33");
        beers.put("Star", "Star");

        model.addAttribute("beers", beers);
    }
}
