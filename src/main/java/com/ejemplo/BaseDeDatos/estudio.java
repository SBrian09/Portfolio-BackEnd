package com.ejemplo.BaseDeDatos;



import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
@Table(name = "estudio")
public class estudio{
    private Long id;
    private String titulo;
    private String inicio;
    private String fin;
    private String descripcion;
    private String img;


    public estudio() {
    }

    public estudio(Long id, String titulo, String inicio, String fin, String descripcion, String img) {
        this.id = id;
        this.titulo=titulo;
        this.inicio=inicio;
        this.fin=fin;
        this.descripcion=descripcion;
        this.img=img;
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
    @Column(name="titulo", nullable=false)
	public String getTitulo() {
		return titulo;
	}
    
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	@Column(name="inicio", nullable=false)
	public String getInicio() {
		return inicio;
	}
    
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	@Column(name="fin", nullable=false)
	public String getFin() {
		return fin;
	}
    
	public void setFin(String fin) {
		this.fin = fin;
	}
	@Column(name="descripcion", nullable=false)
	public String getDescripcion() {
		return descripcion;
	}
    
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Column(name="img", nullable=false)
	public String getImg() {
		return img;
	}
    
	public void setImg(String img) {
		this.img = img;
	}
}