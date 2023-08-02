package com.example.Inventory.Inventory;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Inventory {
    @Id
    @SequenceGenerator(
            name = "inventory_sequence",
            sequenceName = "inventory_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "inventory_sequence"
    )
    private Long id;
    private String productName;
    private String productSection;
    private int qty;
    private LocalDate dateReceived;

    public Inventory() {
    }

    public Inventory(Long id,
                     String productName,
                     String productSection,
                     int qty,
                     LocalDate dateReceived) {
        this.id = id;
        this.productName = productName;
        this.productSection = productSection;
        this.qty = qty;
        this.dateReceived = dateReceived;
    }

    public Inventory(String productName,
                     String productSection,
                     int qty,
                     LocalDate dateReceived) {
        this.productName = productName;
        this.productSection = productSection;
        this.qty = qty;
        this.dateReceived = dateReceived;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSection() {
        return productSection;
    }

    public void setProductSection(String productSection) {
        this.productSection = productSection;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public LocalDate getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(LocalDate dateReceived) {
        this.dateReceived = dateReceived;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productSection='" + productSection + '\'' +
                ", qty=" + qty +
                ", dateReceived=" + dateReceived +
                '}';
    }
}
