package fr.uga.l3miage.tp3.exo1.models;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Setter                 // permet de générer à la compilation tous les setters
@Getter                 // permet de générer à la compilation tous les getters
@Builder                // permet la création d'un builder
@NoArgsConstructor      // génère un constructeur sans paramètres
@AllArgsConstructor     // génère un constructeur avec tous les attributs de la classe en paramètres
public class AlbumEntity {
    @Id
    private String title;

    private Date releaseDate;

    @OneToMany(mappedBy = "albumEntity",cascade = CascadeType.ALL)
    private Set<SongEntity> songEntities;

    @ManyToOne
    private ArtistEntity artistEntity;
}
