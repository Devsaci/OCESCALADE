package org.ocescalade.controlleur;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.ocescalade.dao.UserRepository;
import org.ocescalade.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AcceuilControlleur {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(value = "/Accueil")
	public String Accueil() {
		return "Accueil";
	}

	@RequestMapping(value = "/")
	public String Home() {
		return "redirect:Accueil";
	}

	/*    */

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/Enregistrement")
	public String Enregistrement(Model model) {
		model.addAttribute("user", new User());
		return "Enregistrement";
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@Valid User user, BindingResult bindingResult, Model model) {
		user.setRole("USER");
		user.setEnabled(true);
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		if (bindingResult.hasErrors())
			return "Enregistrement";
		userRepository.save(user);
		model.addAttribute("user", user);
		return "ConfirmEnregistrement";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

}
