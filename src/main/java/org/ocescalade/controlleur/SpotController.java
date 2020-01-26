package org.ocescalade.controlleur;

import java.util.List;
import javax.validation.Valid;

import org.ocescalade.dao.CommentaireRepository;
import org.ocescalade.dao.SecteurRepository;
import org.ocescalade.dao.SpotRepository;
import org.ocescalade.dao.VoieRepository;
import org.ocescalade.entities.Commentaire;
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

@Controller
public class SpotController {
	@Autowired
	private SpotRepository spotRepository;
	@Autowired
	private SecteurRepository secteurRepository;
	@Autowired
	private VoieRepository voieRepository;
	@Autowired
	private CommentaireRepository commentaireRepository;

	@RequestMapping(value = "/ListSpot")
	public String chercherSpot(Model model, 
			@RequestParam(name = "motclef1", defaultValue = "") String mc1,
			@RequestParam(name = "motclef2", defaultValue = "") String mc2) {
		List<Spot> lSpot = spotRepository.findSpotByNomSpotIsContainingAndDescriptionSpotContaining(mc1, mc2);
		//List<Spot> listSpot = spotRepository.findAll();
		model.addAttribute("listSpot", lSpot);
		model.addAttribute("motclef1", mc1);
		model.addAttribute("motclef2", mc2);
		return "ListSpot";
	}
	
    @RequestMapping(value="/Spot")
    public String AfficherSpot(Model model,
    		@RequestParam(name="SpotID", defaultValue ="")Integer sid) {
    	
    	model.addAttribute("SpotID", sid);  
    	
    	Spot spot = spotRepository.getOne(sid);
        model.addAttribute("spot" , spot );
        
        List<Secteur> secteurs = secteurRepository.findSecteursBySpotIdSpot(sid);
        model.addAttribute("secteur" , secteurs );
        
        List<Voie> voies = voieRepository.findVoiesBySecteurSpotIdSpot(sid);
        model.addAttribute("voie", voies);
        
        List<Commentaire> commentaires = commentaireRepository.findCommentairesBySpotIdSpot(sid);
        model.addAttribute("commentaires", commentaires);
        
        model.addAttribute("commentaire", new Commentaire());
        
        return "Spot";
    }
	
    
	@RequestMapping(value = "/saveCommentaire", method = RequestMethod.POST)
	public String saveCommentaire(Model model,
			@RequestParam(name="SpotID", defaultValue ="")Integer sid, 
			@Valid Commentaire commentaire,
			BindingResult bindingResult) {

		model.addAttribute("SpotID", sid);
		Spot spot=spotRepository.getOne(sid);
		commentaire.setSpot(spot);
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("spot", spot);
			
			List<Secteur> secteurs=secteurRepository.findSecteursBySpotIdSpot(sid);
			model.addAttribute("secteur", secteurs);
			
			List<Voie> voies=voieRepository.findVoiesBySecteurSpotIdSpot(sid);
			model.addAttribute("voie", voies);
			
			List<Commentaire> commentaires=commentaireRepository.findCommentairesBySpotIdSpot(sid);
			model.addAttribute("commentaires", commentaires);
			
			return "Spot";			
		}
			
		commentaireRepository.save(commentaire);
		model.addAttribute("commentaire",commentaire);
		
		
		return "ConfirmCommentaire";
	}       
}
