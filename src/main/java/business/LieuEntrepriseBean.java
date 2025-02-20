package business;

import entities.Lieu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import jakarta.ejb.Stateless;
import jakarta.ejb.LocalBean;
//import jakarta.inject.Named;

/**
 * Stateless session bean for managing Lieu entities.
 * Provides methods to add, list, find, and remove Lieu entities.
 */
//@Named("lieuEntrepriseEntrepriseBean")

@Stateless
@LocalBean
public class LieuEntrepriseBean {

    /**
     * EntityManager for interacting with the persistence context.
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * Adds a new Lieu entity to the database.
     *
     * @param nom the name of the Lieu
     * @param description the description of the Lieu
     * @param latitude the latitude of the Lieu
     * @param longitude the longitude of the Lieu
     */
    @Transactional
    public void ajouterLieuEntreprise(String nom, String description, double latitude, double longitude) {
        Lieu lieu = new Lieu(nom, description, latitude, longitude);
        em.persist(lieu);
    }

    /**
     * Lists all Lieu entities from the database.
     *
     * @return a list of all Lieu entities
     */
    public List<Lieu> listerTousLesLieux() {
        return em.createQuery("SELECT l FROM Lieu l", Lieu.class).getResultList();
    }

    /**
     * Removes a Lieu entity from the database by its ID.
     *
     * @param id the ID of the Lieu to be removed
     */
    @Transactional
    public void supprimerLieu(int id) {
        Lieu lieu = em.find(Lieu.class, id);
        if (lieu != null) {
            em.remove(lieu);
        }
    }

    /**
     * Finds a Lieu entity by its ID.
     *
     * @param id the ID of the Lieu to be found
     * @return the found Lieu entity, or null if not found
     */
    public Lieu trouverLieuParId(int id) {
        return em.find(Lieu.class, id);
    }
}
