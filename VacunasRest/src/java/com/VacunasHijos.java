/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Diana Melgarejo
 */
@Entity
@Table(name = "vacunas_hijos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VacunasHijos.findAll", query = "SELECT v FROM VacunasHijos v")
    , @NamedQuery(name = "VacunasHijos.findByIdVacuna", query = "SELECT v FROM VacunasHijos v WHERE v.vacunasHijosPK.idVacuna = :idVacuna")
    , @NamedQuery(name = "VacunasHijos.findByNroDosis", query = "SELECT v FROM VacunasHijos v WHERE v.vacunasHijosPK.nroDosis = :nroDosis")
    , @NamedQuery(name = "VacunasHijos.findByIdHijo", query = "SELECT v FROM VacunasHijos v WHERE v.vacunasHijosPK.idHijo = :idHijo")
    , @NamedQuery(name = "VacunasHijos.findByFechaProgramada", query = "SELECT v FROM VacunasHijos v WHERE v.fechaProgramada = :fechaProgramada")
    , @NamedQuery(name = "VacunasHijos.findByLote", query = "SELECT v FROM VacunasHijos v WHERE v.lote = :lote")
    , @NamedQuery(name = "VacunasHijos.findByResponsable", query = "SELECT v FROM VacunasHijos v WHERE v.responsable = :responsable")
    , @NamedQuery(name = "VacunasHijos.findByAplicado", query = "SELECT v FROM VacunasHijos v WHERE v.aplicado = :aplicado")
    , @NamedQuery(name = "VacunasHijos.findByFechaAplicacion", query = "SELECT v FROM VacunasHijos v WHERE v.fechaAplicacion = :fechaAplicacion")
    , @NamedQuery(name = "VacunasHijos.findByDiasAtrasoApl", query = "SELECT v FROM VacunasHijos v WHERE v.diasAtrasoApl = :diasAtrasoApl")})
public class VacunasHijos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VacunasHijosPK vacunasHijosPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 19)
    @Column(name = "fecha_programada")
    private String fechaProgramada;
    @Column(name = "lote")
    private String lote;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "responsable")
    private String responsable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "aplicado")
    private int aplicado;
    @Size(min = 1, max = 19)
    @Column(name = "fecha_aplicacion")
    private String fechaAplicacion;
    @Column(name = "dias_atraso_apl")
    private Integer diasAtrasoApl;
    @JoinColumn(name = "id_hijo", referencedColumnName = "id_hijo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Hijo hijo;
    @JoinColumns({
        @JoinColumn(name = "id_vacuna", referencedColumnName = "id_vacuna", insertable = false, updatable = false)
        , @JoinColumn(name = "nro_dosis", referencedColumnName = "nro_dosis", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Vacunas vacunas;

    public VacunasHijos() {
    }

    public VacunasHijos(VacunasHijosPK vacunasHijosPK) {
        this.vacunasHijosPK = vacunasHijosPK;
    }

    public VacunasHijos(VacunasHijosPK vacunasHijosPK, String fechaProgramada, String responsable, int aplicado) {
        this.vacunasHijosPK = vacunasHijosPK;
        this.fechaProgramada = fechaProgramada;
        this.responsable = responsable;
        this.aplicado = aplicado;
    }

    public VacunasHijos(int idVacuna, int nroDosis, int idHijo) {
        this.vacunasHijosPK = new VacunasHijosPK(idVacuna, nroDosis, idHijo);
    }

    public VacunasHijosPK getVacunasHijosPK() {
        return vacunasHijosPK;
    }

    public void setVacunasHijosPK(VacunasHijosPK vacunasHijosPK) {
        this.vacunasHijosPK = vacunasHijosPK;
    }

    public String getFechaProgramada() {
        return fechaProgramada;
    }

    public void setFechaProgramada(String fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public int getAplicado() {
        return aplicado;
    }

    public void setAplicado(int aplicado) {
        this.aplicado = aplicado;
    }

    public String getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(String fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public Integer getDiasAtrasoApl() {
        return diasAtrasoApl;
    }

    public void setDiasAtrasoApl(Integer diasAtrasoApl) {
        this.diasAtrasoApl = diasAtrasoApl;
    }

    public Hijo getHijo() {
        return hijo;
    }

    public void setHijo(Hijo hijo) {
        this.hijo = hijo;
    }

    public Vacunas getVacunas() {
        return vacunas;
    }

    public void setVacunas(Vacunas vacunas) {
        this.vacunas = vacunas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vacunasHijosPK != null ? vacunasHijosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VacunasHijos)) {
            return false;
        }
        VacunasHijos other = (VacunasHijos) object;
        if ((this.vacunasHijosPK == null && other.vacunasHijosPK != null) || (this.vacunasHijosPK != null && !this.vacunasHijosPK.equals(other.vacunasHijosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.VacunasHijos[ vacunasHijosPK=" + vacunasHijosPK + " ]";
    }
    
}
