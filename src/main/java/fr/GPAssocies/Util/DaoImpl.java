package fr.GPAssocies.Util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoImpl<T> implements Dao<T> {
	// définir logger log4j
	private final Logger logger = LoggerFactory.getLogger(DaoImpl.class);

	// recup bean SessionFactory défini dans context par modificateurs(setters)
	@Autowired
	protected SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void create(T obj) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(obj);
		logger.info("Add " + obj);
	}

	public void update(T obj) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(obj);
		logger.info("Update " + obj);
	}

	public void delete(T obj) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(obj);
		logger.info("Delete " + obj);
	}
	
	public double round(double value) {
	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(2, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}

	public double calculmontantTtc(double montantHt, double tauxTva) {
		double montantTtc = montantHt * (1 + tauxTva / 100);
		return round(montantTtc);
	}

	public LocalDate strToDate(String dateStr) {
		DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/yy");
		LocalDate date = dtf.parseLocalDate(dateStr);
		return date;
	}

	public String dateToStr(LocalDate date) {
		DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/yy");
		String dateStr = dtf.print(date);
		return dateStr;
	}

}
