/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vacuna.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;
import vacuna.Vacunas;
import vacuna.VacunasHijos;
import vacuna.VacunasHijosPK;

/**
 *
 * @author dianamelgarejo
 */
@Stateless
@Path("vacuna.vacunashijos")
public class VacunasHijosFacadeREST extends AbstractFacade<VacunasHijos> {

    @PersistenceContext(unitName = "VacunasPU")
    private EntityManager em;

    private VacunasHijosPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idVacuna=idVacunaValue;nroDosis=nroDosisValue;idHijo=idHijoValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        vacuna.VacunasHijosPK key = new vacuna.VacunasHijosPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idVacuna = map.get("idVacuna");
        if (idVacuna != null && !idVacuna.isEmpty()) {
            key.setIdVacuna(new java.lang.Integer(idVacuna.get(0)));
        }
        java.util.List<String> nroDosis = map.get("nroDosis");
        if (nroDosis != null && !nroDosis.isEmpty()) {
            key.setNroDosis(new java.lang.Integer(nroDosis.get(0)));
        }
        java.util.List<String> idHijo = map.get("idHijo");
        if (idHijo != null && !idHijo.isEmpty()) {
            key.setIdHijo(new java.lang.Integer(idHijo.get(0)));
        }
        return key;
    }

    public VacunasHijosFacadeREST() {
        super(VacunasHijos.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(VacunasHijos entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, VacunasHijos entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        vacuna.VacunasHijosPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public VacunasHijos find(@PathParam("id") PathSegment id) {
        vacuna.VacunasHijosPK key = getPrimaryKey(id);
        return super.find(key);
    }

    
    
    // metodos hechos a manopla
    @GET
    @Path("/vacunas/{idh}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Vacunas> findVacunas(@PathParam("idh") int idh) {
        List<Vacunas> l;
        l = getEntityManager()
                    .createQuery("SELECT u FROM VacunasHijos u WHERE u.vacunasHijosPK.idHijo  = :idh")
                    .setParameter("idh", idh).getResultList();
        
        return l;
    }
    
    @GET
    @Path("/vacunasnoapl/{idh}/{apl}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Vacunas> findVacunasNoApl(@PathParam("idh") int idh, @PathParam("apl") int apl) {
        List<Vacunas> l;
        Query q = getEntityManager()
                    .createQuery("SELECT u FROM VacunasHijos u WHERE "
                            + "u.vacunasHijosPK.idHijo = :idh AND u.aplicado = :apl")
                    .setParameter("idh", idh);
        l = q.setParameter("apl", apl).getResultList();
        return l;
    }
      
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<VacunasHijos> findAll() {
        return super.findAll();
    }

    
    
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<VacunasHijos> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
