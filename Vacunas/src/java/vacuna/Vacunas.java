/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vacuna;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dianamelgarejo
 */
@Entity
@Table(name = "vacunas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vacunas.findAll", query = "SELECT v FROM Vacunas v")
    , @NamedQuery(name = "Vacunas.findByIdVacuna", query = "SELECT v FROM Vacunas v WHERE v.vacunasPK.idVacuna = :idVacuna")
    , @NamedQuery(name = "Vacunas.findByNroDosis", query = "SELECT v FROM Vacunas v WHERE v.vacunasPK.nroDosis = :nroDosis")
    , @NamedQuery(name = "Vacunas.findByNombreVacuna", query = "SELECT v FROM Vacunas v WHERE v.nombreVacuna = :nombreVacuna")
    , @NamedQuery(name = "Vacunas.findByMesAplicacion", query = "SELECT v FROM Vacunas v WHERE v.mesAplicacion = :mesAplicacion")
    , @NamedQuery(name = "Vacunas.findByCantDosis", query = "SELECT v FROM Vacunas v WHERE v.cantDosis = :cantDosis")})
public class Vacunas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VacunasPK vacunasPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre_vacuna")
    private String nombreVacuna;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mes_aplicacion")
    private int mesAplicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cant_dosis")
    private int cantDosis;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacunas")
    private Collection<VacunasHijos> vacunasHijosCollection;

    public Vacunas() {
    }

    public Vacunas(VacunasPK vacunasPK) {
        this.vacunasPK = vacunasPK;
    }

    public Vacunas(VacunasPK vacunasPK, String nombreVacuna, int mesAplicacion, int cantDosis) {
        this.vacunasPK = vacunasPK;
        this.nombreVacuna = nombreVacuna;
        this.mesAplicacion = mesAplicacion;
        this.cantDosis = cantDosis;
    }

    public Vacunas(int idVacuna, int nroDosis) {
        this.vacunasPK = new VacunasPK(idVacuna, nroDosis);
    }

    public VacunasPK getVacunasPK() {
        return vacunasPK;
    }

    public void setVacunasPK(VacunasPK vacunasPK) {
        this.vacunasPK = vacunasPK;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

    public int getMesAplicacion() {
        return mesAplicacion;
    }

    public void setMesAplicacion(int mesAplicacion) {
        this.mesAplicacion = mesAplicacion;
    }

    public int getCantDosis() {
        return cantDosis;
    }

    public void setCantDosis(int cantDosis) {
        this.cantDosis = cantDosis;
    }

    @XmlTransient
    public Collection<VacunasHijos> getVacunasHijosCollection() {
        return vacunasHijosCollection;
    }

    public void setVacunasHijosCollection(Collection<VacunasHijos> vacunasHijosCollection) {
        this.vacunasHijosCollection = vacunasHijosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vacunasPK != null ? vacunasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacunas)) {
            return false;
        }
        Vacunas other = (Vacunas) object;
        if ((this.vacunasPK == null && other.vacunasPK != null) || (this.vacunasPK != null && !this.vacunasPK.equals(other.vacunasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vacuna.Vacunas[ vacunasPK=" + vacunasPK + " ]";
    }
    
}
