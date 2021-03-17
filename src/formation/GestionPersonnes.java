package formation;

import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.sun.jersey.spi.resource.Singleton;

import model.Personne;
import orm.ServicePersonnesDAO;
import orm.ServicePersonnesDAOImpl;

@Singleton
@Path("/personnes")
public class GestionPersonnes {

	ServicePersonnesDAO dao = new ServicePersonnesDAOImpl();

	private Gson g = new Gson();
	private ArrayList<Personne> personnes = new ArrayList<Personne>();

	public GestionPersonnes() {
		for (int i = 0; i < 10; i++) {
			personnes.add(new Personne(i, "Toto" + i));
		}
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lireTout() {
		return Response.status(200).entity(g.toJson(dao.lireTout())).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lire(@PathParam("id") int id) {
		return Response.status(200).entity(g.toJson(dao.lire(id))).build();
	}

	@POST
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public String ajouter(String data) {
		System.out.println(data);
		// Convertir string json en Personne
		Personne p = g.fromJson(data, Personne.class);
		// Ajouter Personne à la liste
		dao.ajouter(p);
		return "OK";
	}

	@PUT
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public String modifier(String data) {
		System.out.println(data);
		// Convertir string json en Personne
		Personne p = g.fromJson(data, Personne.class);
		// Modifier Personne à la liste
		return dao.modifier(p);
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String supprimer(@PathParam("id") int id) {
		System.out.println("DELETE " + id);
		// Supprimer id à la liste
		return dao.supprimer(id);
	}
}