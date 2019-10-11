package pl.salon.dto;

import pl.salon.model.Client;
import pl.salon.model.CosmeticProcedure;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PlannedProcedureDTO {

    private List<CosmeticProcedure> cosmeticProcedure = new ArrayList<>();
    private LocalDateTime dateAndTimeOfProcedure;
    private LocalDateTime createdTime;
    private Long cosmeticProcedureId;
    private Long workerId;

    public PlannedProcedureDTO(Long workerId) {
        this.workerId = workerId;
    }

    public PlannedProcedureDTO() {
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }


    public Long getWorkerId() {
        return workerId;
    }

    public Long getCosmeticProcedureId() {
        return cosmeticProcedureId;
    }

    public void setCosmeticProcedureId(Long cosmeticProcedureId) {
        this.cosmeticProcedureId = cosmeticProcedureId;
    }


    public List<CosmeticProcedure> getCosmeticProcedure() {
        return cosmeticProcedure;
    }

    public void setCosmeticProcedure(List<CosmeticProcedure> cosmeticProcedure) {
        this.cosmeticProcedure = cosmeticProcedure;
    }

    public Long getClientId(Client client) {
        return client.getId();
    }

    public LocalDateTime getDateAndTimeOfProcedure() {
        return dateAndTimeOfProcedure;
    }

    public void setDateAndTimeOfProcedure(LocalDateTime dateAndTimeOfProcedure) {
        this.dateAndTimeOfProcedure = dateAndTimeOfProcedure;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }
}
