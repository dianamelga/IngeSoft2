/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Diana Melgarejo
 */
@Embeddable
public class VacunasHijosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_vacuna")
    private int idVacuna;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_dosis")
    private int nroDosis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_hijo")
    private int idHijo;

    public VacunasHijosPK() {
    }

    public VacunasHijosPK(int idVacuna, int nroDosis, int idHijo) {
        this.idVacuna = idVacuna;
        this.nroDosis = nroDosis;
        this.idHijo = idHijo;
    }

    public int getIdVacuna() {
        return idVacuna;
    }

    public void setIdVacuna(int idVacuna) {
        this.idVacuna = idVacuna;
    }

    public int getNroDosis() {
        return nroDosis;
    }

    public void setNroDosis(int nroDosis) {
        this.nroDosis = nroDosis;
    }

    public int getIdHijo() {
        return idHijo;
    }

    public void setIdHijo(int idHijo) {
        this.idHijo = idHijo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idVacuna;
        hash += (int) nroDosis;
        hash += (int) idHijo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VacunasHijosPK)) {
            return false;
        }
        VacunasHijosPK other = (VacunasHijosPK) object;
        if (this.idVacuna != other.idVacuna) {
            return false;
        }
        if (this.nroDosis != other.nroDosis) {
            return false;
        }
        if (this.idHijo != other.idHijo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.VacunasHijosPK[ idVacuna=" + idVacuna + ", nroDosis=" + nroDosis + ", idHijo=" + idHijo + " ]";
    }
    
}
