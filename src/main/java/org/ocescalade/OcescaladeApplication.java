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
	
	  	
	@Autowired
	private SpotRepository spotRepository;	
	@Autowired
	private UserRepository userRepository;	
	@Autowired
	private SecteurRepository secteurRepository;
	@Autowired
	private VoieRepository voieRepository;
	@Autowired
	private TopoRepository topoRepository;
	
 
	public static void main(String[] args) {
		SpringApplication.run(OcescaladeApplication.class, args);
	}

	
	@Override
	public void run(String... args) throws Exception {


		User u1 = userRepository.save(new User(1,"Jimbo","$2a$10$h4kMaB/.lj6YzdVCs8sOaOgiNbifXtS5srfmLQhNbs0hn5iEns8re","ADMIN",true,null));
		User u2 = userRepository.save(new User(2,"Elorna","$2a$10$h4kMaB/.lj6YzdVCs8sOaOgiNbifXtS5srfmLQhNbs0hn5iEns8re","USER",true,null));
		User u3 = userRepository.save(new User(3,"Martin","$2a$10$h4kMaB/.lj6YzdVCs8sOaOgiNbifXtS5srfmLQhNbs0hn5iEns8re","USER",true,null));
		User u4 = userRepository.save(new User(4,"Luck","$2a$10$h4kMaB/.lj6YzdVCs8sOaOgiNbifXtS5srfmLQhNbs0hn5iEns8re","USER",true,null));
		User u5 = userRepository.save(new User(5,"Siri","$2a$10$h4kMaB/.lj6YzdVCs8sOaOgiNbifXtS5srfmLQhNbs0hn5iEns8re","USER",true,null));


		Spot s1 = spotRepository
				.save(new Spot("EVEREST", "L’Everest est le plus haut sommet du globe, avec "
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
	
		Spot s4 = spotRepository
				.save(new Spot("Tassili n'Ajjer"," culmine à 2 158 mètres d'altitude à l'Adrar Afao et émerge en hautes falaises à "
		+ "1 500 mètres au-dessus des ergs de Mourzouq et d'Oubari et d'Admer"));

	
		

		Secteur sct11= secteurRepository.save(new Secteur("EVEREST Nord",
              "Edmund Hillary et Tensing Norway Sherpa ont réussi la première "
              + "ascension par le versant Népalais le 29 mai 1953.",s1));
		Secteur sct12= secteurRepository.save(new Secteur("EVEREST Sud",
              "Il est aperçu par des Européens pour la première fois en 1847.",s1));

		Secteur sct21= secteurRepository.save(new Secteur("Le K2 Nord",
              "Désastre du K2 Nord a eu lieu le 1er août 2008, lorsque onze alpinistes "
              + "de différentes expéditions internationales sont morts .",
              s2));
		Secteur sct22= secteurRepository.save(new Secteur("Le K2 Sud",
              "L'accès au sommet du K2 Sud est caractérisé par un passage appelé "
              + "Bottleneck (K2).",s2));

		Secteur sct31= secteurRepository.save(new Secteur("KANGCHENJUNGA Nord",
              "Exploration menée par Douglas William Freshfield avec E. Garwood, "
              + "Ange Maquignaz1 et Vittorio Sella en 1899",s3));
		Secteur sct32= secteurRepository.save(new Secteur("KANGCHENJUNGA Sud",
              "L'Américain E.F. Farmer tente seul l'ascension mais trouve la mort "
              + "au cours de cette entreprise 1929.",s3));
		

 	

		Voie voie11 = voieRepository.save(new Voie("EVEREST Nord","Voie EVEREST Nord","4a, 5b", sct11));
		Voie voie12 = voieRepository.save(new Voie("EVEREST Nord","Voie EVEREST Nord","6a, 9b", sct11));
		Voie voie21 = voieRepository.save(new Voie("EVEREST Sud" ,"Voie EVEREST Sud" ,"4a, 5b", sct12));
		Voie voie22 = voieRepository.save(new Voie("EVEREST Sud" ,"Voie EVEREST Sud" ,"6a, 9b", sct12));
		
		Voie voie31 = voieRepository.save(new Voie("K2 Nord", "Voie K2 Nord", "4a, 5b", sct21));
		Voie voie32 = voieRepository.save(new Voie("K2 Nord", "Voie K2 Nord", "6a, 9b", sct21));
		Voie voie41 = voieRepository.save(new Voie("K2 Sud" , "Voie K2 Sud" , "4a, 5b", sct22));
		Voie voie42 = voieRepository.save(new Voie("K2 Sud" , "Voie K2 Sud" , "6a, 9b", sct22));
		
		Voie voie51 = voieRepository.save(new Voie("KANGCHENJUNGA Nord", "Voie KANGCHENJUNGA Nord", "4a, 5b", sct31));
		Voie voie52 = voieRepository.save(new Voie("KANGCHENJUNGA Nord", "Voie KANGCHENJUNGA Nord", "6a, 9b", sct31));
		Voie voie61 = voieRepository.save(new Voie("KANGCHENJUNGA Sud", "Voie KANGCHENJUNGA Sud", "4a, 5b", sct32));
		Voie voie62 = voieRepository.save(new Voie("KANGCHENJUNGA Sud", "Voie KANGCHENJUNGA Sud", "6a, 9b", sct32));


		Topo tp1 = topoRepository.save(new Topo("EVEREST",
		"Topo1 Description.","",false,u2));
		
		Topo tp2 = topoRepository.save(new Topo("Le K2",
		"Topo2 Description.","",false,u1));
		
		Topo tp3 = topoRepository.save(new Topo("KANGCHENJUNGA",
		"Topo3 Description.","",false,u1));
		
		Topo tp4 = topoRepository.save(new Topo("Tassili n'Ajjer",
		"Topo4 Description ","",false,u3));
		


	
	}

}
