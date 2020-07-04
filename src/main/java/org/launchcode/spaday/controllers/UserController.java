package org.launchcode.spaday.controllers;

import org.launchcode.spaday.Data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping
    public String displayIndex() {
        return "user/index";
    }

    @RequestMapping("/add")
    public String displayAddUserForm(){
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        model.addAttribute("user", user);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("verify", verify);

        if (user.getPassword().equals(verify)) {
            UserData.addUser(user);
            model.addAttribute("user", user);
            ArrayList<User> users = UserData.getAll();
            model.addAttribute("users", users);
            return "user/index";

        } else {
            model.addAttribute("error", "Passwords do not match");
            return "user/add";
        }

    }

    @RequestMapping("/detail")
    public String displayAllUsers(Model model, @ModelAttribute User user){
        ArrayList<User> users = UserData.getAll();
        model.addAttribute("user", user);
        model.addAttribute("users", users);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        return "user/detail";
    }
}
