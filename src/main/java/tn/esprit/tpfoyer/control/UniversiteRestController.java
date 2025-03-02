package tn.esprit.tpfoyer.control;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.service.IUniversiteService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/universite")
public class UniversiteRestController {
    @Autowired
    IUniversiteService universiteService ;
    //http://localhost:8089/tpfoyer/universite/retrieve-all-universites
    @GetMapping("/retrieve-all-universites")
    public List<Universite> getUniversites(){
        return universiteService.retrieveAllUniversites();
    }

    //http://localhost:8089/tpfoyer/universite/retrieve-universite/8
    @GetMapping("/retrieve-universite/{universite-id}")
    public Universite retrieveUniversite(@PathVariable("universite-id") Long idUniversite){
        return universiteService.retrieveUniversite(idUniversite) ;
    }

    @PostMapping("/add-universite")
    public Universite addUniversite(@RequestBody Universite universite){
        return universiteService.addUniversite(universite) ;
    }

    @DeleteMapping("/delete-universite/{universite-id}")
    public void removeUniversite(@PathVariable("universite-id") Long idUniversite){
        universiteService.removeUniversite(idUniversite);
    }

    @PutMapping("/modify-universite")
    public Universite modifyUniversite(@RequestBody Universite universite){
        return universiteService.modifyUniversite(universite) ;
    }
}
