package dao;

import java.util.List;

import configs.JPAConfig;
import entity.Video;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class VideoDao implements IVideoDao {
	@Override

	public void insert(Video Video) {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			// gọi phuong thức để insert, update, delete

			enma.persist(Video);

			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

			throw e;

		} finally {

			enma.close();

		}

	}

	@Override

	public void update(Video Video) {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			// gọi phuong thức để insert, update, delete

			enma.merge(Video);

			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

			throw e;

		} finally {

			enma.close();

		}

	}

	@Override

	public void delete(String videoid) throws Exception {

		EntityManager enma = JPAConfig.getEntityManager();

		EntityTransaction trans = enma.getTransaction();

		try {

			trans.begin();

			// gọi phuong thức để insert, update, delete

			Video Video = enma.find(Video.class, videoid);

			if (Video != null) {

				enma.remove(Video);

			} else {

				throw new Exception("Không tìm thấy");

			}

			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

			throw e;

		} finally {

			enma.close();

		}

	}

	@Override

	public Video findById(String videoid) {

		EntityManager enma = JPAConfig.getEntityManager();

		Video Video = enma.find(Video.class, videoid);

		return Video;

	}

	@Override

	public List<Video> findAll() {

		EntityManager enma = JPAConfig.getEntityManager();

		TypedQuery<Video> query = enma.createNamedQuery("Video.findAll", Video.class);

		return query.getResultList();

	}

	@Override

	public List<Video> findByVideoTitle(String title) {

		EntityManager enma = JPAConfig.getEntityManager();

		String jpql = "SELECT c FROM Video c WHERE c.title like :titles";

		TypedQuery<Video> query = enma.createQuery(jpql, Video.class);

		query.setParameter("titles", "%" + title + "%");

		return query.getResultList();

	}

	@Override

	public List<Video> findAll(int page, int pagesize) {

		EntityManager enma = JPAConfig.getEntityManager();

		TypedQuery<Video> query = enma.createNamedQuery("Video.findAll", Video.class);

		query.setFirstResult(page * pagesize);

		query.setMaxResults(pagesize);

		return query.getResultList();

	}

	@Override

	public int count() {

		EntityManager enma = JPAConfig.getEntityManager();

		String jpql = "SELECT count(c) FROM Video c";

		Query query = enma.createQuery(jpql);

		return ((Long) query.getSingleResult()).intValue();

	}
}
