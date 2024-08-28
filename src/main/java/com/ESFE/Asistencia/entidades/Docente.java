package com.ESFE.Asistencia.entidades;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "docentes")
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Ingrese el nombre del docente")
    private String nombre;

    @NotBlank(message = "El apellido es requerido")
    private String apellido;

    @NotBlank(message = "El email es requerido")
    private String email;

    @NotNull
    private Integer telefono;

    @NotNull
    private String escuela;

    @ManyToMany
    @JoinTable(
            name = "docentes_grupos",
            joinColumns = @JoinColumn(name = "docente_id"),
            inverseJoinColumns = @JoinColumn(name = "grupo_id")
    )
    private Set<Grupo> grupos = new HashSet<>();

    public Set<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(Set<Grupo> grupos) {
        this.grupos = grupos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "Ingrese el nombre del docente") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "Ingrese el nombre del docente") String nombre) {
        this.nombre = nombre;
    }

    public @NotBlank(message = "El apellido es requerido") String getApellido() {
        return apellido;
    }

    public void setApellido(@NotBlank(message = "El apellido es requerido") String apellido) {
        this.apellido = apellido;
    }

    public @NotBlank(message = "El email es requerido") @Email(message = "La estrada no corresponde a un email valido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "El email es requerido") @Email(message = "La estrada no corresponde a un email valido") String email) {
        this.email = email;
    }

    public @NotNull(message = "El teléfono es requerido") Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(@NotNull(message = "El teléfono es requerido") Integer telefono) {
        this.telefono = telefono;
    }

    public @NotNull(message = "El nombre de la escuela es requerido") String getEscuela() {
        return escuela;
    }

    public void setEscuela(@NotNull(message = "El nombre de la escuela es requerido") String escuela) {
        this.escuela = escuela;
    }
}


