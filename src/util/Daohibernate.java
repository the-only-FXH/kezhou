package util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import po.Xiadan;
import po.Zhuce;

/*
 * 用hibernate3封装数据库的基本操作
 */
public class Daohibernate {

	/*
	 * 数据库操作-添加数据
	 */
	public void saveZhuce(Zhuce zhuce) {// 向zhuce表插入数据
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtil.getThreadLocalSession();
			tx = s.beginTransaction();
			s.save(zhuce);
			tx.commit();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void saveXiadan(Xiadan xiadan) {
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtil.getThreadLocalSession();
			tx = s.beginTransaction();
			s.save(xiadan);
			tx.commit();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	/*
	 * 数据库操作-更新数据
	 */
	public void updateZhuce(Zhuce zhuce) {
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtil.getThreadLocalSession();
			tx = s.beginTransaction();
			s.update(zhuce);
			tx.commit();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public void updateXiadan(Xiadan xiadan) {
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtil.getThreadLocalSession();
			tx = s.beginTransaction();
			s.update(xiadan);
			tx.commit();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	/*
	 * 数据库操作：依据主键查找
	 */
	public Zhuce findZhuceById(String zphone) { // 输入手机号进行注册查询
		Session s = null;

		try {
			s = HibernateUtil.getThreadLocalSession();
			Zhuce zhuce = (Zhuce) s.get(Zhuce.class, zphone);
			return zhuce;

		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	public Xiadan findXiadanById(String id) { // 由id进行查询
		Session s = null;

		try {
			s = HibernateUtil.getThreadLocalSession();
			Xiadan xiadan = (Xiadan) s.get(Xiadan.class, id);
			return xiadan;

		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	public List<Xiadan> findXiadanByPhone( Object value,
			Object value1) { //西区1号楼和百世
		Session s = null;
		Query query = null;
		try {
			s = HibernateUtil.getThreadLocalSession();
			String queryString = "from Xiadan as model where model.phone = ? and model.date=?";
			query = s.createQuery(queryString);
			query.setParameter(0, value);
			query.setParameter(1, value1);
			@SuppressWarnings("unchecked")
			List<Xiadan> list = query.list();
			return list;

		} finally {
			HibernateUtil.closeSession();
		}
	}

	/*
	 * 按条件查询，查询某一天的所有下单
	 */
	public List<Xiadan> findXiadaninfo(String type, Object value) {
		Session s = null;
		Query query = null;
		try {
			s = HibernateUtil.getThreadLocalSession();
			String queryString = "from Xiadan as model where model." + type
					+ "=? order by lou asc";
			query = s.createQuery(queryString);
			query.setParameter(0, value);
			@SuppressWarnings("unchecked")
			List<Xiadan> list = query.list();
			return list;

		} finally {
			HibernateUtil.closeSession();
		}
	}

	/*
	 * 数据库操作：依据主键删除
	 */
	public void Zhuceremove(String zphone) {// 输入手机号删除注册记录
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtil.getThreadLocalSession();

			tx = s.beginTransaction();
			Zhuce zhuce = (Zhuce) s.get(Zhuce.class, zphone);
			if (zhuce != null) {
				s.delete(zhuce);
			}

			tx.commit();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	
	public void Xiadanremove(String id) {// 输入手机号删除注册记录
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtil.getThreadLocalSession();

			tx = s.beginTransaction();
			Xiadan xiadan = (Xiadan) s.get(Xiadan.class, id);
			if (xiadan != null) {
				s.delete(xiadan);
			}

			tx.commit();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	/*
	 * 查询所有
	 */
	@SuppressWarnings("unchecked")
	public List<Zhuce> QueryAll_zhuce() {// 查询所有
		Session s = null;
		Transaction tx = null;
		try {
			s = HibernateUtil.getThreadLocalSession();
			tx = s.beginTransaction();
			Query query = s.createQuery(" from Zhuce");
			tx.commit();
			return query.list();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	/*
	 * 按手机号、取货号、下单日期查询
	 */
	public List<Xiadan> findInfo23(String type, String type1, Object value,
			Object value1) { //西区1号楼和百世
		Session s = null;
		Query query = null;
		try {
			s = HibernateUtil.getThreadLocalSession();
			String queryString = "from Xiadan as model where (model." + type
					+ "=?)"+"and model." + type1 + "=?order by kdlx,qhh asc";
			query = s.createQuery(queryString);
			query.setParameter(0, value);
			query.setParameter(1, value1);
			@SuppressWarnings("unchecked")
			List<Xiadan> list = query.list();
			return list;

		} finally {
			HibernateUtil.closeSession();
		}
	}

	public List<Xiadan> findInfo2(String type, String type1, Object value,
			Object value1,Object value2) { //西区1号楼和百世
		Session s = null;
		Query query = null;
		try {
			s = HibernateUtil.getThreadLocalSession();
			String queryString = "from Xiadan as model where (model." + type
					+ "=? or model." + type +"=?)"+"and model." + type1 + "=? order by kdlx,qhh asc";
			query = s.createQuery(queryString);
			query.setParameter(0, value);
			query.setParameter(1, value1);
			query.setParameter(2, value2);
			@SuppressWarnings("unchecked")
			List<Xiadan> list = query.list();
			return list;

		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	public List<Xiadan> findInfo3(String type, String type1, Object value,
			Object value1,Object value2,Object value3, Object value4,
			Object value5,Object value6,Object value7,Object value8) { //东区12号楼
		Session s = null;
		Query query = null;
		try {
			s = HibernateUtil.getThreadLocalSession();
			String queryString = "from Xiadan as model where (model." + type
					+ "=? or model." + type +"=? or model." + type + "=? or model." + type +"=? or model." + type +"=? or model." + type +"=? or model." + type +"=? or model." + type +"=?)"+"and model." + type1 + "=?order by kdlx,qhh asc";
			query = s.createQuery(queryString);
			query.setParameter(0, value);
			query.setParameter(1, value1);
			query.setParameter(2, value2);
			query.setParameter(3, value3);
			query.setParameter(4, value4);
			query.setParameter(5, value5);
			query.setParameter(6, value6);
			query.setParameter(7, value7);
			query.setParameter(8, value8);
			@SuppressWarnings("unchecked")
			List<Xiadan> list = query.list();
			return list;

		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	
	public List<Xiadan> findInfo4(String type, String type1, Object value,
			Object value1,Object value2,Object value3,Object value4,Object value5,Object value6,Object value7) { //东门菜鸟
		Session s = null;
		Query query = null;
		try {
			s = HibernateUtil.getThreadLocalSession();
			String queryString = "from Xiadan as model where (model." + type
					+ "=? or model." + type +"=? or model." + type + "=? or model." + type + "=? or model." + type + "=? or model." + type + "=? or model." + type + "=?)"+"and model." + type1 + "=? order by kdlx,qhh asc";
			query = s.createQuery(queryString);
			query.setParameter(0, value);
			query.setParameter(1, value1);
			query.setParameter(2, value2);
			query.setParameter(3, value3);
			query.setParameter(4, value4);
			query.setParameter(5, value5);
			query.setParameter(6, value6);
			query.setParameter(7, value7);
			@SuppressWarnings("unchecked")
			List<Xiadan> list = query.list();
			return list;

		} finally {
			HibernateUtil.closeSession();
		}
	}

}
