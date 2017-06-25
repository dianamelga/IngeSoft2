/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diana Melgarejo
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
    , @NamedQuery(name = "Hijo.findByMunicipio", query = "SELECT h FROM Hijo h WHERE h.municipio = :municipio")
    , @NamedQuery(name = "Hijo.findByBarrio", query = "SELECT h FROM Hijo h WHERE h.barrio = :barrio")
    , @NamedQuery(name = "Hijo.findByReferencha", query = "SELECT h FROM Hijo h WHERE h.referencha = :referencha")
    , @NamedQuery(name = "Hijo.findByTelefono", query = "SELECT h FROM Hijo h WHERE h.telefono = :telefono")
    , @NamedQuery(name = "Hijo.findBySeguro", query = "SELECT h FROM Hijo h WHERE h.seguro = :seguro")
    , @NamedQuery(name = "Hijo.findByAlergia", query = "SELECT h FROM Hijo h WHERE h.alergia = :alergia")})
public class Hijo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_hijo")
    private Integer idHijo;
    @Column(name = "ci")
    private Integer ci;
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
    @Size(min = 1, max = 40)
    @Column(name = "lugar_nac")
    private String lugarNac;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nac")
    private String fechaNac;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nacionalidad")
    private String nacionalidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "municipio")
    private String municipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "barrio")
    private String barrio;
    @Size(max = 40)
    @Column(name = "referencha")
    private String referencha;
    @Size(max = 40)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 40)
    @Column(name = "seguro")
    private String seguro;
    @Size(max = 40)
    @Column(name = "alergia")
    private String alergia;
    @Size(max = 40)
    @Column(name = "departamento")
    private String departamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "hijo")
    private Collection<VacunasHijos> vacunasHijosCollection;
    @JoinColumn(name = "id_padre", referencedColumnName = "id_padre")
    @ManyToOne(optional = false)
    private Padre idPadre;

    public Hijo() {
    }

    public Hijo(Integer idHijo) {
        this.idHijo = idHijo;
    }

    public Hijo(Integer idHijo, String nombre, String apellido, String lugarNac, String fechaNac, String sexo, String nacionalidad, String direccion, String municipio, String barrio,
            String departamento) {
        this.idHijo = idHijo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.lugarNac = lugarNac;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
        this.direccion = direccion;
        this.municipio = municipio;
        this.barrio = barrio;
        this.departamento = departamento;
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

    public String getLugarNac() {
        return lugarNac;
    }

    public void setLugarNac(String lugarNac) {
        this.lugarNac = lugarNac;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getReferencha() {
        return referencha;
    }

    public void setReferencha(String referencha) {
        this.referencha = referencha;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public String getAlergia() {
        return alergia;
    }

    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }
    
    public String getDepartamento() {
        return departamento;
    }
    
    public void setDepartamento(String departamento){
        this.departamento = departamento;
    }

    @XmlTransient
    public Collection<VacunasHijos> getVacunasHijosCollection() {
        return vacunasHijosCollection;
    }

    public void setVacunasHijosCollection(Collection<VacunasHijos> vacunasHijosCollection) {
        this.vacunasHijosCollection = vacunasHijosCollection;
    }

    public Padre getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Padre idPadre) {
        this.idPadre = idPadre;
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
        return "com.Hijo[ idHijo=" + idHijo + " ]";
    }
    
}
