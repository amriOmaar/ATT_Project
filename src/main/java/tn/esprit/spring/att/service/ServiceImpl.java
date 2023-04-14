package tn.esprit.spring.att.service;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import tn.esprit.spring.att.entities.*;
import tn.esprit.spring.att.repository.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ServiceImpl {

    CategorieRepo categorieRepo;
    ArticleRepo articleRepo;
    SousCategorieRepo sousCategorieRepo;



    public List<Categorie> getCategories() {
        return categorieRepo.findAll();
    }

    public Categorie getCategorieByID(Long idCategorie) {
        return categorieRepo.findById(idCategorie).orElse(null);
    }


    public Categorie saveCategorie(Categorie cat) throws Exception{
        if(categorieRepo.findByNom(cat.getNom()) != null)
            throw new Exception("Categorie already exists");
        return categorieRepo.save(cat);
    }

    public Categorie updateCategorie(Long idCategorie, Categorie categorie) {
        if (categorieRepo.findById(idCategorie).isPresent()) {
            Categorie toUpdateCat = categorieRepo.findById(idCategorie).get();
            toUpdateCat.setCode(categorie.getCode());
            toUpdateCat.setNom(categorie.getNom());
            return categorieRepo.save(toUpdateCat);
        }
        return null;
    }

    public void deleteCategorie(Long idCategorie) {
        categorieRepo.deleteById(idCategorie);
    }


    public List<SousCategorie> getSousCategories() {
        return sousCategorieRepo.findAll();
    }


    
    

    public SousCategorie addSousCategorieToCategorie(SousCategorie sousCategorie, Long idCat) {
        Categorie cat = categorieRepo.findById(idCat).orElse(null);
        sousCategorieRepo.save(sousCategorie);
        cat.getSousCategories().add(sousCategorie);
        categorieRepo.save(cat);
        return sousCategorie;
    }


    public SousCategorie addSousCategorieToCategorieByNom(SousCategorie sousCategorie, String nom) {
        Categorie cat = categorieRepo.findByNom(nom);
        sousCategorieRepo.save(sousCategorie);
        cat.getSousCategories().add(sousCategorie);
        categorieRepo.save(cat);
        return sousCategorie;
    }





}

