package catalogs;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import business.Product;
import facade.exceptions.ApplicationException;

@Stateless
public class ProductCatalog {
	
	/**
	 * Entity manager for accessing the persistence service 
	 */
	@PersistenceContext
	private EntityManager em;
	
	public Product getProductById(int id) throws ApplicationException {
		Product p = em.find(Product.class, id);
		if (p == null)
			throw new ApplicationException("Product with id " + id + " not found");
		else
			return p;
	}
	
	
	public Product getProduct (int cod) throws ApplicationException {
		TypedQuery<Product> query = em.createNamedQuery(Product.FIND_BY_PRODUCT_CODE, Product.class);
		query.setParameter(Product.PRODUCT_CODE, cod);
		try {
			return query.getSingleResult();
		} catch (PersistenceException e) {
			throw new ApplicationException ("Product not found.");
		}
	}	

}
