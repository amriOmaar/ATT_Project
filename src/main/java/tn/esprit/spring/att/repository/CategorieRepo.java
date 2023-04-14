package tn.esprit.spring.att.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.att.entities.Categorie;

public interface CategorieRepo  extends JpaRepository<Categorie, Long> {

    Categorie findByNom(String nom);



}
