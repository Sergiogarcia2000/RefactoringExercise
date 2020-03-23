package com.gmq.entornos.refactoring.exercice;

import java.util.List;

/**
 * 
 * Dada la siguiente clase:
 * 
 * 	1.- Lee el código y crea los tests de junit necesarios
 * 		1.1.- Sigue las indicaciones de la asignatura buscando la máxima cobertura posible
 * 
 * 	2.- Realiza las correcciones que veas necesarias para mejorar la calidad del código.
 *  	2.1.- Añade un comentario en el código explicando el cambio que has realizado
 *  
 * @author Raul.Camarero
 *
 */
public class Evaluate {

	// ENCAPSULAMIENTO DE TODOS LOS ATRIBUTOS DE CLASE

	private String id;
	
	private String name;

	// CAMBIAR EL ESTILO DE DECLARAR UN ARRAY
	private String[] evaluations;

	private int lastEvaluation = 0;
	
	// CAMBIADO EL ORDEN DE LOS CONSTRUCTORES POR ORDEN CRECIENTE DE ARGUMENTOS
	public Evaluate(String id, String name) {
		this.id = id;
		this.name = name;
		this.evaluations = new String[6];
	}

	public Evaluate(String id, String name, String[] evaluations) { 
		this.id = id;
		this.name = name;
		this.evaluations = evaluations;
	}
	
	public String getLastEvaluation() {
		return this.evaluations[lastEvaluation - 1];
	}

	public void evaluate_pupil(int value) {  
		String annotation = null;

		/* HE CAMBIADO COMPLETAMENTE EL SISTEMA DE COMPROBACIONES YA QUE EL ANTERIOR ME PARECÍA MUY LIOSO Y MAL PLANTEADO
		 * EN PRIMER LUGAR HE JUNTADO TODAS LAS COMPROBACIONES EN UNA SOLA CADENA DE IF NO COMO PREVIAMENTE QUE ESTABAN SEPARADOS
		 * EN SEGUNDO LUGAR HE AÑADIDO TAN SOLO UNA COMPROBACIÓN POR IF YA QUE ES MÁS QUE SUFICIENTE
		 * EN TERCER LUGAR HE CAMBIADO LOS VALORES QUE SE LE ASIGNAN A LA VARIABLE YA QUE UNOS ESTABAN EN MAYÚSCULAS OTROS EN MINÚSCULAS Y OTROS EN INGLÉS
		 */
		if (value < 5){
			annotation = "SUSPENSO";
		}else if (value <= 6){
			annotation = "BIEN";
		}else if (value <= 8){
			annotation = "NOTABLE";
		}else if (value <= 10){
			annotation = "SOBRESALIENTE";
		}else {
			throw new RuntimeException("La nota no es válida. Nadie saca más de 10!!!");
		}

		for (int i = 0; i < evaluations.length; i++) {
			if(evaluations[i] == null) {
				evaluations[i] = annotation;
				lastEvaluation++;
				// ELIMINADO EL TO STRING YA QUE ES INNECESARIO EN UN PRINTLN
				System.out.println("Añadir al alumno " + name + "(" + id + ") la nota "+evaluations[i]);
				break;
			}
		}
	}
}
