package tn.esprit.tpfoyer.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.service.IUniversiteService;

import java.util.List;

@Tag(name= "Gestion Universite")
@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteRestController {
    @Autowired
    IUniversiteService universiteService ;

    //http://localhost:8089/tpfoyer/universite/retrieve-all-universites
    @Operation(description = "Récupérer toutes les universités de la base de données")
    @GetMapping("/retrieve-all-universites")
    public List<Universite> getUniversites(){
        return universiteService.retrieveAllUniversites();
    }

    //http://localhost:8089/tpfoyer/universite/retrieve-universite/8
    @Operation(description = "Récupérer une université par son ID")
    @GetMapping("/retrieve-universite/{universite-id}")
    public Universite retrieveUniversite(@PathVariable("universite-id") Long idUniversite){
        return universiteService.retrieveUniversite(idUniversite) ;
    }

    @Operation(description = "Ajouter une nouvelle université")
    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite universite){
        return universiteService.addUniversite(universite) ;
    }

    @Operation(description = "Supprimer une université par son ID")
    @DeleteMapping("/delete-universite/{universite-id}")
    public void removeUniversite(@PathVariable("universite-id") Long idUniversite){
        universiteService.removeUniversite(idUniversite);
    }

    @Operation(description = "Modifier une université existante")
    @PutMapping("/modify-universite")
    public Universite modifyUniversite(@RequestBody Universite universite){
        return universiteService.modifyUniversite(universite) ;
    }
}