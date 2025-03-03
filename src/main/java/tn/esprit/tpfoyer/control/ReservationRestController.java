package tn.esprit.tpfoyer.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.service.IReservationService;

import java.util.List;

@Tag(name= "Gestion Reservations")
@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {
    @Autowired
    IReservationService reservationService ;

    //http://localhost:8089/tpfoyer/reservation/retrieve-all-reservations
    @Operation(description = "Récupérer toutes les réservations de la base de données")
    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> getReservations(){
        return reservationService.retrieveAllReservations();
    }

    //http://localhost:8089/tpfoyer/reservation/retrieve-reservation/8
    @Operation(description = "Récupérer une réservation par son ID")
    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") String idReservation){
        return reservationService.retrieveReservation(idReservation) ;
    }

    @Operation(description = "Ajouter une nouvelle réservation")
    @PostMapping("/add-reservation")
    public Reservation addReservation(@RequestBody Reservation reservation){
        return reservationService.addReservation(reservation) ;
    }

    @Operation(description = "Supprimer une réservation par son ID")
    @DeleteMapping("/delete-reservation/{reservation-id}")
    public void removeReservation(@PathVariable("reservation-id") String idReservation){
        reservationService.removeReservation(idReservation);
    }

    @Operation(description = "Modifier une réservation existante")
    @PutMapping("/modify-reservation")
    public Reservation modifyReservation(@RequestBody Reservation reservation){
        return reservationService.modifyReservation(reservation) ;
    }
}