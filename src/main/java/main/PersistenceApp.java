package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entidades.*;

public class PersistenceApp {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceAppPU");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();

//			Cliente cliente = new Cliente("Leonardo", "Puebla", 31241991);
//			Domicilio domicilio = new Domicilio("not found", 5506);
//			cliente.setDomicilio(domicilio);
//			domicilio.setCliente(cliente);
//
//			em.persist(cliente);
			Domicilio dom = em.find(Domicilio.class, 1L);
			Cliente cliente = em.find(Cliente.class, 1L);

			System.out.println("Cliente de domicilio: " + dom.getCliente().getDni());
			System.out.println("Domicilio cliente: " + cliente.getDomicilio().getNombreCalle());
			em.flush();

			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			ex.printStackTrace();
		}

		em.close();
		emf.close();

	}

}
