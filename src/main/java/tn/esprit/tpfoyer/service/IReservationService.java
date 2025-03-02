package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Reservation;

import java.util.List;

public interface IReservationService {
    public List<Reservation> retrieveAllReservations();
    public Reservation retrieveReservation(String idReservation);
    public Reservation addReservation(Reservation r);
    public void removeReservation(String idReservation);
    public Reservation modifyReservation(Reservation reservation);
}
