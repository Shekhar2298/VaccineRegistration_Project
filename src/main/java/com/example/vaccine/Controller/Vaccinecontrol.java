package com.example.vaccine.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.vaccine.Model.User;
import com.example.vaccine.Service.Vaccineservice;

@Controller
public class Vaccinecontrol {

    @Autowired
    Vaccineservice serv;

    @GetMapping("/")
    public String Home(Model model) {
        List<User> us = serv.Adding();
        model.addAttribute("data", us);
        return "Database";
    }

    @PostMapping("/vaccine")
    public String Vaccine(@ModelAttribute User use, Model model) {
        serv.AddAll(use);
        return "redirect:/";
    }

    @GetMapping("/deletedata/{id}")
    public String deleteid(@PathVariable Integer id, Model model) {
        serv.delete(id);
        model.addAttribute("data", serv.Adding());

        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute User user, Model model) {
        List<User> us = serv.Adding();
        model.addAttribute("data", us);
        model.addAttribute("updatedata", user.getName());
        serv.AddAll(user);
        return "Database";

    }

    @GetMapping("/update/{id}")
    public String Updateid(@PathVariable Integer id, Model model) {
        User u = serv.updateid(id);
        model.addAttribute("updatedata", u);
        return "update";
    }

    @GetMapping("/control")
    public String Register() {
        return "index";
    }
}
