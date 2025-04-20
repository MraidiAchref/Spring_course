package tn.esprit.tpfoyer.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.service.IBlocService;

import java.util.List;

@Tag(name= "Gestion Bloc")
@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {
    @Autowired
    IBlocService blocService ;

    //http://localhost:8089/tpfoyer/bloc/retrieve-all-blocs
    @Operation(description = "Récupérer tous les blocs de la base de données")
    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> getBlocs(){
        return blocService.retrieveAllBlocs();
    }

    //http://localhost:8089/tpfoyer/bloc/retrieve-bloc/8
    @Operation(description = "Récupérer un bloc par son ID")
    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable("bloc-id") Long idBloc){
        return blocService.retrieveBloc(idBloc) ;
    }

    @Operation(description = "Ajouter un nouveau bloc")
    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc bloc){
        return blocService.addBloc(bloc) ;
    }

    @Operation(description = "Supprimer un bloc par son ID")
    @DeleteMapping("/delete-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long idBloc){
        blocService.removeBloc(idBloc);
    }

    @Operation(description = "Modifier un bloc existant")
    @PutMapping("/modify-bloc")
    public Bloc modifyBloc(@RequestBody Bloc bloc){
        return blocService.modifyBloc(bloc) ;
    }

    @Operation(description = "Récupérer tous les blocs sans foyer")
    @GetMapping("/retrieve-blocs-with-null-foyer")
    public List<Bloc> retrieveBlocsWithNullFoyer(){
        return blocService.retrieveBlocsWithNullFoyer();
    }
}
