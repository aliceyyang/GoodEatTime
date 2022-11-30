package product.dao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.vo.ProdCategoryVO;

@WebServlet("/TestProdCategoryDAO")
public class TestProdCategoryDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestProdCategoryDAO() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ProdCategoryDAO_JNDI dao = new ProdCategoryDAO_JNDI();
		
		// findByPrimaryKey 主鍵查詢
		System.out.println(dao.findByPrimaryKey(1).toString());
		
		// getAll
//		List<ProdCategoryVO> list =  dao.getAll();
//		for(ProdCategoryVO myProductCategory : list) {
//			System.out.println(myProductCategory.toString());
//		}
		
		// insert 新增
//		ProdCategoryVO myProductCategory = new ProdCategoryVO();
//		myProductCategory.setProdCategory("~~測試新增~~");
//		dao.insert(myProductCategory);
//		System.out.println(myProductCategory.toString());
		
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
