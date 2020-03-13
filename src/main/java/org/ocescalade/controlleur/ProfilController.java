package org.ocescalade.controlleur;

import java.util.List;

import javax.validation.Valid;

import org.ocescalade.dao.PretRepository;
import org.ocescalade.dao.TopoRepository;
import org.ocescalade.dao.UserRepository;
import org.ocescalade.entities.User;
import org.ocescalade.service.IuserService;
import org.ocescalade.entities.Pret;
import org.ocescalade.entities.Topo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfilController {

	@Autowired
	private  IuserService IuserService;  //UserRepository userRepository;
	@Autowired
	private TopoRepository topoRepository;
	@Autowired
	private PretRepository pretRepository;

	@RequestMapping(value = "/Profil")
	public String Profil(Model model) {
		
		/*      */
		//String username = SecurityContextHolder.getContext().getAuthentication().getName();
		//User user = userRepository.findUserByUsername(username);	
		
		User userConnected = this.IuserService.connectedUser();
		System.out.println("/////////////////////"+ userConnected);
		model.addAttribute("user", userConnected);
		/*      */
		List<Topo> listTopos = topoRepository.findTopoByUser_Id(userConnected.getId());
		System.out.println("listopo  = "+ listTopos );
		model.addAttribute("listopo", listTopos);
		model.addAttribute("topo", new Topo());
		/*      */
		List<Pret> lpe = pretRepository.findAllByEmprunteur(this.IuserService.connectedUsername());
		System.out.println("listPretEmprunteur"+ lpe);
		model.addAttribute("listPretEmprunteur", lpe);
		List<Pret> lpp = pretRepository.findAllByProprietaire(this.IuserService.connectedUsername());
		System.out.println("listPretProprio"+ lpp);
		model.addAttribute("listPretProprio", lpp);

		List<Pret> listnopret = pretRepository.findPretsByProprietaireAndStatutIsNotAndStatutIsNot
				(this.IuserService.connectedUsername(), "refuse","termine");
		System.out.println("listNoPret"+ listnopret);
		model.addAttribute("listNoPret", listnopret);

		List<Pret> listnoemprunt = pretRepository.findPretsByEmprunteurAndStatutIsNotAndStatutIsNot
				(this.IuserService.connectedUsername(), "refuse","termine");
		System.out.println("listNoEmprunt"+ listnoemprunt);
		model.addAttribute("listNoEmprunt", listnoemprunt);

		return "Profil";
	}

	@RequestMapping(value = "/saveTopo", method = RequestMethod.POST)
	public String saveTopo(
							@Valid Topo topo, 
							BindingResult bindingResult, 
							Model model) {
	
		//String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User userConnected = this.IuserService.connectedUser();
		model.addAttribute("user", userConnected);
		
		List<Topo> lisTopos = topoRepository.findToposByUser_Id(userConnected);
		model.addAttribute("listopo", lisTopos);
				
		List<Pret> lpe = pretRepository.findAllByEmprunteur(userConnected);
		model.addAttribute("listPretEmprunteur", lpe);
		
		List<Pret> lpp = pretRepository.findAllByProprietaire(userConnected);
		model.addAttribute("listPretProprio", lpp);
		
		
		List<Pret> listnopret = pretRepository
				.findPretsByProprietaireAndStatutIsNotAndStatutIsNot(userConnected, "refuse",
				"termine");
		model.addAttribute("listNoPret", listnopret);
		List<Pret> listnoemprunt = pretRepository
				.findPretsByEmprunteurAndStatutIsNotAndStatutIsNot(userConnected, "refuse",
				"termine");
		model.addAttribute("listNoEmprunt", listnoemprunt);
		topo.setLoan(false);
		//topo.setUser(user);
		if (bindingResult.hasErrors())
			return "Profil";
		topoRepository.save(topo);
		model.addAttribute("topo", topo);

		return "ConfirmTopo";
	}

	@RequestMapping(value = "/choice", method = RequestMethod.POST, params = "accept")
	public String acceptPret(@RequestParam(name = "PretID", defaultValue = "") int id, Model model) {
		Pret pret = pretRepository.getOne(id);
		pret.setStatut("accepte");
		pretRepository.save(pret);
		return "redirect:/Profil";
	}

    @RequestMapping(value="/choice", method = RequestMethod.POST, params="refus")
    public String refusPret(@RequestParam(name="PretID", defaultValue ="")int id,
                             Model model) {
        Pret pret = pretRepository.getOne(id);
        pret.setStatut("refuse");
        pretRepository.save(pret);
        return "redirect:/Profil";
    }
    
    @RequestMapping(value="/envoiTopo", method = RequestMethod.POST)
    public String envoiTopo(@RequestParam(name="PretID", defaultValue ="")int id,
                            @RequestParam(name="nomDuTopoPret", defaultValue ="")String ndTopoPret,
                             Model model) {
        Pret pret = pretRepository.getOne(id);
        pret.setStatut("en cours");
        pretRepository.save(pret);
        Topo topo = topoRepository.findTopoByNomTopo(ndTopoPret);
        topo.setLoan(true);
        topoRepository.save(topo);
        return "redirect:/Profil";
    }
    
    @RequestMapping(value="/renvoiTopo", method = RequestMethod.POST)
    public String renvoiTopo(@RequestParam(name="PretID", defaultValue ="")int id,
                             @RequestParam(name="nomDuTopoPret", defaultValue ="")String ndTopoPret,
                             Model model) {
        Pret pret = pretRepository.getOne(id);
        pret.setStatut("termine");
        pretRepository.save(pret);
        Topo topo = topoRepository.findTopoByNomTopo(ndTopoPret);
        topo.setLoan(false);
        topoRepository.save(topo);
        return "redirect:/Profil";
    }
	
	
	
}
