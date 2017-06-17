/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vacuna;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dianamelgarejo
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cedula")
    private int cedula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nac")
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sexo")
    private Character sexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "municipio")
    private String municipio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPadre")
    private Collection<Hijo> hijoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPadre")
    private Collection<Usuarios> usuariosCollection;

    public Padre() {
    }

    public Padre(Integer idPadre) {
        this.idPadre = idPadre;
    }

    public Padre(Integer idPadre, String nombre, String apellido, int cedula, Date fechaNac, Character sexo, String nacionalidad, String municipio) {
        this.idPadre = idPadre;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
        this.municipio = municipio;
    }

    public Integer getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Integer idPadre) {
        this.idPadre = idPadre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
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

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    @XmlTransient
    public Collection<Hijo> getHijoCollection() {
        return hijoCollection;
    }

    public void setHijoCollection(Collection<Hijo> hijoCollection) {
        this.hijoCollection = hijoCollection;
    }

    @XmlTransient
    public Collection<Usuarios> getUsuariosCollection() {
        return usuariosCollection;
    }

    public void setUsuariosCollection(Collection<Usuarios> usuariosCollection) {
        this.usuariosCollection = usuariosCollection;
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
        return "vacuna.Padre[ idPadre=" + idPadre + " ]";
    }
    
}
