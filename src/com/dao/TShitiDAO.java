package com.dao;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TShiti;

/**
 * Data access object (DAO) for domain model class TShiti.
 * 
 * @see com.model.TShiti
 * @author MyEclipse Persistence Tools
 */

public class TShitiDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TShitiDAO.class);

	// property constants
	public static final String SHITI_NAME = "shitiName";

	public static final String SHITI_FUJIAN = "shitiFujian";

	public static final String SHITI_FUJIANLEIXING = "shitiFujianleixing";

	public static final String SHITI_FUJIANYUANSHIMING = "shitiFujianyuanshiming";

	public static final String SHITI_FABURIQI = "shitiFaburiqi";

	public static final String SHITI_FABUZHE = "shitiFabuzhe";

	public static final String SHITI_TYPE = "shitiType";

	public static final String SHITI_ONE1 = "shitiOne1";

	public static final String SHITI_ONE2 = "shitiOne2";

	public static final String SHITI_ONE3 = "shitiOne3";

	public static final String SHITI_ONE4 = "shitiOne4";

	public static final String SHITI_ONE7 = "shitiOne7";

	public static final String SHITI_ONE8 = "shitiOne8";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TShiti transientInstance)
	{
		log.debug("saving TShiti instance");
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

	public void delete(TShiti persistentInstance)
	{
		log.debug("deleting TShiti instance");
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

	public TShiti findById(java.lang.Integer id)
	{
		log.debug("getting TShiti instance with id: " + id);
		try
		{
			TShiti instance = (TShiti) getHibernateTemplate().get(
					"com.model.TShiti", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TShiti instance)
	{
		log.debug("finding TShiti instance by example");
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
		log.debug("finding TShiti instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TShiti as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByShitiName(Object shitiName)
	{
		return findByProperty(SHITI_NAME, shitiName);
	}

	public List findByShitiFujian(Object shitiFujian)
	{
		return findByProperty(SHITI_FUJIAN, shitiFujian);
	}

	public List findByShitiFujianleixing(Object shitiFujianleixing)
	{
		return findByProperty(SHITI_FUJIANLEIXING, shitiFujianleixing);
	}

	public List findByShitiFujianyuanshiming(Object shitiFujianyuanshiming)
	{
		return findByProperty(SHITI_FUJIANYUANSHIMING, shitiFujianyuanshiming);
	}

	public List findByShitiFaburiqi(Object shitiFaburiqi)
	{
		return findByProperty(SHITI_FABURIQI, shitiFaburiqi);
	}

	public List findByShitiFabuzhe(Object shitiFabuzhe)
	{
		return findByProperty(SHITI_FABUZHE, shitiFabuzhe);
	}

	public List findByShitiType(Object shitiType)
	{
		return findByProperty(SHITI_TYPE, shitiType);
	}

	public List findByShitiOne1(Object shitiOne1)
	{
		return findByProperty(SHITI_ONE1, shitiOne1);
	}

	public List findByShitiOne2(Object shitiOne2)
	{
		return findByProperty(SHITI_ONE2, shitiOne2);
	}

	public List findByShitiOne3(Object shitiOne3)
	{
		return findByProperty(SHITI_ONE3, shitiOne3);
	}

	public List findByShitiOne4(Object shitiOne4)
	{
		return findByProperty(SHITI_ONE4, shitiOne4);
	}

	public List findByShitiOne7(Object shitiOne7)
	{
		return findByProperty(SHITI_ONE7, shitiOne7);
	}

	public List findByShitiOne8(Object shitiOne8)
	{
		return findByProperty(SHITI_ONE8, shitiOne8);
	}

	public List findAll()
	{
		log.debug("finding all TShiti instances");
		try
		{
			String queryString = "from TShiti";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TShiti merge(TShiti detachedInstance)
	{
		log.debug("merging TShiti instance");
		try
		{
			TShiti result = (TShiti) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TShiti instance)
	{
		log.debug("attaching dirty TShiti instance");
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

	public void attachClean(TShiti instance)
	{
		log.debug("attaching clean TShiti instance");
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

	public static TShitiDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TShitiDAO) ctx.getBean("TShitiDAO");
	}
}