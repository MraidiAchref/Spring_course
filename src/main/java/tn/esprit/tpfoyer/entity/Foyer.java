package tn.esprit.tpfoyer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer ;

    private String nomFoyer ;
    private Long capaciteFoyer ;

    @OneToOne(mappedBy = "foyer")
    private Universite universite ;

    @OneToMany(cascade =CascadeType.ALL , mappedBy = "foyerInBloc" , fetch = FetchType.LAZY)
    private List<Bloc> blocs = new ArrayList<Bloc>();
}
