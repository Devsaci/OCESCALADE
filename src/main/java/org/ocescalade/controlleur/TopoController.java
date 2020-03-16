package org.ocescalade.controlleur;

import java.util.List;

import javax.validation.Valid;

import org.ocescalade.dao.PretRepository;
import org.ocescalade.dao.TopoRepository;
import org.ocescalade.entities.Pret;
import org.ocescalade.entities.Topo;
import org.ocescalade.entities.User;
import org.ocescalade.service.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TopoController {
	@Autowired
	private TopoRepository topoRepository;
	@Autowired
	private PretRepository pretRepository;
	@Autowired
	private IuserService userService;

	
	@RequestMapping(value = "/Topo")
	public String Topo(Model model) {
		User userConnected = this.userService.connectedUser();
		List<Topo> listopo = topoRepository.findByUser_IdIsNot(userConnected.getId());
		model.addAttribute("topo", listopo);
		return "Topo";
	}

	
	@RequestMapping(value = "/topoPret")
	public String affPretTopo(@RequestParam(name = "id", defaultValue = "") Integer idt, 
			Model model) {
		model.addAttribute("idTopo", idt);
		Topo topo = topoRepository.findToposByIdIs(idt);
		model.addAttribute("topo", topo);
		model.addAttribute("pret", new Pret());
		System.out.println("topo = /////////////TOPO///////////// " + topo);
		return "topoPret";
	}

	
	@RequestMapping(value = "/savePret", method = RequestMethod.POST)
	public String savePret(@RequestParam(name = "id", defaultValue = "") Integer idt, 
			@Valid Pret pret,
			BindingResult bindingResult, 
			Model model) {
		Topo topo = topoRepository.findToposByIdIs(idt);
		model.addAttribute("topo", topo);
		pret.setUserEmprunteur(this.userService.connectedUser());
		//pret.setNomDuTopo(topo.getNomTopo());
		pret.setStatut("en attente");
		pret.setTopo(topo);
		if (bindingResult.hasErrors())
			return "topoPret";
		pretRepository.save(pret);
		model.addAttribute("pret", pret);
		return "ConfirmPret";
	}
	
}
