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

//    @GetMapping
//    public String displayUserDetails(Model model){
//        model.addAttribute("user", UserData.getAll());
//        return "user/detail";
//    }



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
