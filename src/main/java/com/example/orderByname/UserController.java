package com.example.orderByname;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    @GetMapping("/datanamepage")
    public String datanamepageshow(Model model,@RequestParam(defaultValue = "asc") String direction){

        model.addAttribute("datapagelist",userser.datapagename(direction));
        model.addAttribute("direction",direction);
        return "datanamepage";
    }
    @GetMapping("/delete/{id}")
    public String deletedata(@PathVariable Long id){
        userser.deleterecoeds(id);
        return "redirect:/datanamepage";
    }
    @GetMapping("/edit/{id}")
    public String editbyid(@PathVariable Long id,Model model){
        model.addAttribute("formdata",  userser.editbyid(id));
        return "formpage";
    }
    @PostMapping("/edit")
    public String updateUser(@ModelAttribute UserEntity userentity,
                             RedirectAttributes redirectAttributes){
        userser.saveuserdata(userentity);   // same save() method
        redirectAttributes.addFlashAttribute("success","Successfully Updated");
        return "redirect:/datanamepage";
    }
    @GetMapping("/deleteall")
    public String deleteallrecoeds(){
        userser.deleteallrecords();
        return "redirect:/datanamepage";
    }
}
