package com.ejemplo.BaseDeDatos;

import java.io.Serializable;

import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;



@Entity
@Table(name = "img_perfil")
public class ImgPerfil implements Serializable{
    private Long id;
    private String link;


    public ImgPerfil() {
    }

    public ImgPerfil(Long id, String link) {
        this.id = id;
        this.link = link;
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
    @Column(name="link", nullable=false)
	public String getLink() {
		return link;
	}
    
	public void setLink(String link) {
		this.link = link;
	}	
}
