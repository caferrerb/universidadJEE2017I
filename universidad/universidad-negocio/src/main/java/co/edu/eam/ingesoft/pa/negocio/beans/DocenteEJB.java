package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.pa.negocio.beans.remote.IDocenteRemote;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa.persistencia.modelo.entidades.Docente;

@LocalBean
@Stateless
@Remote(IDocenteRemote.class)
public class DocenteEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	
	/**
	 * MEtodo para crear un docente...
	 * @param doc
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearDocente(Docente doc){
		
		Docente busc=buscarDocente(doc.getDocumentoidentificacion());
		//no existe, se puede crear...
		if(busc==null){
			em.persist(doc);
		}else{
			throw new ExcepcionNegocio("Ya existe el docente");
		}
		
	}
	
	/**
	 * MEtodo para borrar un docente...
	 * @param doc
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void editarDocente(Docente doc){
		
		em.merge(doc);
	}
	
	/**
	 * MEtodo para borrar un docente...
	 * @param doc
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void borrarDocente(Docente doc){
		doc=buscarDocente(doc.getDocumentoidentificacion());
		em.remove(doc);
	}
	
	/**
	 * MEtodo para buscar un docente.
	 * @param documentoidentificacion
	 * @return el docente.
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Docente buscarDocente(String documentoidentificacion){
		return em.find(Docente.class, documentoidentificacion);
	}
	
	/**
	 * metodo para listar todos los docentes
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Docente> listar(){
		return em.createNamedQuery(Docente.LISTAR).getResultList();
	}

}
