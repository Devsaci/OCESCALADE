package org.ocescalade.controlleur;

import javax.validation.Valid;

import org.ocescalade.dao.UserRepository;
import org.ocescalade.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;





@Controller
public class AcceuilControlleur {

	@Autowired
	private UserRepository userRepository;
	
	/*   */ 
	@RequestMapping(value="/Accueil")
	 public String Accueil(){
	        return "Accueil";
	    }
	
    @RequestMapping(value="/")
    public String Home(){
        return "redirect:Accueil";
    }
	
	/*    */ 
	
    @RequestMapping(value="/login")
    public String login(){
         return "login";
     }
    @RequestMapping(value="/Enregistrement")
    public String Enregistrement(Model model){
        model.addAttribute("user", new User());
        return "Enregistrement";
    }
    @RequestMapping(value="/saveUser", method = RequestMethod.POST)
    public String saveUser(@Valid User user,
                           BindingResult bindingResult,
                           Model model){
        user.setRole("USER");
        user.setEnabled(true);
        if(bindingResult.hasErrors())
            return "Enregistrement";
        userRepository.save(user);
        model.addAttribute("user", user);
        return "ConfirmEnregistrement";
    }
    
    
    
}
