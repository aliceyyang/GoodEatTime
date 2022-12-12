package com.tibame.tga104.product.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tibame.tga104.common.connection.HibernateUtil;

/*此為舊環境的測試檔案，切換成spring boot環境後，尚未配合環境調整*/
public class ProdPicDAOTests_OldEnvironment {

//	public static void main(String[] args) {
//		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//		Session session = sessionFactory.getCurrentSession();
//		Transaction transaction = session.beginTransaction();
//		
//		ProdPicDAO dao = new ProdPicDAO_Hibernate();
		
		// findByPrimaryKey 主鍵查詢
//		System.out.println(dao.findByPrimaryKey(3));
		
		// getAll 査全部
//		List<ProdPicVO> list = dao.getAll();
//		for (ProdPicVO p : list) {
//			System.out.println(p);
//		}
		
		// insert 新增
//		ProdPicVO insert = new ProdPicVO();
//		insert.setProdNo(4);
//		insert.setProdPicRemark("測試Hibernate新增");
//		try (InputStream in = Files.newInputStream(Path.of("C:\\GoodEatTime\\Workspace\\GoodEatTime\\src\\main\\webapp\\Front_End\\img\\shop\\product-1.jpg"))){
//			byte[] bytes = new byte[in.available()];
//			in.read(bytes);
//			insert.setProdPic(bytes);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println(dao.insert(insert));
		
		// update 修改
//		ProdPicVO update = dao.findByPrimaryKey(8);
//		update.setProdPicRemark("測試Hibernate修改");
//		try (InputStream in = Files.newInputStream(Path.of("C:\\GoodEatTime\\Workspace\\GoodEatTime\\src\\main\\webapp\\Front_End\\img\\shop\\product-2.jpg"))){
//			byte[] bytes = new byte[in.available()];
//			in.read(bytes);
//			update.setProdPic(bytes);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		dao.update(update);
		
		// delete 刪除
//		dao.delete(9);
		
		// 產品編號搜尋
//		List<ProdPicVO> list = dao.findByProdNo(3);
//		for(ProdPicVO p : list) {
//			System.out.println(p);
//		}
		
//		transaction.commit();
//		session.close();
//		HibernateUtil.closeSessionFactory();
//	}

}
