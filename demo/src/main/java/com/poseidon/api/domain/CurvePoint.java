package com.poseidon.api.domain;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "curve_point")
public class CurvePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "curveId")
    private Integer CurveId;
    @Column(name = "asOfDate")
    private Timestamp asOfDate;
    @Column(name = "term")
    private Double term;
    @Column(name = "value")
    private Double value;
    @Column(name = "creationDate")
    private Timestamp creationDate;

    public CurvePoint() {
    }

    public CurvePoint(Integer id, Double term, Double value) {
        this.id = id;
        this.term = term;
        this.value = value;
    }

    public CurvePoint(Integer curveId, Timestamp asOfDate, Double term, Double value, Timestamp creationDate) {
        CurveId = curveId;
        this.asOfDate = asOfDate;
        this.term = term;
        this.value = value;
        this.creationDate = creationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCurveId() {
        return CurveId;
    }

    public void setCurveId(Integer curveId) {
        CurveId = curveId;
    }

    public Timestamp getAsOfDate() {
        return asOfDate;
    }

    public void setAsOfDate(Timestamp asOfDate) {
        this.asOfDate = asOfDate;
    }

    public Double getTerm() {
        return term;
    }

    public void setTerm(Double term) {
        this.term = term;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "CurvePoint{" +
                "id=" + id +
                ", CurveId=" + CurveId +
                ", asOfDate=" + asOfDate +
                ", term=" + term +
                ", value=" + value +
                ", creationDate=" + creationDate +
                '}';
    }
}
