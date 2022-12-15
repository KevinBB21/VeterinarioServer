package net.Verinario.VeterinarioServer.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;

@Entity
@Table(name = "vacuna")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class VacunaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;


    @OneToMany(mappedBy = "vacuna", fetch = FetchType.LAZY)
    private final List<FechaVacEntity> fechasvac;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tipoanimal")
    private TipoAnimalEntity tipoanimal;

    

    public VacunaEntity(Long id, String nombre, List<FechaVacEntity> fechasvac, TipoAnimalEntity tipoanimal) {
        this.id = id;
        this.nombre = nombre;
        this.fechasvac = fechasvac;
        this.tipoanimal = tipoanimal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<FechaVacEntity> getFechasvac() {
        return fechasvac;
    }

    public TipoAnimalEntity getTipoanimal() {
        return tipoanimal;
    }

    public void setTipoanimal(TipoAnimalEntity tipoanimal) {
        this.tipoanimal = tipoanimal;
    }


  /* 
    @PreRemove
    public void nullify() {
        this.citas.forEach(c -> c.setUser(null));
    }
    */
    
}
