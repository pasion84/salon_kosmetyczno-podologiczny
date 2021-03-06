package pl.salon.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.salon.dto.CosmeticProcedureFormDTO;
import pl.salon.dto.PlannedProcedureDTO;
import pl.salon.dto.RegistrationFormDTO;
import pl.salon.model.Client;
import pl.salon.model.CosmeticProcedure;
import pl.salon.model.PlannedProcedure;
import pl.salon.repositories.ClientRepository;
import pl.salon.repositories.CosmeticProcedureRepository;
import pl.salon.repositories.PlannedProcedureRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CosmeticProcedureService {
    private CosmeticProcedureRepository cosmeticProcedureRepository;
    private PlannedProcedureRepository plannedProcedureRepository;
    private ClientRepository clientRepository;
    private ClientService clientService;

    public CosmeticProcedureService(CosmeticProcedureRepository cosmeticProcedureRepository, PlannedProcedureRepository plannedProcedureRepository, ClientRepository clientRepository, ClientService clientService) {
        this.cosmeticProcedureRepository = cosmeticProcedureRepository;
        this.plannedProcedureRepository = plannedProcedureRepository;
        this.clientRepository = clientRepository;
        this.clientService = clientService;
    }


    public void registerNewCosmeticProcedure(CosmeticProcedureFormDTO data) {
        CosmeticProcedure cosmeticProcedure = new CosmeticProcedure();
        cosmeticProcedure.setName(data.getName());
        cosmeticProcedure.setPrice(data.getPrice());
        cosmeticProcedure.setDurationOfProcedureInMinutes(data.getDurationOfProcedureInMinutes());
        cosmeticProcedureRepository.save(cosmeticProcedure);
    }

    public List<PlannedProcedure> findAllPlannedProceduresForClient(String email) {
        return plannedProcedureRepository.findAllByClient_Email(email);
    }

    public List<CosmeticProcedure> findAllCosmeticProcedures() {
        return cosmeticProcedureRepository.findAll();
    }

    public CosmeticProcedure findById(Long id) {
        return cosmeticProcedureRepository.findById(id);
    }

    public void deleteCosmeticProcedureById(Long id) {
        cosmeticProcedureRepository.deleteCosmeticProcedureById(id);
    }

    public void addNewPlannedProcedureForClient(PlannedProcedureDTO data, String email) {
        PlannedProcedure plannedProcedure = new PlannedProcedure();
        plannedProcedure.setListOfWorkers(clientService.findAllWorkers("ROLE-WORKER"));
        plannedProcedure.setClient(clientRepository.findByEmail(email));
        plannedProcedure.setWorker(clientService.findClientById(data.getWorkerId()));
        plannedProcedure.setCreatedTime(LocalDateTime.now());
        plannedProcedure.setDateAndTimeOfProcedure(data.getDateAndTimeOfProcedure());

        plannedProcedure.setCosmeticProcedureList(data.getCosmeticProcedure());
        plannedProcedureRepository.save(plannedProcedure);
    }
}
