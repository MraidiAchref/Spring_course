package tn.esprit.tpfoyer.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre ;

    private Long numeroChambre;

    @Enumerated(EnumType.STRING)
    private TypeChambre typeC ;
    @ManyToOne
    private Bloc bloc ;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Reservation> reservation ;

}
