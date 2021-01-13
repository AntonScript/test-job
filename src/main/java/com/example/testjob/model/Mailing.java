package com.example.testjob.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "mailing")
public class Mailing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "tracking_number")
    private Long trackingNumber;
    @Column(name = "type")
    private Integer type;
    @Column(name = "index")
    private Integer index;
    @Column(name = "end_address")
    private String endAddress;
    @Column(name = "recipient_name")
    private String recipientName;
    @Column(name = "status")
    private boolean status;
    @Column(name = "list_post_offices")
    @ElementCollection
    private List<Integer> listPostOffices = new ArrayList<Integer>();


    public Mailing(Long id, Long trackingNumber, Integer type, Integer index, String endAddress, String recipientName, boolean status, List<Integer> listPostOffices) {
        this.id = id;
        this.trackingNumber = trackingNumber;
        this.type = type;
        this.index = index;
        this.endAddress = endAddress;
        this.recipientName = recipientName;
        this.status = status;
        this.listPostOffices = listPostOffices;
    }

    public Mailing(Long trackingNumber, Integer type, Integer index, String endAddress, String recipientName, boolean status, List<Integer> listPostOffices) {
        this.trackingNumber = trackingNumber;
        this.type = type;
        this.index = index;
        this.endAddress = endAddress;
        this.recipientName = recipientName;
        this.status = status;
        this.listPostOffices = listPostOffices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(Long trackingNumber) {
        this.trackingNumber = trackingNumber;
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

    public List<Integer> getListPostOffices() {
        return listPostOffices;
    }

    public void setListPostOffices(List<Integer> listPostOffices) {
        this.listPostOffices = listPostOffices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mailing mailing = (Mailing) o;
        return Objects.equals(type, mailing.type) && Objects.equals(index, mailing.index) && Objects.equals(endAddress, mailing.endAddress) && Objects.equals(recipientName, mailing.recipientName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, index, endAddress, recipientName);
    }
}
