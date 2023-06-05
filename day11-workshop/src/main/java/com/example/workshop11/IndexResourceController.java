package com.example.workshop11;

import java.sql.Date;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping(path = {"/", "/index.html"})
public class IndexResourceController {
    @GetMapping(produces={"text/html"})
    public String index(Model model) {
        Calendar cal = Calendar.getInstance();
        model.addAttribute("currTime", cal.get(Calendar.HOUR_OF_DAY));
        return "index";
    }

    @GetMapping(path="/weather/{city}")
    public String showCity(PathVariable String city, 
    @RequestParam (required = true) String name, Model m) {
        m.addAttribute attributeName("city", city);
        m.addAttribute attributeName("name", name + "");
        return "city";
    }
}
