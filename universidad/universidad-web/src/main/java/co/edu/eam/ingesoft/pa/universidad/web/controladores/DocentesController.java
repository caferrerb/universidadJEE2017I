package co.edu.eam.ingesoft.pa.universidad.web.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.pa.negocio.beans.DocenteEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.ProgramaEJB;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;
import co.edu.eam.ingesoft.pa.persistencia.modelo.entidades.Docente;
import co.edu.eam.ingesoft.pa.persistencia.modelo.entidades.Programa;

@Named("docenteController")
@ViewScoped
public class DocentesController implements Serializable {

	/**
	 * numero de identificacion del docente
	 */
	private String identificacion;
	/**
	 * nombre del docente
	 */
	private String nombre;
	/**
	 * apellido del docente
	 */
	private String apellido;
	/**
	 * correo del docente
	 */
	private String correo;
	/**
	 * telefono del docente
	 */
	private String telefono;
	/**
	 * codigo del docente
	 */
	private String codigo;
	/**
	 * lista para llenar el combo.
	 */
	private List<Programa> programas;
	/**
	 * programa seleccionado.
	 */
	private Programa programaSeleccionado;

	/**
	 * lista de docente.s
	 */
	private List<Docente> docentes;

	/**
	 * ejb de docente.
	 */
	@EJB
	private DocenteEJB docenteEJB;

	/**
	 * lista de programas.
	 */
	@EJB
	private ProgramaEJB programaEJB;

	/**
	 * metodo de inicializacion
	 */
	@PostConstruct
	public void inicializar() {
		programas = programaEJB.listar();
		docentes = docenteEJB.listar();
	}

	/**
	 * MEtodo para crear un docente.
	 */
	public void crear() {
		try {
			Docente doc = new Docente(identificacion, nombre, apellido, correo, telefono, programaSeleccionado);
			doc.setCodigodocente(codigo);
			docenteEJB.crearDocente(doc);
			// limpiando los campos
			identificacion = "";
			nombre = "";
			apellido = "";
			correo = "";
			telefono = "";
			programaSeleccionado = null;
			codigo = "";
			docentes = docenteEJB.listar();
			
			Messages.addFlashGlobalInfo("Docente Creado exitosamente");
			
		} catch (ExcepcionNegocio e) {
			
			Messages.addGlobalError(e.getMessage());
		}

	}

	/**
	 * MEtodo para buscar un docente.
	 */
	public void buscar() {
		Docente doc = docenteEJB.buscarDocente(identificacion);
		if (doc != null) {

			nombre = doc.getNombre();
			apellido = doc.getApellido();
			correo = doc.getCorreoelectronico();
			telefono = doc.getTelefono();
			programaSeleccionado = doc.getPrograma();
			codigo = doc.getCodigodocente();
			Messages.addFlashGlobalInfo("Docente Encontrado");

		} else {
			Messages.addFlashGlobalWarn("Docente no existe");
		}
	}

	/**
	 * MEtodo para editar un docente.
	 */
	public void editar() {

	}

	/**
	 * @return the identificacion
	 */
	public String getIdentificacion() {
		return identificacion;
	}

	/**
	 * @param identificacion
	 *            the identificacion to set
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido
	 *            the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo
	 *            the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono
	 *            the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the programas
	 */
	public List<Programa> getProgramas() {
		return programas;
	}

	/**
	 * @param programas
	 *            the programas to set
	 */
	public void setProgramas(List<Programa> programas) {
		this.programas = programas;
	}

	/**
	 * @return the programaSeleccionado
	 */
	public Programa getProgramaSeleccionado() {
		return programaSeleccionado;
	}

	/**
	 * @param programaSeleccionado
	 *            the programaSeleccionado to set
	 */
	public void setProgramaSeleccionado(Programa programaSeleccionado) {
		this.programaSeleccionado = programaSeleccionado;
	}

	/**
	 * @return the docentes
	 */
	public List<Docente> getDocentes() {
		return docentes;
	}

}
