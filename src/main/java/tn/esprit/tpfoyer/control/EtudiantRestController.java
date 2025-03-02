package tn.esprit.tpfoyer.control;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.service.IEtudiantService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestController {
    @Autowired
    IEtudiantService etudiantService ;
    //http://localhost:8089/tpfoyer/etudiant/retrieve-all-etudiants
    @GetMapping("/retrieve-all-blocs")
    public List<Etudiant> getEtudiants(){
        return etudiantService.retrieveAllEtudiants();
    }

    //http://localhost:8089/tpfoyer/bloc/retrieve-bloc/8
    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Long idEtudiant){
        return etudiantService.retrieveEtudiant(idEtudiant) ;
    }

    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant){
        return etudiantService.addEtudiant(etudiant) ;
    }

    @DeleteMapping("/delete-etudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Long idEtudiant){
        etudiantService.removeEtudiant(idEtudiant);
    }

    @PutMapping("/modify-etudiant")
    public Etudiant modifyEtudiant(@RequestBody Etudiant etudiant){
        return etudiantService.modifyEtudiant(etudiant) ;
    }
}
