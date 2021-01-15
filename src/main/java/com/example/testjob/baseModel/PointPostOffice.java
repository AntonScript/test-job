package com.example.testjob.baseModel;

public class PointPostOffice {
    private Integer trackingNumber;
    private Integer index;

    public PointPostOffice() {
    }

    public PointPostOffice(Integer trackingNumber, Integer index) {
        this.trackingNumber = trackingNumber;
        this.index = index;
    }

    public Integer getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(Integer trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
