package pl.salon.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.salon.dto.CosmeticProcedureFormDTO;
import pl.salon.dto.PlannedProcedureDTO;
import pl.salon.model.CosmeticProcedure;
import pl.salon.model.PlannedProcedure;
import pl.salon.repositories.CosmeticProcedureRepository;
import pl.salon.repositories.PlannedProcedureRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class CosmeticProcedureService {
    private CosmeticProcedureRepository cosmeticProcedureRepository;
    private PlannedProcedureRepository plannedProcedureRepository;

    public CosmeticProcedureService(CosmeticProcedureRepository cosmeticProcedureRepository, PlannedProcedureRepository plannedProcedureRepository) {
        this.cosmeticProcedureRepository = cosmeticProcedureRepository;
        this.plannedProcedureRepository = plannedProcedureRepository;
    }


    public void registerNewCosmeticProcedure(CosmeticProcedureFormDTO data) {
        CosmeticProcedure cosmeticProcedure = new CosmeticProcedure();
        cosmeticProcedure.setName(data.getName());
        cosmeticProcedure.setPrice(data.getPrice());
        cosmeticProcedure.setDurationOfProcedureInMinutes(data.getDurationOfProcedureInMinutes());
        cosmeticProcedureRepository.save(cosmeticProcedure);
    }

    public List<CosmeticProcedure> findAllCosmeticProcedures() {
        return cosmeticProcedureRepository.findAll();
    }

    public CosmeticProcedure findCosmeticProcedureById(Long id) {
        return cosmeticProcedureRepository.findCosmeticProcedureById(id);
    }

    public void deleteCosmeticProcedureById(Long id) {
        cosmeticProcedureRepository.deleteCosmeticProcedureById(id);
    }

    public void addNewPlannedProcedureForClient(PlannedProcedureDTO data) {
        PlannedProcedure plannedProcedure = new PlannedProcedure();
        plannedProcedure.setCosmeticProcedure(data.getCosmeticProcedure());
        plannedProcedure.setClient(data.getClient());
        plannedProcedure.setCreatedTime(LocalDateTime.now());
        plannedProcedure.setDateAndTimeOfProcedure(LocalDateTime.now());
        plannedProcedureRepository.save(plannedProcedure);
    }
}
