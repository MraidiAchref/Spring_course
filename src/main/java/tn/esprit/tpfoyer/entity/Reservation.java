package tn.esprit.tpfoyer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    private String idReservation ;

    private Date anneeUniversitaire ;
    private boolean estValide ;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants ;

}
