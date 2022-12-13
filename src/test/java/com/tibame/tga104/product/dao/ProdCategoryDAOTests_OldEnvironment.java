package com.tibame.tga104.product.dao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.tibame.tga104.product.vo.ProdCategoryVO;

/*此為舊環境的測試檔案，切換成spring boot環境後，尚未配合環境調整*/
@Component
@WebServlet("/TestProdCategoryDAO")
public class ProdCategoryDAOTests_OldEnvironment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProdCategoryDAOTests_OldEnvironment() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ProdCategoryDAO_JNDI dao = new ProdCategoryDAO_JNDI();
		
		// findByPrimaryKey 主鍵查詢
//		System.out.println(dao.findByPrimaryKey(1).toString());
		
		// getAll
//		List<ProdCategoryVO> list =  dao.getAll();
//		for(ProdCategoryVO myProductCategory : list) {
//			System.out.println(myProductCategory.toString());
//		}
		
		// insert 新增
		ProdCategoryVO myProductCategory = new ProdCategoryVO();
		myProductCategory.setProdCategory("~~測試新增~~");
		System.out.println(dao.insert(myProductCategory));
		
		// update 修改
//		ProdCategoryVO myProductCategory = new ProdCategoryVO();
//		myProductCategory.setProdCategoryNo(10);
//		myProductCategory.setProdCategory("~~測試修改~~");
//		dao.update(myProductCategory);
//		System.out.println(myProductCategory.toString());
		
		// delete 刪除
//		System.out.println(dao.delete(10));
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
