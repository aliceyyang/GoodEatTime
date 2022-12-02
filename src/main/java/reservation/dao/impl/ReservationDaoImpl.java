package reservation.dao.impl;

import java.sql.Timestamp;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import common.connection.HibernateUtil;
import reservation.dao.ReservationDao;
import reservation.vo.ReservationVO;

public class ReservationDaoImpl implements ReservationDao {
	private SessionFactory sessionFactory;

	public ReservationDaoImpl(SessionFactory sessionFactory) {
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

		ReservationDao dao = new ReservationDaoImpl(sessionFactory);

		//	select
//		List<ReservationVO> vo = dao.getAll();
//		System.out.println("bean="+ vo);
		
		// insert
		ReservationVO insert = new ReservationVO();
		insert.setReserveNum(22);
		insert.setReserveTime("17:00");
		insert.setReserveDate(new java.sql.Date(new GregorianCalendar(2022, 12, 22).getTimeInMillis()));
		insert.setMemberNo(5);
		insert.setReserveStatus("訂位成功");
		insert.setRestaurantNo(2);
		insert.setRemark(null);
		insert.setCommentContent(null);
		insert.setCommentRating(null);
		insert.setCommentPic(null);
		insert.setRestaurantRe(null);
		
		ReservationVO result1 = dao.insert(insert);
		System.out.println(result1);
		
		// update
//		boolean update = dao.update(2, "報告成功", 5, "餐很好吃",null,  new java.sql.Timestamp(new GregorianCalendar(2022, 12, 21).getTimeInMillis()), null, null);
//		System.out.println("update="+update);
		
		transaction.commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	}

	@Override
	public ReservationVO insert(ReservationVO reservationVO) {
		if (reservationVO != null && reservationVO.getReserveNo() == null) {
				this.getSession().save(reservationVO);
				return reservationVO;
			
		}
		return null;
	}
	

	@Override
	public ReservationVO update(ReservationVO reservationVO) {
		if(reservationVO!= null && reservationVO.getReserveNo() != null) {
			ReservationVO temp = this.getSession().get(ReservationVO.class, reservationVO.getReserveNo());
			if(temp != null) {
				return (ReservationVO)this.getSession().merge(reservationVO);
			}
		}
		return null;
	}
	
	@Override
	public boolean update(Integer reserveNo, String reserveStatus, Integer commentRating, String commentContent, byte[] commentPic,
			Timestamp restaurantCommentTime, String restaurantRe, java.sql.Timestamp restaurantReTime) {
		if(reserveNo != null) {
			ReservationVO temp = this.getSession().get(ReservationVO.class, reserveNo);
			if(temp != null) {
				temp.setReserveStatus(reserveStatus);
				temp.setCommentRating(commentRating);
				temp.setCommentContent(commentContent);
				temp.setCommentPic(commentPic);
				temp.setRestaurantCommentTime(restaurantCommentTime);
				temp.setRestaurantRe(restaurantRe);
				temp.setRestaurantReTime(restaurantReTime);
				
				return true;
			}
		}return false;
		
	}
	
	@Override
	public ReservationVO findByPrimaryKey(Integer reserveNo) {
		if (reserveNo != null) {
			return this.getSession().get(ReservationVO.class, reserveNo);
		}
		return null;
	}

	@Override
	public List<ReservationVO> getAll() {
//		return this.getSession().createQuery("from ReservationVO", ReservationVO.class).list();
		
		CriteriaBuilder criteriaBuilder =  this.getSession().getCriteriaBuilder();
		CriteriaQuery<ReservationVO> crteriaQuery = criteriaBuilder.createQuery(ReservationVO.class);
		
		Root<ReservationVO> root = crteriaQuery.from(ReservationVO.class);		
		
		TypedQuery<ReservationVO> typedQuery = this.getSession().createQuery(crteriaQuery);
		List<ReservationVO> result = typedQuery.getResultList();
		if(result!=null && !result.isEmpty()) {
			return result;
		} else {
			return null;
		}
		
	}


}
