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

			Factura factura1 = new Factura();
			factura1.setNumero(7);
			factura1.setFecha("22/06/2024");

			Domicilio dom = new Domicilio("San Martin", 1002);
			Cliente cliente = new Cliente("Juan", "Perez", 21412418);

			cliente.setDomicilio(dom);
			dom.setCliente(cliente);

			factura1.setCliente(cliente);

			Categoria perecederos = new Categoria("Perecedero");
			Categoria lacteos = new Categoria("Lacteos");
			Categoria limpieza = new Categoria("Limpieza");

			Articulo articulo1 = new Articulo(200, "Yogurt Ser sabor frutilla", 3500);
			Articulo articulo2 = new Articulo(300, "Detergente Magistral", 1800);

			articulo1.getCategorias().add(perecederos);
			articulo2.getCategorias().add(lacteos);
			lacteos.getArticulos().add(articulo1);
			perecederos.getArticulos().add(articulo2);

			articulo2.getCategorias().add(limpieza);
			limpieza.getArticulos().add(articulo2);

			DetalleFactura det1 = new DetalleFactura();
			det1.setArticulo(articulo1);
			det1.setCantidad(2);
			det1.setSubtotal(7000);

			articulo1.getDetalles().add(det1);
			factura1.getDetalles().add(det1);
			det1.setFactura(factura1);

			DetalleFactura det2 = new DetalleFactura();
			det2.setArticulo(articulo2);
			det2.setCantidad(1);
			det2.setSubtotal(1800);

			articulo2.getDetalles().add(det2);
			factura1.getDetalles().add(det2);
			det2.setFactura(factura1);

			factura1.setTotal(8800);

			em.persist(factura1);

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
