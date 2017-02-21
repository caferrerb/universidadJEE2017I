package co.edu.eam.ingesoft.pa.persistencia.modelo.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.edu.eam.ingesoft.pa.persistencia.modelo.enumeraciones.TipoJornadaEnum;

@Entity
@Table(name="jornada")
public class Jornada implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	
	@Column
	@Enumerated(EnumType.STRING)
	private TipoJornadaEnum tipo;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "horainicio")
	private Date horaInicio;

	@Temporal(TemporalType.TIME)
	@Column(name = "horafinal")
	private Date horaFinal;

}
