package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TBaosun;

/**
 * A data access object (DAO) providing persistence and search support for
 * TBaosun entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.TBaosun
 * @author MyEclipse Persistence Tools
 */

public class TBaosunDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TBaosunDAO.class);
	// property constants
	public static final String GOODS_ID = "goodsId";
	public static final String SHULIANG = "shuliang";
	public static final String SHIJIAN = "shijian";
	public static final String BEIZHU = "beizhu";

	protected void initDao() {
		// do nothing
	}

	public void save(TBaosun transientInstance) {
		log.debug("saving TBaosun instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TBaosun persistentInstance) {
		log.debug("deleting TBaosun instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TBaosun findById(java.lang.Integer id) {
		log.debug("getting TBaosun instance with id: " + id);
		try {
			TBaosun instance = (TBaosun) getHibernateTemplate().get(
					"com.model.TBaosun", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TBaosun instance) {
		log.debug("finding TBaosun instance by example");
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
		log.debug("finding TBaosun instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TBaosun as model where model."
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

	public List findAll() {
		log.debug("finding all TBaosun instances");
		try {
			String queryString = "from TBaosun";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TBaosun merge(TBaosun detachedInstance) {
		log.debug("merging TBaosun instance");
		try {
			TBaosun result = (TBaosun) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TBaosun instance) {
		log.debug("attaching dirty TBaosun instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TBaosun instance) {
		log.debug("attaching clean TBaosun instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TBaosunDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TBaosunDAO) ctx.getBean("TBaosunDAO");
	}
}