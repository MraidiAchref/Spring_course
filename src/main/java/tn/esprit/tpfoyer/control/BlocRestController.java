package tn.esprit.tpfoyer.control;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.service.IBlocService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {
    @Autowired
    IBlocService blocService ;

    //http://localhost:8089/tpfoyer/bloc/retrieve-all-blocs
    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> getBlocs(){
        return blocService.retrieveAllBlocs();
    }

    //http://localhost:8089/tpfoyer/bloc/retrieve-bloc/8
    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable("bloc-id") Long idBloc){
        return blocService.retrieveBloc(idBloc) ;
    }

    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc bloc){
        return blocService.addBloc(bloc) ;
    }

    @DeleteMapping("/delete-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long idBloc){
        blocService.removeBloc(idBloc);
    }

    @PutMapping("/modify-bloc")
    public Bloc modifyBloc(@RequestBody Bloc bloc){
        return blocService.modifyBloc(bloc) ;
    }


}
