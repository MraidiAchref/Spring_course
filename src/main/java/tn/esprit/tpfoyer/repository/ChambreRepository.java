package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Chambre;

@Repository

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    @Query("SELECT distinct (ch) FROM Chambre ch " +
            "INNER JOIN ch.reservation r " +
            "INNER JOIN r.etudiants e " +
            "WHERE e.cin=:cin " )
    Chambre trouverChselonEt(long cin);
}
