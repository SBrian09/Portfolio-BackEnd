package com.ejemplo.BaseDeDatos;

import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
@Table(name = "proyectos")
public class proyectos implements Serializable{
    private Long id;
    private String proyecto;
    private String descripcion;

    public proyectos() {
    }

    public proyectos(Long id, String proyecto, String descripcion) {
        this.id = id;
        this.proyecto=proyecto;
        this.descripcion=descripcion;
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
    @Column(name="proyecto", nullable=false)
	public String getProyecto() {
		return proyecto;
	}
    
	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}
	
	@Column(name="descripcion", nullable=false)
	public String getDescripcion() {
		return descripcion;
	}
    
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
