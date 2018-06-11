package com.mitocode.springbd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.mitocode.beans.Marca;
import com.mitocode.service.ServiceMarca;
import com.mitocode.service.ServiceMarcaImpl;

@Component
public class App {

//	//Forma 2: Con @Autowired
//	 @Autowired
//	 public App(ServiceMarca mar) {
////	 public App(ServiceMarca mar, Marca marca) {
//		 
//		 try {
//			 mar.registrar(new Marca("Reebok"));
////			 mar.registrar(marca);
//			 System.out.println("Éxito al insertar. Forma 2.");
//		} catch (Exception e) {
//			System.out.println("Excepción: " + e.getMessage());
//		}
//	 }

	public static void main(String[] args) {

		try {
			//Forma 1: Con "getBean"
			ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
			
			ServiceMarca sm = (ServiceMarca) appContext.getBean("serviceMarcaImpl");
			sm.registrar(new Marca("New Balance"));
			
//			sm.registrar((Marca) appContext.getBean("marca"));
			System.out.println("Éxito al insertar. Forma 1.");

//			//Forma 2: 
//			ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
			
		} catch (Exception e) {
			System.out.println("Excepción: " + e.getMessage());
		}

	}

}
