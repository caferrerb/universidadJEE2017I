package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.pa.persistencia.modelo.entidades.Facultad;
import co.edu.eam.ingesoft.pa.persistencia.modelo.entidades.Programa;

@LocalBean
@Stateless
public class FacultadEJB {

	@PersistenceContext
	private EntityManager em;

	/**
	 * metodo para listar todos los programas.
	 * 
	 * @return la lista de programas.
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Facultad> listar() {

		return em.createNamedQuery(Facultad.CONSULTA_LISTAR).getResultList();
	}
	
	/**
	 * metodo para buscar.
	 * 
	 * @param codigo
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public Facultad buscar(String codigo) {
		return em.find(Facultad.class, codigo);
	}

}
