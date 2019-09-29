package pl.salon.model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.pl.NIP;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client extends AbstractEntity {

    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(name = "name")
    private String firstName;
    @Column(name = "surname")
    private String lastName;
    @Column(unique = true, nullable = false, name = "phone")
    @Pattern(regexp = "[1-9][0-9]{8}", message = "nr telefonu składa się z 9 liczb")
    private String phoneNumber;
    @OneToMany(mappedBy = "client")
    private List<PlannedProcedure> plannedProcedure = new ArrayList<>();
    @Column(name = "salary")
    private Double salaryPerHour;
    @Column(name = "address")
    private String address;
    @NIP
    private String nip;
    @NotEmpty
    @Column(name = "role")
    private String role;
    @Column(name = "start_of_work")
    private LocalTime startingTime;
    @Column(name = "end_of_work")
    private LocalTime finishingTime;

    public void setRole(String role) {
        this.role = role;
    }

    public LocalTime getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(LocalTime startingTime) {
        this.startingTime = startingTime;
    }

    public LocalTime getFinishingTime() {
        return finishingTime;
    }

    public void setFinishingTime(LocalTime finishingTime) {
        this.finishingTime = finishingTime;
    }

    public String getRole() {
        return role;
    }

    public void setRoleSet(String role) {
        this.role = role;
    }

    public Double getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(Double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public List<PlannedProcedure> getPlannedProcedure() {
        return plannedProcedure;
    }

    public void setPlannedProcedure(List<PlannedProcedure> plannedProcedure) {
        this.plannedProcedure = plannedProcedure;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", plannedProcedure=" + plannedProcedure +
                ", salaryPerHour=" + salaryPerHour +
                ", address='" + address + '\'' +
                ", nip='" + nip + '\'' +
                ", role='" + role + '\'' +
                ", startingTime=" + startingTime +
                ", finishingTime=" + finishingTime +
                "} " + super.toString();
    }
}
