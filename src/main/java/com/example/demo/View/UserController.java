package com.example.demo.View;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegister(Model model)
    {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model){
        if (user.getPassword().length()<8){
            System.out.println("password error");
            return "register";
        }

        if (userService.findUserByUserName(user)!=null){
            System.out.println("user exist error");
            return "register";
        }
        try {
            userService.saveUser(user);
            return "redirect:/login";
        }
        catch(Exception e)
        {
            System.out.println("Abnormal error");
            return "register";

        }
    }
    @GetMapping("/login")
    public String showLogin()
    {
        return "login";
    }

}

