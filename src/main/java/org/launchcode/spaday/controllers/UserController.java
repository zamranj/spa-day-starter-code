package org.launchcode.spaday.controllers;

import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping
    public String displayAddUserForm(){

        return "/user/add";
    }

    @GetMapping("/detail/{id}")
    public String displayUserDetails(Model model, @PathVariable int id ){

        User user = UserData.getById(id);
        model.addAttribute("user", user);
        return "/user/detail";
    }



    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user,
                                     String verify){
        if(user.getPassword().equals(verify)){
            UserData.add(new User(user.getUsername(),user.getEmail()));
            model.addAttribute("users", UserData.getAll());
            return "user/index";
        }else{
            model.addAttribute("error","Passwords do not match!");
            model.addAttribute("username",user.getUsername());
            model.addAttribute("email", user.getEmail());
            return "/user/add";
        }
    }


}
