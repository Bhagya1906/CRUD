package com.bhagya.learning.crud.models;

public class PartsDetails {

    private int featureId;

    private String nameEn;

    private String nameDE;

    private String partNumber;

    private int noOfDS;

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
