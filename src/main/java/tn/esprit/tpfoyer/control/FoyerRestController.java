package tn.esprit.tpfoyer.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.service.IFoyerService;

import java.util.List;

@Tag(name= "Gestion Foyer")
@RestController
@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerRestController {
    @Autowired
    IFoyerService foyerService ;

    //http://localhost:8089/tpfoyer/foyer/retrieve-all-foyers
    @Operation(description = "Récupérer tous les foyers de la base de données")
    @GetMapping("/retrieve-all-foyers")
    public List<Foyer> getFoyers(){
        return foyerService.retrieveAllFoyers();
    }

    //http://localhost:8089/tpfoyer/foyer/retrieve-foyer/8
    @Operation(description = "Récupérer un foyer par son ID")
    @GetMapping("/retrieve-foyer/{foyer-id}")
    public Foyer retrieveFoyer(@PathVariable("foyer-id") Long idFoyer){
        return foyerService.retrieveFoyer(idFoyer) ;
    }

    @Operation(description = "Ajouter un nouveau foyer")
    @PostMapping("/add-foyer")
    public Foyer addFoyer(@RequestBody Foyer foyer){
        return foyerService.addFoyer(foyer) ;
    }

    @Operation(description = "Supprimer un foyer par son ID")
    @DeleteMapping("/delete-foyer/{foyer-id}")
    public void removeFoyer(@PathVariable("foyer-id") Long idFoyer){
        foyerService.removeFoyer(idFoyer);
    }

    @Operation(description = "Modifier un foyer existant")
    @PutMapping("/modify-foyer")
    public Foyer modifyFoyer(@RequestBody Foyer foyer){
        return foyerService.modifyFoyer(foyer) ;
    }
}
