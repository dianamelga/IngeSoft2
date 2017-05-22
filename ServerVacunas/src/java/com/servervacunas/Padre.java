/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servervacunas;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adriana
 */
@Entity
@Table(name = "padre")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Padre.findAll", query = "SELECT p FROM Padre p")
    , @NamedQuery(name = "Padre.findByIdPadre", query = "SELECT p FROM Padre p WHERE p.idPadre = :idPadre")
    , @NamedQuery(name = "Padre.findByNombre", query = "SELECT p FROM Padre p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Padre.findByApellido", query = "SELECT p FROM Padre p WHERE p.apellido = :apellido")
    , @NamedQuery(name = "Padre.findByCedula", query = "SELECT p FROM Padre p WHERE p.cedula = :cedula")
    , @NamedQuery(name = "Padre.findByFechaNac", query = "SELECT p FROM Padre p WHERE p.fechaNac = :fechaNac")
    , @NamedQuery(name = "Padre.findBySexo", query = "SELECT p FROM Padre p WHERE p.sexo = :sexo")
    , @NamedQuery(name = "Padre.findByNacionalidad", query = "SELECT p FROM Padre p WHERE p.nacionalidad = :nacionalidad")
    , @NamedQuery(name = "Padre.findByMunicipio", query = "SELECT p FROM Padre p WHERE p.municipio = :municipio")})
public class Padre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_padre")
    private Integer idPadre;
    @Column(name = "nombre")
    private Character nombre;
    @Column(name = "apellido")
    private Character apellido;
    @Column(name = "cedula")
    private Integer cedula;
    @Column(name = "fechaNac")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    @Column(name = "sexo")
    private Character sexo;
    @Column(name = "nacionalidad")
    private Character nacionalidad;
    @Column(name = "municipio")
    private Character municipio;

    public Padre() {
    }

    public Padre(Integer idPadre) {
        this.idPadre = idPadre;
    }

    public Integer getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Integer idPadre) {
        this.idPadre = idPadre;
    }

    public Character getNombre() {
        return nombre;
    }

    public void setNombre(Character nombre) {
        this.nombre = nombre;
    }

    public Character getApellido() {
        return apellido;
    }

    public void setApellido(Character apellido) {
        this.apellido = apellido;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Character getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Character nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Character getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Character municipio) {
        this.municipio = municipio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPadre != null ? idPadre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Padre)) {
            return false;
        }
        Padre other = (Padre) object;
        if ((this.idPadre == null && other.idPadre != null) || (this.idPadre != null && !this.idPadre.equals(other.idPadre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.servervacunas.Padre[ idPadre=" + idPadre + " ]";
    }
    
}
