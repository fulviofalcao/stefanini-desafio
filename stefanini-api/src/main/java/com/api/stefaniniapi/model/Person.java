package com.api.stefaniniapi.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "person")
public class Person {

    private long id;
    private String fullName;
    private String gender;
    private String emailId;
    private Date dateBirth;
    private String placeBirth;
    private String nationality;
    private String cpf;
    private Date dateRegis;
    private Date dateUpdate;


    public Person() {
    }

    public Person(String fullName, String gender, String emailId, Date dateBirth, String placeBirth, String nationality, String cpf, Date dateRegis, Date dateUpdate) {
        this.fullName = fullName;
        this.gender = gender;
        this.emailId = emailId;
        this.dateBirth = dateBirth;
        this.placeBirth = placeBirth;
        this.nationality = nationality;
        this.cpf = cpf;
        this.dateRegis = dateRegis;
        this.dateUpdate = dateUpdate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "full_name", nullable = false)
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "gender", nullable = false)
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column(name = "email_address", nullable = false)
    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Column(name = "dateBirth", nullable = false)
    public Date getDateBirth() {
        return dateBirth;
    }
    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    @Column(name = "placeBirth", nullable = false)
    public String getPlaceBirth() {
        return placeBirth;
    }
    public void setPlaceBirth(String placeBirth) {
        this.placeBirth = placeBirth;
    }

    @Column(name = "nationality", nullable = false)
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Column(name = "cpf", nullable = false)
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Column(name = "dateRegis", nullable = false)
    public Date getDateRegis() {
        return dateRegis;
    }
    public void setDateRegis(Date dateRegis) {
        this.dateRegis = dateRegis;
    }

    @Column(name = "dateUpdate")
    public Date getDateUpdate() {
        return dateUpdate;
    }
    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", emailId='" + emailId + '\'' +
                ", dateBirth=" + dateBirth +
                ", placeBirth='" + placeBirth + '\'' +
                ", nationality='" + nationality + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dateRegis=" + dateRegis +
                ", dateUpdate=" + dateUpdate +
                '}';
    }
}
