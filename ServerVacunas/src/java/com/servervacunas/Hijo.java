/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servervacunas;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adriana
 */
@Entity
@Table(name = "hijo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hijo.findAll", query = "SELECT h FROM Hijo h")
    , @NamedQuery(name = "Hijo.findByIdHijo", query = "SELECT h FROM Hijo h WHERE h.idHijo = :idHijo")
    , @NamedQuery(name = "Hijo.findByCi", query = "SELECT h FROM Hijo h WHERE h.ci = :ci")
    , @NamedQuery(name = "Hijo.findByNombre", query = "SELECT h FROM Hijo h WHERE h.nombre = :nombre")
    , @NamedQuery(name = "Hijo.findByApellido", query = "SELECT h FROM Hijo h WHERE h.apellido = :apellido")
    , @NamedQuery(name = "Hijo.findByLugarNac", query = "SELECT h FROM Hijo h WHERE h.lugarNac = :lugarNac")
    , @NamedQuery(name = "Hijo.findByFechaNac", query = "SELECT h FROM Hijo h WHERE h.fechaNac = :fechaNac")
    , @NamedQuery(name = "Hijo.findBySexo", query = "SELECT h FROM Hijo h WHERE h.sexo = :sexo")
    , @NamedQuery(name = "Hijo.findByNacionalidad", query = "SELECT h FROM Hijo h WHERE h.nacionalidad = :nacionalidad")
    , @NamedQuery(name = "Hijo.findByDireccion", query = "SELECT h FROM Hijo h WHERE h.direccion = :direccion")
    , @NamedQuery(name = "Hijo.findByMunicipio", query = "SELECT h FROM Hijo h WHERE h.municipio = :municipio")})
public class Hijo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_hijo")
    private Integer idHijo;
    @Column(name = "ci")
    private Integer ci;
    @Column(name = "nombre")
    private Character nombre;
    @Column(name = "apellido")
    private Character apellido;
    @Column(name = "lugarNac")
    private Character lugarNac;
    @Column(name = "fechaNac")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    @Column(name = "sexo")
    private Character sexo;
    @Column(name = "nacionalidad")
    private Character nacionalidad;
    @Column(name = "direccion")
    private Character direccion;
    @Column(name = "municipio")
    private Character municipio;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne
    private Usuarios idUsuario;
    @OneToMany(mappedBy = "idHijo")
    private Collection<Vacunas> vacunasCollection;

    public Hijo() {
    }

    public Hijo(Integer idHijo) {
        this.idHijo = idHijo;
    }

    public Integer getIdHijo() {
        return idHijo;
    }

    public void setIdHijo(Integer idHijo) {
        this.idHijo = idHijo;
    }

    public Integer getCi() {
        return ci;
    }

    public void setCi(Integer ci) {
        this.ci = ci;
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

    public Character getLugarNac() {
        return lugarNac;
    }

    public void setLugarNac(Character lugarNac) {
        this.lugarNac = lugarNac;
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

    public Character getDireccion() {
        return direccion;
    }

    public void setDireccion(Character direccion) {
        this.direccion = direccion;
    }

    public Character getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Character municipio) {
        this.municipio = municipio;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public Collection<Vacunas> getVacunasCollection() {
        return vacunasCollection;
    }

    public void setVacunasCollection(Collection<Vacunas> vacunasCollection) {
        this.vacunasCollection = vacunasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHijo != null ? idHijo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hijo)) {
            return false;
        }
        Hijo other = (Hijo) object;
        if ((this.idHijo == null && other.idHijo != null) || (this.idHijo != null && !this.idHijo.equals(other.idHijo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.servervacunas.Hijo[ idHijo=" + idHijo + " ]";
    }
    
}
