package co.edu.eam.ingesoft.pa2.banco.negocio;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.eam.ingesoft.pa2.banco.persistencia.util.DAOGenerico;

/**
 * Bean generico para todos los objetos de negocio.
 * 
 * @author Camilo Andres Ferrer Bustos.
 *
 * @param <T>
 */
public abstract class EJBGenerico<T> {

	/**
	 * Entitymanager.
	 */
	@PersistenceContext
	protected transient EntityManager em;

	/**
	 * usuario en sesion.
	 */
	private String usuario;

	/**
	 * clase que administra este bean.
	 */
	private Class<T> clase;

	/**
	 * dao por medio del cual se hacen las operaciones a la BD a traves del
	 * Entitymanager.
	 */
	protected DAOGenerico dao;

	/**
	 * Metodo para inicializar el Bean.
	 * 
	 * @author Camilo Andres Ferrer Bustos.
	 */
	@PostConstruct
	public void initBean() {
		dao = new DAOGenerico(em);
		init();
	}

	/**
	 * Metodo para ser sobreescrito por las clases de las que hereden esta para
	 * la inicializacion de sus parametros.
	 * 
	 * @author Camilo Andres Ferrer Bustos.
	 */
	public abstract void init();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.telefonica.rfe.servicios.interfaces.IBean#crear(java.lang.Object)
	 */

	public void crear(T entidad)  {
		dao.persistir(entidad);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.telefonica.rfe.servicios.interfaces.IBean#buscar(java.lang.Object)
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public T buscar(Object pk) {
		return dao.encontrarPorId(clase, pk);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.telefonica.rfe.servicios.interfaces.IBean#editar(java.lang.Object)
	 */

	public void editar(T entidad)  {
		dao.actualizar(entidad);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.telefonica.rfe.servicios.interfaces.IBean#eliminar(java.lang.
	 * Object)
	 */

	public void eliminar(Object pk) {
		dao.eliminar(clase, pk);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.telefonica.rfe.servicios.interfaces.IBean#listar()
	 */
	@SuppressWarnings("unchecked")
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<T> listar() {
		Query q = em.createQuery("SELECT o FROM " + clase.getSimpleName() + " o");
		return q.getResultList();
	}

	/**
	 * @return the em
	 */
	public EntityManager getEm() {
		return em;
	}

	/**
	 * @param em
	 *            the em to set
	 */
	public void setEm(EntityManager em) {
		this.em = em;
		dao = new DAOGenerico(em);
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
		if (dao != null) {
			dao.setUsuario(usuario);
		} else {
			dao = new DAOGenerico(em);
			dao.setUsuario(usuario);

		}
	}

	/**
	 * setter del atributo clase.
	 * 
	 * @param clase
	 */
	public void setClase(Class<T> clase) {
		this.clase = clase;
	}

}
