package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.AlbumEntity;
import fr.uga.l3miage.tp3.exo1.repositories.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AlbumComponent {
    private final AlbumRepository albumRepository;

    /*----------------------------------------------------------*/
    /* créer un comportement CRUD(create, read, update, delete).*/
    /*----------------------------------------------------------*/

    //////////
    // READ //
    //////////

    // récupère l'ensemble des albums d'un artiste
    public List<AlbumEntity> getAllAlbums() {
        return albumRepository.findAll();
    }

    // récupère un album de par son titre
    public AlbumEntity getAlbumByTitle(String title) {
        return albumRepository.findById(title).orElseThrow();
    }

    // récupère l'année de sortie d'un album par son titre
    public Date getReleaseYearByTitle(String title) {
        AlbumEntity album = albumRepository.findById(title).orElseThrow();
        return album.getReleaseDate();
    }

    ////////////
    // CREATE //
    ////////////

    // créer un nouvel album
    public AlbumEntity createAlbum(AlbumEntity album) {
        return albumRepository.save(album);
    }

    ////////////
    // UPDATE //
    ////////////

    // mettre à jour un album existant
    public AlbumEntity updateAlbum(AlbumEntity album) {
        return albumRepository.save(album);
    }

    ////////////
    // DELETE //
    ////////////

    // supprimer un album par son titre
    public void deleteAlbumByTitle(String title) {
        albumRepository.deleteById(title);
    }
}
