package tn.esprit.tpfoyer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer ;

    private String nomFoyer ;
    private Long capaciteFoyer ;

    @OneToOne(mappedBy = "foyer")
    private Universite universite ;

    @OneToMany(cascade =CascadeType.ALL , mappedBy = "Foyer")
    private Set<Bloc> blocs ;
}
