package com.example.testjob.model;

import javax.persistence.*;

@Entity
public class IntermediatePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "date_of_arrival")
    private String dateOfArrival;
    @Column(name = "date_of_departure")
    private String dateOfDeparture;
    @Column(name = "index_post_office")
    private Integer indexPostOffice;

    public IntermediatePoint() {
    }

    public IntermediatePoint(String dateOfArrival, Integer indexPostOffice) {
        this.dateOfArrival = dateOfArrival;
        this.indexPostOffice = indexPostOffice;
    }

    public IntermediatePoint(Long id, String dateOfArrival, Integer indexPostOffice) {
        this.id = id;
        this.dateOfArrival = dateOfArrival;
        this.indexPostOffice = indexPostOffice;
    }

    public IntermediatePoint(Long id, String dateOfArrival, String dateOfDeparture, Integer indexPostOffice) {
        this.id = id;
        this.dateOfArrival = dateOfArrival;
        this.dateOfDeparture = dateOfDeparture;
        this.indexPostOffice = indexPostOffice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(String dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public String getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(String dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public Integer getIndexPostOffice() {
        return indexPostOffice;
    }

    public void setIndexPostOffice(Integer indexPostOffice) {
        this.indexPostOffice = indexPostOffice;
    }
}
