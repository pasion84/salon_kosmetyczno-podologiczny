package pl.salon.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CosmeticProcedureFormDTO {
    @NotBlank
    private String name;
    @NotNull
    @Range(min = 25)
    private Double price;
    @NotNull
    @Range(min = 20, max = 180)
    private Integer durationOfProcedureInMinutes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getDurationOfProcedureInMinutes() {
        return durationOfProcedureInMinutes;
    }

    public void setDurationOfProcedureInMinutes(Integer durationOfProcedureInMinutes) {
        this.durationOfProcedureInMinutes = durationOfProcedureInMinutes;
    }
}
