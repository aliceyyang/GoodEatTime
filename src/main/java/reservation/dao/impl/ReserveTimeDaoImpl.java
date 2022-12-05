package reservation.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import common.connection.HibernateUtil;
import reservation.dao.ReserveTimeDao;
import reservation.vo.ReserveTimeVO;

public class ReserveTimeDaoImpl implements ReserveTimeDao {
	private SessionFactory sessionFactory;

	public ReserveTimeDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		ReserveTimeDao dao = new ReserveTimeDaoImpl(sessionFactory);

		// select
//		List<ReserveTimeVO> vo = dao.getAll();
//		System.out.println("bean="+ vo);

		// select findbyrestaurantNo
//		List<ReserveTimeVO> vo =  dao.findbyrestaurantNo(1);
//		System.out.println("bean=" + vo);

		// select findbyrestaurantNo
//			List<ReserveTimeVO> vo =  dao.findbyrestaurantNOandWeekDay(1, 0);
//			System.out.println("bean=" + vo);
		
		// insert
//		ReservationVO insert = new ReservationVO();
//		insert.setReserveNum(22);
//		insert.setReserveTime("17:00");
//		insert.setReserveDate(new java.sql.Date(new GregorianCalendar(2022, 12, 22).getTimeInMillis()));
//		insert.setMemberNo(5);
//		insert.setReserveStatus("訂位成功");
//		insert.setRestaurantNo(2);
//		insert.setRemark(null);
//		insert.setCommentContent(null);
//		insert.setCommentRating(null);
//		insert.setCommentPic(null);
//		insert.setRestaurantRe(null);
//		
//		ReservationVO result1 = dao.insert(insert);
//		System.out.println(result1);

		// update
//		boolean update = dao.update(2, "報告成功", 5, "餐很好吃",null,  new java.sql.Timestamp(new GregorianCalendar(2022, 12, 21).getTimeInMillis()), null, null);
//		System.out.println("update="+update);

		transaction.commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	}

	@Override
	public ReserveTimeVO insert(ReserveTimeVO reserveTimeVo) {
		if (reserveTimeVo != null && reserveTimeVo.getReserveTimeNo() == null) {
			this.getSession().save(reserveTimeVo);
			return reserveTimeVo;
		}
		return null;
	}

	@Override
	public boolean updateAllowReserveNum(Integer reserveTimeNO, String reserveTime, Integer allowReserveNum) {
		if (reserveTimeNO != null) {
			ReserveTimeVO temp = this.getSession().get(ReserveTimeVO.class, reserveTimeNO);
			if (temp != null) {
				temp.setAllowReserveNum(allowReserveNum);
				temp.setReserveTime(reserveTime);

				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateWeekDay(Integer reserveTimeNO, String reserveTime, Integer weekDay, Integer allowReserveNum) {
		if (reserveTimeNO != null) {
			ReserveTimeVO temp = this.getSession().get(ReserveTimeVO.class, reserveTimeNO);
			if (temp != null) {
				temp.setReserveTime(reserveTime);
				temp.setWeekDay(weekDay);
				temp.setAllowReserveNum(allowReserveNum);

				return true;
			}
		}
		return false;
	}

	@Override
	public ReserveTimeVO update(ReserveTimeVO reserveTimeVO) {
		if (reserveTimeVO != null && reserveTimeVO.getReserveTimeNo() != null) {
			ReserveTimeVO temp = this.getSession().get(ReserveTimeVO.class, reserveTimeVO.getReserveTimeNo());
			if (temp != null) {
				return (ReserveTimeVO) this.getSession().merge(reserveTimeVO);
			}
		}
		return null;
	}

	@Override
	public List<ReserveTimeVO> findbyrestaurantNOandWeekDay(Integer restaurantNo, Integer weekDay) {
		Query<ReserveTimeVO> query = getSession().createQuery("from ReserveTimeVO where restaurantNo = :restaurantNo and weekDay = :weekDay", ReserveTimeVO.class);
		query.setParameter("restaurantNo", restaurantNo);
		query.setParameter("weekDay", weekDay);
		List<ReserveTimeVO> reserveTimeVO = query.list();
		return reserveTimeVO;
	}

	@Override
	public List<ReserveTimeVO> findbyrestaurantNo(Integer restaurantNo) {
			Query<ReserveTimeVO> query = getSession().createQuery("from ReserveTimeVO where restaurantNo = :restaurantNo", ReserveTimeVO.class);
			query.setParameter("restaurantNo", restaurantNo);
			List<ReserveTimeVO> reserveTimeVO = query.list();
			return reserveTimeVO;
	}

	@Override
	public List<ReserveTimeVO> getAll() {
//		return this.getSession().createQuery("from ReserveTimeVO", ReserveTimeVO.class).list();

		CriteriaBuilder criteriaBuilder = this.getSession().getCriteriaBuilder();
		CriteriaQuery<ReserveTimeVO> criteriaQuery = criteriaBuilder.createQuery(ReserveTimeVO.class);

		Root<ReserveTimeVO> root = criteriaQuery.from(ReserveTimeVO.class);

		TypedQuery<ReserveTimeVO> typedQuery = this.getSession().createQuery(criteriaQuery);
		List<ReserveTimeVO> result = typedQuery.getResultList();
		if (result != null && !result.isEmpty()) {
			return result;
		} else {
			return null;
		}

	}

}
