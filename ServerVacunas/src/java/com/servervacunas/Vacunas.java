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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "vacunas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacunas.findAll", query = "SELECT v FROM Vacunas v")
    , @NamedQuery(name = "Vacunas.findByNombreVacuna", query = "SELECT v FROM Vacunas v WHERE v.nombreVacuna = :nombreVacuna")
    , @NamedQuery(name = "Vacunas.findByEdad", query = "SELECT v FROM Vacunas v WHERE v.edad = :edad")
    , @NamedQuery(name = "Vacunas.findByDosis", query = "SELECT v FROM Vacunas v WHERE v.dosis = :dosis")
    , @NamedQuery(name = "Vacunas.findByFecha", query = "SELECT v FROM Vacunas v WHERE v.fecha = :fecha")
    , @NamedQuery(name = "Vacunas.findByLote", query = "SELECT v FROM Vacunas v WHERE v.lote = :lote")
    , @NamedQuery(name = "Vacunas.findByResponsable", query = "SELECT v FROM Vacunas v WHERE v.responsable = :responsable")
    , @NamedQuery(name = "Vacunas.findByMesAplicacion", query = "SELECT v FROM Vacunas v WHERE v.mesAplicacion = :mesAplicacion")
    , @NamedQuery(name = "Vacunas.findByAplicado", query = "SELECT v FROM Vacunas v WHERE v.aplicado = :aplicado")
    , @NamedQuery(name = "Vacunas.findByFechaAplicacion", query = "SELECT v FROM Vacunas v WHERE v.fechaAplicacion = :fechaAplicacion")
    , @NamedQuery(name = "Vacunas.findByIdVacuna", query = "SELECT v FROM Vacunas v WHERE v.idVacuna = :idVacuna")})
public class Vacunas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "nombre_vacuna")
    private Character nombreVacuna;
    @Column(name = "edad")
    private Character edad;
    @Column(name = "dosis")
    private Integer dosis;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "lote")
    private Character lote;
    @Column(name = "responsable")
    private Character responsable;
    @Column(name = "mes_aplicacion")
    private Integer mesAplicacion;
    @Column(name = "aplicado")
    private Integer aplicado;
    @Column(name = "fecha_aplicacion")
    @Temporal(TemporalType.DATE)
    private Date fechaAplicacion;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_vacuna")
    private Integer idVacuna;
    @JoinColumn(name = "id_hijo", referencedColumnName = "id_hijo")
    @ManyToOne
    private Hijo idHijo;

    public Vacunas() {
    }

    public Vacunas(Integer idVacuna) {
        this.idVacuna = idVacuna;
    }

    public Character getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(Character nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

    public Character getEdad() {
        return edad;
    }

    public void setEdad(Character edad) {
        this.edad = edad;
    }

    public Integer getDosis() {
        return dosis;
    }

    public void setDosis(Integer dosis) {
        this.dosis = dosis;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Character getLote() {
        return lote;
    }

    public void setLote(Character lote) {
        this.lote = lote;
    }

    public Character getResponsable() {
        return responsable;
    }

    public void setResponsable(Character responsable) {
        this.responsable = responsable;
    }

    public Integer getMesAplicacion() {
        return mesAplicacion;
    }

    public void setMesAplicacion(Integer mesAplicacion) {
        this.mesAplicacion = mesAplicacion;
    }

    public Integer getAplicado() {
        return aplicado;
    }

    public void setAplicado(Integer aplicado) {
        this.aplicado = aplicado;
    }

    public Date getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(Date fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public Integer getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(Integer idVacuna) {
        this.idVacuna = idVacuna;
    }

    public Hijo getIdHijo() {
        return idHijo;
    }

    public void setIdHijo(Hijo idHijo) {
        this.idHijo = idHijo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVacuna != null ? idVacuna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacunas)) {
            return false;
        }
        Vacunas other = (Vacunas) object;
        if ((this.idVacuna == null && other.idVacuna != null) || (this.idVacuna != null && !this.idVacuna.equals(other.idVacuna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.servervacunas.Vacunas[ idVacuna=" + idVacuna + " ]";
    }
    
}
