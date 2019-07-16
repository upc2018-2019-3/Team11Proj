package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TChuku;

/**
 * A data access object (DAO) providing persistence and search support for
 * TChuku entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.TChuku
 * @author MyEclipse Persistence Tools
 */

public class TChukuDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TChukuDAO.class);
	// property constants
	public static final String GOODS_ID = "goodsId";
	public static final String SHULIANG = "shuliang";
	public static final String SHIJIAN = "shijian";
	public static final String BEIZHU = "beizhu";
	public static final String BUMEN_ID = "bumenId";

	protected void initDao() {
		// do nothing
	}

	public void save(TChuku transientInstance) {
		log.debug("saving TChuku instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TChuku persistentInstance) {
		log.debug("deleting TChuku instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TChuku findById(java.lang.Integer id) {
		log.debug("getting TChuku instance with id: " + id);
		try {
			TChuku instance = (TChuku) getHibernateTemplate().get(
					"com.model.TChuku", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TChuku instance) {
		log.debug("finding TChuku instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TChuku instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TChuku as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByGoodsId(Object goodsId) {
		return findByProperty(GOODS_ID, goodsId);
	}

	public List findByShuliang(Object shuliang) {
		return findByProperty(SHULIANG, shuliang);
	}

	public List findByShijian(Object shijian) {
		return findByProperty(SHIJIAN, shijian);
	}

	public List findByBeizhu(Object beizhu) {
		return findByProperty(BEIZHU, beizhu);
	}

	public List findByBumenId(Object bumenId) {
		return findByProperty(BUMEN_ID, bumenId);
	}

	public List findAll() {
		log.debug("finding all TChuku instances");
		try {
			String queryString = "from TChuku";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TChuku merge(TChuku detachedInstance) {
		log.debug("merging TChuku instance");
		try {
			TChuku result = (TChuku) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TChuku instance) {
		log.debug("attaching dirty TChuku instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TChuku instance) {
		log.debug("attaching clean TChuku instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TChukuDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TChukuDAO) ctx.getBean("TChukuDAO");
	}
}