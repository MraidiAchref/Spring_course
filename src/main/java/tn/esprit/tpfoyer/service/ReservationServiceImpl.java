package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.repository.ReservationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements IReservationService{
    @Autowired
    ReservationRepository reservationRepository ;
    public List<Reservation> retrieveAllReservations(){
        return reservationRepository.findAll();
    };
    public Reservation retrieveReservation(String idReservation){
        return reservationRepository.findById(idReservation).get() ;
    };
    public Reservation addReservation(Reservation b){
        return reservationRepository.save(b) ;
    };
    public void removeReservation(String idReservation){
        reservationRepository.deleteById(idReservation);
    };
    public Reservation modifyReservation(Reservation reservation){
        return reservationRepository.save(reservation) ;
    };
}
