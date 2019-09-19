package pl.salon.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.salon.dto.CosmeticProcedureFormDTO;
import pl.salon.model.CosmeticProcedure;
import pl.salon.repositories.CosmeticProcedureRepository;

@Service
@Transactional
public class CosmeticProcedureService {
    private CosmeticProcedureRepository cosmeticProcedureRepository;

    public CosmeticProcedureService(CosmeticProcedureRepository cosmeticProcedureRepository) {
        this.cosmeticProcedureRepository = cosmeticProcedureRepository;
    }

    public void registerNewCosmeticProcedure(CosmeticProcedureFormDTO data) {
        CosmeticProcedure cosmeticProcedure = new CosmeticProcedure();
        cosmeticProcedure.setName(data.getName());
        cosmeticProcedure.setPrice(data.getPrice());
        cosmeticProcedure.setDurationOfProcedureInMinutes(data.getDurationOfProcedureInMinutes());
        cosmeticProcedureRepository.save(cosmeticProcedure);
    }
}