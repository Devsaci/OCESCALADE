package org.ocescalade.controlleur;

import java.util.List;

import javax.validation.Valid;

import org.ocescalade.dao.PretRepository;
import org.ocescalade.dao.TopoRepository;
import org.ocescalade.dao.UserRepository;
import org.ocescalade.entities.User;
import org.ocescalade.entities.Pret;
import org.ocescalade.entities.Topo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfilController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TopoRepository topoRepository;
	@Autowired
	private PretRepository pretRepository;

	@RequestMapping(value = "/Profil")
	public String Profil(Model model) {
		/*      */
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findUserByUsername(username);
		model.addAttribute("user", user);
		/*      */
		List<Topo> listTopos = topoRepository.findTopoByUser_Username(username);
		model.addAttribute("listopo", listTopos);
		model.addAttribute("topo", new Topo());
		/*      */
		List<Pret> lpe = pretRepository.findAllByEmprunteur(username);
		model.addAttribute("listPretEmprunteur", lpe);
		List<Pret> lpp = pretRepository.findAllByProprietaire(username);
		model.addAttribute("listPretProprio", lpp);

		List<Pret> listnopret = pretRepository.findPretsByProprietaireAndStatutIsNotAndStatutIsNot(username, "refuse",
				"termine");
		model.addAttribute("listNoPret", listnopret);

		List<Pret> listnoemprunt = pretRepository.findPretsByEmprunteurAndStatutIsNotAndStatutIsNot(username, "refuse",
				"termine");
		model.addAttribute("listNoEmprunt", listnoemprunt);

		return "Profil";
	}

	public String saveTopo(
			@Valid Topo topo, 
			BindingResult bindingResult, 
			Model model) {
		String username =  SecurityContextHolder.getContext().getAuthentication().getName();
		List<Topo> lisTopos = topoRepository.findToposByUser_Username(username);
		model.addAttribute("listopo" , lisTopos );
		
		
		
		return "ConfirmTopo";
	}

}
