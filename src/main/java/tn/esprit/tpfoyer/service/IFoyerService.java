package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Foyer;

import java.util.List;

public interface IFoyerService {
    public Foyer affectBlockToFoyer(Long idBloc , Long idFoyer);
    public void desaffecterBlocFromFoyer(Long blocId, Long foyerId) ;

        public List<Foyer> retrieveAllFoyers();
    public Foyer retrieveFoyer(Long idFoyer);
    public Foyer addFoyer(Foyer f);
    public void removeFoyer(Long idFoyer);
    public Foyer modifyFoyer(Foyer foyer);
}
