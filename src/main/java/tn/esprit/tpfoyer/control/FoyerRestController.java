package tn.esprit.tpfoyer.control;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.service.IFoyerService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerRestController {
    @Autowired
    IFoyerService foyerService ;

    //http://localhost:8089/tpfoyer/foyer/retrieve-all-foyers
    @GetMapping("/retrieve-all-foyers")
    public List<Foyer> getFoyers(){
        return foyerService.retrieveAllFoyers();
    }

    //http://localhost:8089/tpfoyer/foyer/retrieve-foyer/8
    @GetMapping("/retrieve-foyer/{foyer-id}")
    public Foyer retrieveFoyer(@PathVariable("foyer-id") Long idFoyer){
        return foyerService.retrieveFoyer(idFoyer) ;
    }

    @PostMapping("/add-foyer")
    public Foyer addFoyer(@RequestBody Foyer foyer){
        return foyerService.addFoyer(foyer) ;
    }

    @DeleteMapping("/delete-foyer/{foyer-id}")
    public void removeFoyer(@PathVariable("foyer-id") Long idFoyer){
        foyerService.removeFoyer(idFoyer);
    }

    @PutMapping("/modify-foyer")
    public Foyer modifyFoyer(@RequestBody Foyer foyer){
        return foyerService.modifyFoyer(foyer) ;
    }


}
