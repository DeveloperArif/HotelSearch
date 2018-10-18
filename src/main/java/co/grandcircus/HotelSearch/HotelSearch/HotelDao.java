package co.grandcircus.HotelSearch.HotelSearch;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class HotelDao {
	
	@PersistenceContext
	EntityManager em;
	
	public List<Hotel> findAll() {
		return em.createQuery("FROM Hotel", Hotel.class).getResultList();
	}
	
	public Set<String> getCityCategories() {
		List<String> cityList = em.createQuery("SELECT DISTINCT city from Hotel", String.class).getResultList();
		return new TreeSet<>(cityList); 
	}
	
	public List<Hotel> findbyCity(String city) {
		return em.createQuery("FROM Hotel WHERE city LIKE:ci",Hotel.class).setParameter("ci","%"+ city+"%").getResultList();
	}
	

}
