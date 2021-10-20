package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping
    public String displayAddUserForm(){

        return "/user/add";
    }

    @GetMapping("admin")
    public String displayUsersForm(Model model){
        model.addAttribute("users", UserData.getAll());
        return "/user/admin";
    }


    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user,
                                     String verify){
        if(user.getPassword().equals(verify)){
            return "user/index";
        }else{
            model.addAttribute("error","Passwords do not match!");
            model.addAttribute("username",user.getUsername());
            model.addAttribute("email", user.getEmail());
            UserData.add(new User(user.getUsername(),user.getEmail()));
            return "/user/add";
        }
    }


}
