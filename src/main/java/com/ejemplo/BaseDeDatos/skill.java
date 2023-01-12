package com.ejemplo.BaseDeDatos;

import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
@Table(name = "skill")
public class skill implements Serializable{
    private Long id;
    private String actitud;
    private String porcentaje;

    public skill() {
    }

    public skill(Long id, String actitud, String porcentaje) {
        this.id = id;
        this.actitud=actitud;
        this.porcentaje=porcentaje;
        }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
		this.id = id;
	}
//other setters and getters
    @Column(name="actitud", nullable=false)
	public String getActitud() {
		return actitud;
	}
    
	public void setActitud(String actitud) {
		this.actitud = actitud;
	}
	
	@Column(name="porcentaje", nullable=false)
	public String getPorcentaje() {
		return porcentaje;
	}
    
	public void setPorcentaje(String porcentaje) {
		this.porcentaje = porcentaje;
	}
}
