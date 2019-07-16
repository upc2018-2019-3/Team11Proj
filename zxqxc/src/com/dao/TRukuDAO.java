package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TRuku;

/**
 * Data access object (DAO) for domain model class TRuku.
 * 
 * @see com.model.TRuku
 * @author MyEclipse Persistence Tools
 */

public class TRukuDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TRukuDAO.class);

	protected void initDao()
	{
		// do nothing
	}

	public void save(TRuku transientInstance)
	{
		log.debug("saving TRuku instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TRuku persistentInstance)
	{
		log.debug("deleting TRuku instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public TRuku findById(java.lang.Integer id)
	{
		log.debug("getting TRuku instance with id: " + id);
		try
		{
			TRuku instance = (TRuku) getHibernateTemplate().get(
					"com.model.TRuku", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TRuku instance)
	{
		log.debug("finding TRuku instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding TRuku instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TRuku as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll()
	{
		log.debug("finding all TRuku instances");
		try
		{
			String queryString = "from TRuku";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TRuku merge(TRuku detachedInstance)
	{
		log.debug("merging TRuku instance");
		try
		{
			TRuku result = (TRuku) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TRuku instance)
	{
		log.debug("attaching dirty TRuku instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TRuku instance)
	{
		log.debug("attaching clean TRuku instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TRukuDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TRukuDAO) ctx.getBean("TRukuDAO");
	}
}