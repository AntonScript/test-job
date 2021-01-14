package com.example.testjob.model;


import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "mailing")
public class Mailing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "tracking_number")
    private Integer trackingNumber;
    @Column(name = "type")
    //каждый тип посылки должен иметь свой код, коды не стал реализовать т.к это не влияет на общую реализацию, их можно хранить в видел сета в бд
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

    @OneToMany(cascade = CascadeType.ALL)
    @ElementCollection
    private List<IntermediatePoint> listPostOffices = new ArrayList<>();

    public Mailing() {
    }

    public Mailing(Integer type, Integer index, String endAddress, String recipientName) {
        this.type = type;
        this.index = index;
        this.endAddress = endAddress;
        this.recipientName = recipientName;
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

    public Integer getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(Integer trackingNumber) {
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

    public List<IntermediatePoint> getListPostOffices() {
        return listPostOffices;
    }

    public void setListPostOffices(List<IntermediatePoint> listPostOffices) {
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
