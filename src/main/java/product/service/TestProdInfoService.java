package product.service;

import java.util.List;

import product.vo.ProdInfoVO;

public class TestProdInfoService {

	public static void main(String[] args) {
		ProdInfoService service = new ProdInfoService();
		
		// Test getOneProduct() 
//		System.out.println(service.getOneProduct(1).toString());
		
		// Test getAll()
//		List<ProdInfoVO> list = service.getAll();
//		for (ProdInfoVO p : list) {
//			System.out.println(p.toString());
//		}
		
		// Test addProdInfo()
		ProdInfoVO newProduct = service.addProdInfo(3, 3, "serviceAdd", 3, 3, "serviceAdd1", "serviceAdd2");
		System.out.println(newProduct);
		
		// Test updateProdInfo()
//		ProdInfoVO updateProduct = service.updateProdInfo(13, 3, 3, "service修改", 1, 1, "service修改1", "service修改2", 1, 5);
//		System.out.println(updateProduct);
		
		// Test deleteProdInfo()
//		System.out.println(service.deleteProdInfo(9));

	}

}
