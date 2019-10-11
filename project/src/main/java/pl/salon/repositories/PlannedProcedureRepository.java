package pl.salon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.salon.model.PlannedProcedure;

import java.util.List;

public interface PlannedProcedureRepository extends JpaRepository<PlannedProcedure, Long> {
    List<PlannedProcedure> findAllByClientId(Long id);

    PlannedProcedure getPlannedProcedureByClient_Id(Long id);

    List<PlannedProcedure> findAllByClient_Email(String email);

}
