package product.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import common.connection.HibernateUtil;
import product.vo.ShoppingCartVO;

public class ShoppingCartServiceTests {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		ShoppingCartService svc = new ShoppingCartService();
		
		// 測試新增
//		ShoppingCartVO insert = new ShoppingCartVO();
//		insert.setMemberNo(5);
//		insert.setProdNo(10);
//		insert.setProdQty(15);
//		System.out.println(svc.insert(insert));
		
		// 測試修改
//		ShoppingCartVO update = new ShoppingCartVO();
//		update.setMemberNo(5);
//		update.setProdNo(10);
//		update.setProdQty(3);
//		System.out.println(svc.update(update));
		
		// 測試刪除
//		System.out.println(svc.delete(5, 10));
		
		// 測試複合主鍵查詢
//		System.out.println(svc.findByPrimaryKey(3, 4));
		
		// 測試查全部
//		System.out.println(svc.getAll());
		
		// 測試透過會員編號查找
		System.out.println(svc.findByMemberNo(2));
		
		transaction.commit();
		session.close();
		HibernateUtil.closeSessionFactory();
	}

}
