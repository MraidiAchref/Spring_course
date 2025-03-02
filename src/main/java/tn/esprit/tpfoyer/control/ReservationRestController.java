package tn.esprit.tpfoyer.control;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.service.IReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {
    @Autowired
    IReservationService reservationService ;

    //http://localhost:8089/tpfoyer/reservation/retrieve-all-reservations
    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> getReservations(){
        return reservationService.retrieveAllReservations();
    }

    //http://localhost:8089/tpfoyer/reservation/retrieve-reservation/8
    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") String idReservation){
        return reservationService.retrieveReservation(idReservation) ;
    }

    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation reservation){
        return reservationService.addReservation(reservation) ;
    }

    @DeleteMapping("/delete-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") String idReservation){
        reservationService.removeReservation(idReservation);
    }

    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation reservation){
        return reservationService.modifyReservation(reservation) ;
    }


}
