package pl.salon.dto;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

public class CosmeticProcedureFormDTO {
    @NotBlank(message = "wpisz nazwę zabiegu")
    private String name;
    @NotNull(message = "podaj cenę zabiegu")
    @Range(min = 25, message = "zabieg może kosztować min 25 zł")
    private Double price;
    @NotNull(message = "podaj czas trwania zabiegu w minutach")
    @Range(min = 30, max = 180, message = "zabieg może trwać min 30min, max 180min")
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
