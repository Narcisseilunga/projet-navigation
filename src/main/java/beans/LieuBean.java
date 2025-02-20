package beans;

import jakarta.annotation.ManagedBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@Named("lieuBean")
@RequestScoped
public class LieuBean {
    private String nom;
    private String description;
    private double latitude;
    private double longitude;
    private static List<Lieu> listeLieux = new ArrayList<>();

    // Getters et Setters
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }

    public List<Lieu> getListeLieux() { return listeLieux; }

    // Méthode pour ajouter un lieu
    public void ajouterLieu() {
        Lieu lieu = new Lieu(nom, description, latitude, longitude);
        listeLieux.add(lieu);
        
        // Réinitialisation des champs après l'ajout
        this.nom = "";
        this.description = "";
        this.latitude = 0.0;
        this.longitude = 0.0;
    }
    public void retourMenu(){
        try{
            FacesContext.getCurrentInstance().getExternalContext()
                    .redirect("home.xhtml");
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    // Classe interne pour stocker les lieux
    public static class Lieu {
        private String nom;
        private String description;
        private double latitude;
        private double longitude;

        public Lieu(String nom, String description, double latitude, double longitude) {
            this.nom = nom;
            this.description = description;
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public String getNom() { return nom; }
        public String getDescription() { return description; }
        public double getLatitude() { return latitude; }
        public double getLongitude() { return longitude; }
    }
}
