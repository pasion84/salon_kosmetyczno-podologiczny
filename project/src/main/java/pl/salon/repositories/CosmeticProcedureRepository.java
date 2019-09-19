package pl.salon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.salon.model.CosmeticProcedure;

public interface CosmeticProcedureRepository extends JpaRepository<CosmeticProcedure, Long> {
}
