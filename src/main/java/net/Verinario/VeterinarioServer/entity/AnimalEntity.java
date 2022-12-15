package net.Verinario.VeterinarioServer.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "animal")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class AnimalEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre_animal;
    private String color;
    private String raza;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime fecha_nac;
    private int vacunado;
    private double peso;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tipoanimal")
    private TipoAnimalEntity tipoanimal;

    @OneToMany(mappedBy = "animal", fetch = FetchType.LAZY)
    private final List<FechaVacEntity> fechasvac;

    @OneToMany(mappedBy = "animal", fetch = FetchType.LAZY)
    private final List<CitaEntity> citas;


    public AnimalEntity() {
        this.citas = new ArrayList<>();
        this.fechasvac = new ArrayList<>();
    }   
    
    
    
    public AnimalEntity(Long id, String nombre_animal, String color, String raza, LocalDateTime fecha_nac, int vacunado,
            double peso, TipoAnimalEntity tipoanimal, List<FechaVacEntity> fechasvac, List<CitaEntity> citas) {
        this.id = id;
        this.nombre_animal = nombre_animal;
        this.color = color;
        this.raza = raza;
        this.fecha_nac = fecha_nac;
        this.vacunado = vacunado;
        this.peso = peso;
        this.tipoanimal = tipoanimal;
        this.fechasvac = fechasvac;
        this.citas = citas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_animal() {
        return nombre_animal;
    }

    public void setNombre_animal(String nombre_animal) {
        this.nombre_animal = nombre_animal;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public LocalDateTime getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(LocalDateTime fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public int getVacunado() {
        return vacunado;
    }

    public void setVacunado(int vacunado) {
        this.vacunado = vacunado;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public TipoAnimalEntity getTipoanimal() {
        return tipoanimal;
    }

    public void setTipoanimal(TipoAnimalEntity tipoanimal) {
        this.tipoanimal = tipoanimal;
    }

    public List<FechaVacEntity> getFechasvac() {
        return fechasvac;
    }

    public List<CitaEntity> getCitas() {
        return citas;
    }



  


/*   
    @PreRemove
    public void nullify() {
        this.citas.forEach(c -> c.setUser(null));
    }

    */
}
