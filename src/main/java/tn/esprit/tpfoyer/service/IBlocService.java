package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Chambre;

import java.util.List;

public interface IBlocService {
    public List<Bloc> retrieveAllBlocs();
    public Bloc retrieveBloc(Long idBloc);
    public Bloc addBloc(Bloc b);
    public void removeBloc(Long idBloc);
    public Bloc modifyBloc(Bloc bloc);
}
