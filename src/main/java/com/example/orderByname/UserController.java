package com.example.orderByname;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    private final UserServices userser;

    public UserController(UserServices userser) {
        this.userser = userser;
    }

    @GetMapping("/")
    public String formpageshow(Model model){
        model.addAttribute("formdata",new UserEntity());
        return "formpage";
    }
    @PostMapping("/form")
    public String formpagetodatabase(@ModelAttribute UserEntity userentity, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("success","Succefully Registerd");
        userser.saveuserdata(userentity);
        return "redirect:/";
    }
}
