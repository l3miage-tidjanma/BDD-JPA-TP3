package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.UserEntity;
import fr.uga.l3miage.tp3.exo1.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class UserComponent {
    private final UserRepository userRepository;

    /*----------------------------------------------------------*/
    /* créer un comportement CRUD(create, read, update, delete).*/
    /*----------------------------------------------------------*/

    //////////
    // READ //
    //////////
    
    // permet la lecture d'une entité user en base grâce à son id.
    public UserEntity getUser(String name){
        return userRepository.findById(name).orElseThrow();
    }

    ////////////
    // CREATE //
    ////////////

    //  permet de créer un user en base de données
    public UserEntity createUser(){
        UserEntity userEntity = UserEntity
                .builder()
                .mail("user@user.com")
                .name("user")
                .playlistEntities(Set.of())
                .build();
        return userRepository.save(userEntity);
    }

    ////////////
    // UPDATE //
    ////////////

    // récupérer l'entité en base, la modifier, puis l'enregistrer
    public UserEntity updateEmail(String name,String newMail){
        UserEntity userEntity = userRepository.findById(name).orElseThrow();    // ou getUser(name) ?
        userEntity.setMail(newMail);
        return userRepository.save(userEntity);
    }

    ////////////
    // DELETE //
    ////////////

    // supprimer en base de données l'utilisateur
    public void deleteUser(String name){
        userRepository.deleteById(name);
    }

    /* METHODES */
    public Set<UserEntity> getUserIsInDomain(String domaine){
        return userRepository.findAllByMailContaining(domaine);
    }
}
