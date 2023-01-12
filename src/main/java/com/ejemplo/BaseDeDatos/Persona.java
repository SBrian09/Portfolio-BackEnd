/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.BaseDeDatos;




import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
@Table(name = "persona")
public class Persona implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
    private String nombre;
    private String apellido;
    private String puesto;
    private String nacionalidad;

    public Persona() {
    }

    public Persona(Long id, String nombre, String apellido, String puesto, String nacionalidad) {
        this.id = id;
        this.nombre=nombre;
        this.apellido=apellido;
        this.puesto=puesto;
        this.nacionalidad=nacionalidad;
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
    @Column(name="nombre", nullable=false)
	public String getNombre() {
		return nombre;
	}
    
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Column(name="apellido", nullable=false)
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	@Column(name="puesto", nullable=false)
	public String getPuesto() {
		return puesto;
	}
    
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	@Column(name="nacionalidad", nullable=false)
	public String getNacionalidad() {
		return nacionalidad;
	}
    
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
}