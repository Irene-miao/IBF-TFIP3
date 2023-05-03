package sg.edu.nus.iss.day19.controller;


import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import sg.edu.nus.iss.day19.model.Love;
import sg.edu.nus.iss.day19.service.LoveService;


@Controller
public class LoveController {

    @Autowired
    private LoveService loveSvc;

    @GetMapping(path={"/", "/index.html"})
    public String getIndex(Model m , HttpSession sess){
        sess.invalidate();
        m.addAttribute("love", new Love());
        return "index";
    }
    

    @PostMapping(path="/lovecount")
    public String postLove(Model m, HttpSession sess, @Valid Love love, BindingResult binding) throws IOException{
        
        if(binding.hasErrors()){
            return "index";
        }
        Optional<Love> result = loveSvc.count(love);
        System.out.println(result);
        sess.setAttribute("result", result);
        m.addAttribute("result", result.get());
             return "love";
    }
        

    


    
}
