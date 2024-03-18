package fr.uga.l3miage.tp3.exo1.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.util.Set;

@Entity
@Setter                 // permet de générer à la compilation tous les setters
@Getter                 // permet de générer à la compilation tous les getters
@Builder                // permet la création d'un builder
@NoArgsConstructor      // génère un constructeur sans paramètres
@AllArgsConstructor     // génère un constructeur avec tous les attributs de la classe en paramètres
public class UserEntity {
    @Id
    private String name;
    @Email
    private String mail;

    @OneToMany
    @JoinColumn(name = "name")
    private Set<PlaylistEntity> playlistEntities;
}
