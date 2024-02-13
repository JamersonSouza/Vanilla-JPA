package tech.jamersondev.loja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private final static EntityManagerFactory FACTORY = 		
			Persistence.createEntityManagerFactory("configJpa");
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
	
}
