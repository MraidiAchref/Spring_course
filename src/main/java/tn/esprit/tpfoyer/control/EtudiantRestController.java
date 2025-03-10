package tn.esprit.tpfoyer.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.service.IEtudiantService;

import java.util.List;

@Tag(name= "Gestion etudiants")
@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestController {
    @Autowired
    IEtudiantService etudiantService ;

    //http://localhost:8089/tpfoyer/etudiant/retrieve-all-etudiants
    @Operation(description = "Récupérer tous les étudiants de la base de données")
    @GetMapping("/retrieve-all-etudiant")
    public List<Etudiant> getEtudiants(){
        return etudiantService.retrieveAllEtudiants();
    }

    @Operation(description = "Récupérer un étudiant par son ID")
    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Long idEtudiant){
        return etudiantService.retrieveEtudiant(idEtudiant) ;
    }

    @Operation(description = "Ajouter un nouvel étudiant")
    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant){
        return etudiantService.addEtudiant(etudiant) ;
    }

    @Operation(description = "Supprimer un étudiant par son ID")
    @DeleteMapping("/delete-etudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Long idEtudiant){
        etudiantService.removeEtudiant(idEtudiant);
    }

    @Operation(description = "Modifier un étudiant existant")
    @PutMapping("/modify-etudiant")
    public Etudiant modifyEtudiant(@RequestBody Etudiant etudiant){
        return etudiantService.modifyEtudiant(etudiant) ;
    }
}