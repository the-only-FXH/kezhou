package util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import po.Xiadan;
import po.Zhuce;

/*
 * ��hibernate3��װ���ݿ�Ļ�������
 */
public class Daohibernate {

	/*
	 * ���ݿ����-�������
	 */
	public void saveZhuce(Zhuce zhuce) {// ��zhuce���������
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
	 * ���ݿ����-��������
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
	 * ���ݿ������������������
	 */
	public Zhuce findZhuceById(String zphone) { // �����ֻ��Ž���ע���ѯ
		Session s = null;

		try {
			s = HibernateUtil.getThreadLocalSession();
			Zhuce zhuce = (Zhuce) s.get(Zhuce.class, zphone);
			return zhuce;

		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	public Xiadan findXiadanById(String id) { // ��id���в�ѯ
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
			Object value1) { //����1��¥�Ͱ���
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
	 * ��������ѯ����ѯĳһ��������µ�
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
	 * ���ݿ��������������ɾ��
	 */
	public void Zhuceremove(String zphone) {// �����ֻ���ɾ��ע���¼
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
	
	
	public void Xiadanremove(String id) {// �����ֻ���ɾ��ע���¼
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
	 * ��ѯ����
	 */
	@SuppressWarnings("unchecked")
	public List<Zhuce> QueryAll_zhuce() {// ��ѯ����
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
	 * ���ֻ��š�ȡ���š��µ����ڲ�ѯ
	 */
	public List<Xiadan> findInfo23(String type, String type1, Object value,
			Object value1) { //����1��¥�Ͱ���
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
			Object value1,Object value2) { //����1��¥�Ͱ���
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
			Object value5,Object value6,Object value7,Object value8) { //����12��¥
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
			Object value1,Object value2,Object value3,Object value4,Object value5,Object value6,Object value7) { //���Ų���
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
