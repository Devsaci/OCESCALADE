package org.ocescalade.controlleur;

import java.util.List;

import javax.validation.Valid;

import org.ocescalade.dao.SecteurRepository;
import org.ocescalade.dao.SpotRepository;
import org.ocescalade.dao.VoieRepository;
import org.ocescalade.entities.Secteur;
import org.ocescalade.entities.Spot;
import org.ocescalade.entities.Voie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/*        */
@Controller
public class AjouteSpotController {
	/*        */
	@Autowired
	private SpotRepository spotRepository;
	@Autowired
	private SecteurRepository secteurRepository;
	@Autowired
	private VoieRepository voieRepository;

	/*        */
	@RequestMapping(value = "/AjouteSpot", method = RequestMethod.GET)
	private String AjouteSpot(Model model) {
		List<Spot> listSpots = spotRepository.findAll();
		model.addAttribute("listSpot", listSpots);
		List<Secteur> listSecteurs = secteurRepository.findAll();
		model.addAttribute("listSecteur", listSecteurs);
		model.addAttribute("spot", new Spot());
		model.addAttribute("secteur", new Secteur());
		model.addAttribute("voie", new Voie());
		return "AjouteSpot";
	}

	
	/*        */
	@RequestMapping(value = "/AjoutSpot", method = RequestMethod.POST)
	private String EnregistreSpot(@Valid Spot spot, 
			BindingResult bindingResult,Model model) {
		/*    */
		if(bindingResult.hasErrors()){
            List<Spot> listSpots = spotRepository.findAll();
            model.addAttribute("listSpot" , listSpots );
            List<Secteur> listSecteurs = secteurRepository.findAll();
            model.addAttribute("listSecteur" , listSecteurs );
            model.addAttribute("secteur", new Secteur());
            model.addAttribute("voie", new Voie());
            return "AjouteSpot";}		
		/*    */		
		spotRepository.save(spot);
		model.addAttribute(" spot", spot);
		return "SpotEnregistrer";
	}

	
	
	/*        */
	@RequestMapping(value = "/AjoutSecteur", method = RequestMethod.POST)
	private String EnregistreSecteur(
			@RequestParam(name = "SpotSecteur", defaultValue ="")Integer sIs,
			@Valid Secteur secteur,
			BindingResult bindingResult,
			Model model ) {
			/*    */ 
		 Spot spot = spotRepository.getOne(sIs);
		 secteur.setSpot(spot);
		 	/*    */ 
		 if(bindingResult.hasErrors()){
	            List<Spot> listSpots = spotRepository.findAll();
	            model.addAttribute("listSpot" , listSpots );
	            List<Secteur> listSecteurs = secteurRepository.findAll();
	            model.addAttribute("listSecteur" , listSecteurs );
	            model.addAttribute("spot", new Spot());
	            model.addAttribute("voie", new Voie());
	            return "AjouteSpot";}				 
		 /*        */
		  secteurRepository.save(secteur);
		  model.addAttribute("secteur", secteur);
		
		return "SecteurEnregistrer";
	}

	
	/*        */
	@RequestMapping(value = "/AjoutVoie", method = RequestMethod.POST)
	private String EnregistreVoie(
			@RequestParam(name = "SecteurVoie", defaultValue ="")Integer sIv,
			@Valid Voie voie,			 
			BindingResult bindingResult,
			Model model ){
		Secteur secteur = secteurRepository.getOne(sIv);
		voie.setSecteur(secteur);
		/*        */
		 if(bindingResult.hasErrors()){
	            List<Spot> listSpots = spotRepository.findAll();
	            model.addAttribute("listSpot" , listSpots );
	            List<Secteur> listSecteurs = secteurRepository.findAll();
	            model.addAttribute("listSecteur" , listSecteurs );
	            model.addAttribute("spot", new Spot());
	            model.addAttribute("secteur", new Secteur());
	            return "AjouteSpot";}			
		/*        */
		voieRepository.save(voie);
        model.addAttribute("voie", voie);
		return "VoieEnregistrer";
	}

}
