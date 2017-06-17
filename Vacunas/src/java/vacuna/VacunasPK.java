/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vacuna;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author dianamelgarejo
 */
@Embeddable
public class VacunasPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id_vacuna")
    private int idVacuna;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_dosis")
    private int nroDosis;

    public VacunasPK() {
    }

    public VacunasPK(int idVacuna, int nroDosis) {
        this.idVacuna = idVacuna;
        this.nroDosis = nroDosis;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idVacuna;
        hash += (int) nroDosis;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VacunasPK)) {
            return false;
        }
        VacunasPK other = (VacunasPK) object;
        if (this.idVacuna != other.idVacuna) {
            return false;
        }
        if (this.nroDosis != other.nroDosis) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vacuna.VacunasPK[ idVacuna=" + idVacuna + ", nroDosis=" + nroDosis + " ]";
    }
    
}
