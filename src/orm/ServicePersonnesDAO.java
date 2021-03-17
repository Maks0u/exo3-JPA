package orm;

import java.util.List;

import model.Personne;

public interface ServicePersonnesDAO {

	List<Personne> lireTout();
	Personne lire (int id);
	String ajouter(Personne p);
	String modifier(Personne p);
	String supprimer(int id);
}
