package product.dao;

import java.util.List;
import product.vo.ProdCategoryVO;

public interface ProdCategoryDAO {
	
	public void insert(ProdCategoryVO prodCategory);
	public void update(ProdCategoryVO prodCategory);
	public boolean delete(Integer prodCategoryNo);
	public ProdCategoryVO findByPrimaryKey(Integer prodCategoryNo);
	public List<ProdCategoryVO> getAll();
	
}
