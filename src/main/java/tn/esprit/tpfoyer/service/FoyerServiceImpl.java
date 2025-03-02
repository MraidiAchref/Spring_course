package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.FoyerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService{
    @Autowired
    FoyerRepository foyerRepository ;
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
}
