package org.ocescalade;

import org.ocescalade.dao.SecteurRepository;
import org.ocescalade.dao.SpotRepository;
import org.ocescalade.dao.TopoRepository;
import org.ocescalade.dao.UserRepository;
import org.ocescalade.dao.VoieRepository;
import org.ocescalade.entities.Secteur;
import org.ocescalade.entities.Spot;
import org.ocescalade.entities.Topo;
import org.ocescalade.entities.User;
import org.ocescalade.entities.Voie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class OcescaladeApplication implements CommandLineRunner {
	
	/*
	
	@Autowired
	private SpotRepository spotRepository;
	@Autowired
	private SecteurRepository secteurRepository;
	@Autowired
	private VoieRepository voieRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TopoRepository topoRepository;

	*/
	
	public static void main(String[] args) {
		SpringApplication.run(OcescaladeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
/*
		Spot s1 = spotRepository.save(new Spot("EVEREST", "L’Everest est le plus haut sommet du globe, avec "
				+ "un pic à 8848 mètres d’altitude. Il est situé sur "
				+ "la frontière entre la zone de Sagarmatha, au Népal, "
				+ "et au Tibet en Chine, et fait partie de la chaîne de montagnes de l’Himalaya. "));
		Spot s2 = spotRepository
				.save(new Spot("Le K2", "Le K2 est le deuxième plus haut sommet sur Terre. Il est situé sur"
						+ " la frontière entre le Baltistan, dans la région de Gilgit Baltistan du Pakistan,"
						+ " et le comté autonome de Taxkorgan Tadjik du Xinjiang, en Chine. Avec une altitude de 8611 mètres,"));
		Spot s3 = spotRepository
				.save(new Spot("KANGCHENJUNGA", "Le Kangchenjunga est la troisième plus haute montagne du monde avec"
						+ " une altitude de 8586 mètres. Le mont Kangchenjunga se trouve à environ 20 km au sud de"
						+ " la chaîne de l’Himalaya, et est situé sur la frontière entre le Népal et l’état indien du Sikkim."));		
		
		
		
		
		
		Secteur sct11 = secteurRepository.save(
				new Secteur("EVEREST Sect_Nord", "la frontière entre la zone de Sagarmatha et le Népal.", s1));
		Secteur sct12 = secteurRepository.save(new Secteur("EVEREST Sect_Sud",
				"la frontière entre la zone du Tibet et le Chine,", s1));

		Secteur sct21 = secteurRepository.save(new Secteur("K2 Sect_Nord",
				"la frontière entre le Baltistan, dans la région du Pakistan.", s2));
		Secteur sct22 = secteurRepository
				.save(new Secteur("K2 Sect_Sud", "entre le comté " + 
						"de Taxkorgan Tadjik et la région du Xinjiangen en Chin.", s2));

		Secteur sct31 = secteurRepository.save(new Secteur("KANGCHENJUNGA Sect_Nord",
				"Tous ces squellettes n'étaient pas au courant des horaires de sieste du maitre des" + " lieux.", s3));
		Secteur sct32 = secteurRepository
				.save(new Secteur("KANGCHENJUNGA Sect_Sud ", "Ne demandez jamais à un dragon de vous prêter du feu.", s3));
	        
	        
	        
		
	        
	        
		Voie voie11 = voieRepository.save(new Voie("Boom", "Quelle mine!", "Mortel", sct11));
		Voie voie12 = voieRepository.save(new Voie("Oups", "Une Grenade!", "Epique", sct11));
		Voie voie21 = voieRepository.save(new Voie("Feroces", "Ces petits hommes verts!", "Epique", sct12));
		Voie voie22 = voieRepository.save(new Voie("Cruels", "C'est des gobelins!", "Mortel", sct12));
		Voie voie31 = voieRepository.save(new Voie("Bourbon", "Avec glaçons.", "Epique", sct21));
		Voie voie32 = voieRepository.save(new Voie("Whysky", "Avec glaçons.", "Impossible", sct21));
		Voie voie41 = voieRepository.save(new Voie("-112", "Mets ton écharpe!", "Mortel", sct22));
		Voie voie42 = voieRepository.save(new Voie("-212", "Mets ton pancho!", "Mortel", sct22));
		Voie voie51 = voieRepository.save(new Voie("14H", "C'est bon il dort.", "Impossible", sct31));
		Voie voie52 = voieRepository.save(new Voie("17H", "Il fait sa ronde.", "Epique", sct31));
		Voie voie61 = voieRepository.save(new Voie("Deux ailes", "Mais pas de poulet.", "Mortel", sct32));
		Voie voie62 = voieRepository.save(new Voie("Brulant", "Quand il souffle sur vous.", "Mortel", sct32));
		
	        
	        
	        
		User u1 = userRepository.save(new User("Ahmed", "1234", "ADMIN", true));
		User u2 = userRepository.save(new User("Moussa", "1233", "USER", true));
		User u3 = userRepository.save(new User("Issa", "1232", "USER", true));
		User u4 = userRepository.save(new User("Ibrahim", "1231", "USER", true));
		User u5 = userRepository.save(new User("Houd", "1230", "USER", true));
		
		
			
			
			
			
			
		Topo tp1 = topoRepository.save(new Topo("Les falaises du diable",
				"Au milieu d'un monde perdu, des falaises de plusieurs centaines"
						+ " de kilomètres se dressent pour mettre au défi les grimpeurs les plus téméraires. ",
				null, false, u1));
		Topo tp2 = topoRepository.save(new Topo("Dragon Pic",
				"Un dragon nommé Smaug protège depuis des milliers d'années un trèsor aux inestimables artefacts.",
				null, false, u3));
		Topo tp3 = topoRepository.save(new Topo("La colline des Moutons",
				"Une jolie colline toute verte qui mène à une splendide falaise. En suivant les"
						+ " moutons, vous risquez de tomber de haut.",
				null, false, u4));
		Topo tp4 = topoRepository.save(new Topo("Gerdre la Sauvage",
				"Sur le pic d'un autre pic des plus escarpés, est planté Escalibur, l'épée"
						+ " enchantée. Attention durant votre ascension car Gerdre la Sauvage veille.",
				null, false, u1));
	*/	
		
		
	}

}
