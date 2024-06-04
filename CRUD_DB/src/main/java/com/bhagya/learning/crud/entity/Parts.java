package com.bhagya.learning.crud.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Parts")

public class Parts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "featureId")
    private int featureId;


    @Column(name = "nameEn")
    private String nameEn;

    @Column(name = "nameDE")
    private String nameDE;

    @Column(name = "partNumber")
    private String partNumber;

    @Column(name = "noOfDS")
    private int noOfDS;

    @Column(name = "noOfDZ")
    private int noOfDZ;

    public int getFeatureId() {
        return featureId;
    }

    public void setFeatureId(int featureId) {
        this.featureId = featureId;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getNameDE() {
        return nameDE;
    }

    public void setNameDE(String nameDE) {
        this.nameDE = nameDE;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public int getNoOfDS() {
        return noOfDS;
    }

    public void setNoOfDS(int noOfDS) {
        this.noOfDS = noOfDS;
    }

    public int getNoOfDZ() {
        return noOfDZ;
    }

    public void setNoOfDZ(int noOfDZ) {
        this.noOfDZ = noOfDZ;
    }

}
