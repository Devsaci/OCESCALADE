package org.ocescalade.controlleur;

import java.util.List;

import org.ocescalade.dao.SpotRepository;
import org.ocescalade.entities.Spot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SpotController {
	@Autowired
	private SpotRepository spotRepository;

	
	
	@RequestMapping(value="/ListSpot")
public String RecherchSpot(Model model,
		@RequestParam(name="motclef1", defaultValue ="")String mc1,
		@RequestParam(name="motclef2", defaultValue ="")String mc2) {
	
	 List<Spot> listSpot  = spotRepository
			 .fingByNomSiteAndDescriptionSite(mc1,mc2);
	 model.addAttribute("motclef1", mc1 );
     model.addAttribute("motclef2", mc2 );
	 model.addAttribute("listSpot" , listSpot );	
	return "ListSpot";
	
}

	
}
