package fr.uga.l3miage.tp3.exo1.repositories;

import fr.uga.l3miage.tp3.exo1.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,String> {
    
    /* Ajout de fonction dans le repository

    * Le type de retour
    * Dans un premier temps, il faut voir le type de retour de notre fonction.
    * Dans notre cas, nous voulons plusieurs utilisateurs à la fois, et nous ne
    * voulons pas avoir de doublons.
    * Dans notre cas il nous faut donc un Set<UserEntity>

    * La granularité
    * Nous voulons chercher tous les éléments : nous allons utiliser la base findAllBy

    *  Element de recherche
    * Dans notre cas, nous recherchons si l'email contient une information,
    * donc MailContaining

    * Avec tout l'ensemble
    * En assemblant toutes les informations précédentes, nous créons la fonction suivante :*/
    Set<UserEntity> findAllByMailContaining(String containing);
}
