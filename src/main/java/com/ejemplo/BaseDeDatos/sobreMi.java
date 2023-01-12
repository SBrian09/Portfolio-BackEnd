package com.ejemplo.BaseDeDatos;

import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
@Table(name = "sobre_mi")
public class sobreMi implements Serializable{
    private Long id;
    private String contenido;


    public sobreMi() {
    }

    public sobreMi(Long id, String contenido) {
        this.id = id;
        this.contenido=contenido;
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
    @Column(name="contenido", nullable=false)
	public String getContenido() {
		return contenido;
	}
    
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
}
