package pl.salon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.salon.model.CosmeticProcedure;

import java.util.List;

public interface CosmeticProcedureRepository extends JpaRepository<CosmeticProcedure, Long> {
    @Override
    List<CosmeticProcedure> findAll();

    CosmeticProcedure findCosmeticProcedureById(Long id);

    void deleteCosmeticProcedureById(Long id);
}
