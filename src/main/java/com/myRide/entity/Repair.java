package com.myRide.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The type Repair.
 */
@Entity(name = "Repair")
@Table(name = "repairs") // case sensitive!
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @ManyToOne
    private Car car;

    @OneToMany(mappedBy = "repair", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Part> parts = new HashSet<>();

    @Column(name = "service_date")
    private LocalDate serviceDate;

    @Column(name = "invoice_number")
    private String invoiceNumber;

    @Column(name = "service_provider")
    private String serviceProvider;

    @Column(name = "labor_cost")
    private double laborCost;

    @Column(name = "current_mileage")
    private Integer currentMileage;

    @Column(name = "warranty")
    private String warranty;

    @Column(name = "service_performed")
    private String servicePerformed;

    @Column(name = "description")
    private String description;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "update_time")
    private LocalDateTime updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }

    public LocalDate getServiceDate() {
        return serviceDate;
    }

    public void setService_date(LocalDate year) {
        this.serviceDate = year;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public double getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(double laborCost) {
        this.laborCost = laborCost;
    }

    public Integer getCurrentMileage() {
        return currentMileage;
    }

    public void setCurrentMileage(Integer currentMileage) {
        this.currentMileage = currentMileage;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getServicePerformed() {
        return servicePerformed;
    }

    public void setServicePerformed(String servicePerformed) {
        this.servicePerformed = servicePerformed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Repair() {
    }

    @Override
    public String toString() {
        return "Repair{" +
                "id=" + id +
                ", car=" + car +
                ", year=" + serviceDate +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                ", serviceProvider='" + serviceProvider + '\'' +
                ", laborCost=" + laborCost +
                ", currentMileage=" + currentMileage +
                ", warranty='" + warranty + '\'' +
                ", servicePerformed='" + servicePerformed + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repair repair = (Repair) o;
        return id == repair.id &&
                Double.compare(repair.laborCost, laborCost) == 0 &&
                Objects.equals(car, repair.car) &&
                Objects.equals(serviceDate, repair.serviceDate) &&
                Objects.equals(invoiceNumber, repair.invoiceNumber) &&
                Objects.equals(serviceProvider, repair.serviceProvider) &&
                Objects.equals(currentMileage, repair.currentMileage) &&
                Objects.equals(warranty, repair.warranty) &&
                Objects.equals(servicePerformed, repair.servicePerformed) &&
                Objects.equals(description, repair.description) &&
                Objects.equals(createTime, repair.createTime) &&
                Objects.equals(updateTime, repair.updateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, car, serviceDate, invoiceNumber, serviceProvider, laborCost, currentMileage, warranty, servicePerformed, description, createTime, updateTime);
    }
}