package co.edu.eam.ingesoft.standalone.main;

import java.security.Provider.Service;

import javax.naming.NamingException;

import co.edu.eam.ingesoft.pa.negocio.beans.remote.IDocenteRemote;
import co.edu.eam.ingesoft.pa.persistencia.modelo.entidades.Docente;
import co.edu.eam.ingesoft.standalone.gui.vista.Ventana;
import co.edu.eam.ingesoft.standalone.util.ServiceLocator;

public class Main {

	public static void main(String[] args) throws NamingException {
		new Ventana().setVisible(true);

	}

}
