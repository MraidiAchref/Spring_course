package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.BlocRepository;
import tn.esprit.tpfoyer.repository.FoyerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService{
    @Autowired
    FoyerRepository foyerRepository ;
    @Autowired
    BlocRepository blocRepository ;

    public List<Foyer> retrieveAllFoyers(){
        return foyerRepository.findAll();
    };
    public Foyer retrieveFoyer(Long idFoyer){
        return foyerRepository.findById(idFoyer).get() ;
    };
    public Foyer addFoyer(Foyer f){
        return foyerRepository.save(f) ;
    };
    public void removeFoyer(Long idFoyer){
        foyerRepository.deleteById(idFoyer);
    };
    public Foyer modifyFoyer(Foyer foyer){
        return foyerRepository.save(foyer) ;
    };
    public Foyer affectBlockToFoyer(Long idBloc , Long idFoyer){
        Foyer foyer =foyerRepository.findById(idFoyer).get() ;
        Bloc bloc =blocRepository.findById(idBloc).get() ;
        foyer.getBlocs().add(bloc) ;
        return foyerRepository.save(foyer) ;
    }
    public void desaffecterBlocFromFoyer(Long blocId, Long foyerId) {
        Bloc bloc = blocRepository.findById(blocId).get();
        Foyer foyer = foyerRepository.findById(foyerId).get();
// on enlève le fils du parent :
        foyer.getBlocs().remove(bloc);
        foyerRepository.save(foyer);
    }
}
