package com.example.testjob.baseModel;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CreateMailing {
    private Integer type;
    private Integer index;
    private String endAddress;
    private String recipientName;
    private Integer indexPostOffice;

    public CreateMailing() {
    }

    public CreateMailing(Integer type, Integer index, String endAddress, String recipientName, Integer indexPostOffice) {
        this.type = type;
        this.index = index;
        this.endAddress = endAddress;
        this.recipientName = recipientName;
        this.indexPostOffice = indexPostOffice;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public Integer getIndexPostOffice() {
        return indexPostOffice;
    }

    public void setIndexPostOffice(Integer indexPostOffice) {
        this.indexPostOffice = indexPostOffice;
    }
}
