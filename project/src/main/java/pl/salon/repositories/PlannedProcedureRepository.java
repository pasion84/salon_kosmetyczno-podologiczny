package pl.salon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.salon.model.PlannedProcedure;

public interface PlannedProcedureRepository extends JpaRepository<PlannedProcedure, Long> {

}
