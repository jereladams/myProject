package com.myRide.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;


/**
 * The type Part.
 */
@Entity(name = "Part")
@Table(name = "parts") // case sensitive!
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @ManyToOne
    private Repair repair;

    @Column(name = "part_name")
    private String partName;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "part_number")
    private String part_Number;

    @Column(name = "warranty")
    private String warranty;

    @Column(name = "supplier")
    private String supplier;

    @Column(name = "price")
    private double price;

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

    public Repair getRepair() {
        return repair;
    }

    public void setRepair(Repair repair) {
        this.repair = repair;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPart_Number() {
        return part_Number;
    }

    public void setPart_Number(String part_Number) {
        this.part_Number = part_Number;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public Part() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Part part = (Part) o;
        return id == part.id &&
                Double.compare(part.price, price) == 0 &&
                Objects.equals(repair, part.repair) &&
                Objects.equals(partName, part.partName) &&
                Objects.equals(manufacturer, part.manufacturer) &&
                Objects.equals(part_Number, part.part_Number) &&
                Objects.equals(warranty, part.warranty) &&
                Objects.equals(supplier, part.supplier) &&
                Objects.equals(description, part.description) &&
                Objects.equals(createTime, part.createTime) &&
                Objects.equals(updateTime, part.updateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, repair, partName, manufacturer, part_Number, warranty, supplier, price, description, createTime, updateTime);
    }
}