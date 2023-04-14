package tn.esprit.spring.att.cotroller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.att.entities.*;
import tn.esprit.spring.att.service.*;

import java.util.List;


@org.springframework.web.bind.annotation.RestController
@AllArgsConstructor
public class RestController {

    ServiceImpl Services;


    @GetMapping("/getCategories")
    public List<Categorie> getCategories(){
        return Services.getCategories();
    }

    @GetMapping("/getCategorieById/{idCat}")
    public Categorie getCategorieByID(@PathVariable("idCat") Long idCat){
        return Services.getCategorieByID(idCat);
    }

    @PostMapping("/addCategorie")
    public Categorie saveCategorie(@RequestBody Categorie cat) throws Exception {
        return Services.saveCategorie(cat);
    }









    @GetMapping("/getSousCategories")
    public List<SousCategorie> getSousCategories(){
        return Services.getSousCategories();
    }


    @PostMapping("/addSousCatToCat/{idCat}")
    @ResponseBody
    public void addSousCategorieToCategorie(@RequestBody SousCategorie sousCategorie,
                                       @PathVariable("idCat") Long idCat){
        Services.addSousCategorieToCategorie(sousCategorie,idCat);
    }

    @PostMapping("/addSousCatToCatByNom/{nom}")
    @ResponseBody
    public void addSousCategorieToCategorieByNom(@RequestBody SousCategorie sousCategorie,
                                            @PathVariable("nom") String nom){
        Services.addSousCategorieToCategorieByNom(sousCategorie,nom);
    }

}
