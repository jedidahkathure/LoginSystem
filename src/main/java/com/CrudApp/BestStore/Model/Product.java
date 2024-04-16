package com.CrudApp.BestStore.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name="Products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String brand;
    private String category;
    private double price;
    @Column(columnDefinition="Text")
    private String description;
    private Date createdAt;
    private String imageFileName;





}
