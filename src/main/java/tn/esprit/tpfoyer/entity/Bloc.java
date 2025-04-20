package tn.esprit.tpfoyer.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc ;


    private String nomBloc ;
    private Long capaciteBloc ;

    @ManyToOne(cascade = CascadeType.ALL)
    private Foyer foyerInBloc ;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bloc")
    private Set<Chambre> chambres ;
}
