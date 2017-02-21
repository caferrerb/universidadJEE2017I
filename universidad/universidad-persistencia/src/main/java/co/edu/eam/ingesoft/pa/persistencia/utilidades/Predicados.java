package co.edu.eam.ingesoft.pa.persistencia.utilidades;

import java.io.Serializable;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Clase con método utilitarios para construir predicados de querys dinamicas.
 * 
 * @author Juan Pablo Ramírez <juan.ramirez.q@gmail.com>
 * 
 */
public final class Predicados implements Serializable {

	/**
	 * Constante para el caracter especial en la query.
	 */
	private static final String STRING = "%";

	/**
	 * Constante de serialización.
	 */
	private static final long serialVersionUID = -7973940750960496555L;

	/**
	 * 
	 * Método encargado de construir un predicado con equals.
	 * 
	 * @param criteriaBuilder
	 *            de la consulta
	 * @param root
	 *            de donde se van a sacar los campos
	 * @param campo
	 *            el cual se va a comparar
	 * @param comparador
	 *            contra quien se compara
	 * @return predicado construido
	 */
	public static Predicate construirPredicado(CriteriaBuilder criteriaBuilder,
			Root<?> root, String campo, Object comparador) {
		return criteriaBuilder.equal(root.get(campo), comparador);
	}

	/**
	 * 
	 * Método encargado de construir un predicado con like.
	 * 
	 * @param criteriaBuilder
	 *            de la consulta
	 * @param root
	 *            de donde se van a sacar los campos para el predicate
	 * @param campo
	 *            el cual se va a comparar
	 * @param comparador
	 *            contra el valor que se compara
	 * @return predicado construido
	 */
	public static Predicate construirPredicadoLike(
			CriteriaBuilder criteriaBuilder, Root<?> root, String campo,
			Object comparador) {
		/* se crea la expresión del lado derecho del string */
		Expression<String> exp1 = criteriaBuilder.upper(root
				.<String> get(campo));
		Expression<String> exp2 = criteriaBuilder.concat(criteriaBuilder
				.upper(criteriaBuilder.literal(comparador.toString())), STRING);

		return criteriaBuilder.like(exp1, exp2);
	}

	/**
	 * Constructor privado de la clase
	 */
	private Predicados() {
	}

}
