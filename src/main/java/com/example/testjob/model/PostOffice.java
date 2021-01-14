package com.example.testjob.model;

import javax.persistence.*;

@Entity
@Table(name = "post_office")
public class PostOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "index")
    private Integer index;
    @Column(name = "name_post_office")
    private String namePostOffice;
    @Column(name = "address")
    private String address;

    public PostOffice() {
    }

    public PostOffice(Long id, Integer index, String namePostOffice, String address) {
        this.id = id;
        this.index = index;
        this.namePostOffice = namePostOffice;
        this.address = address;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getNamePostOffice() {
        return namePostOffice;
    }

    public void setNamePostOffice(String namePostOffice) {
        this.namePostOffice = namePostOffice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
