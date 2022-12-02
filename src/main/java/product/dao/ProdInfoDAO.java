package product.dao;

import java.util.List;
import product.vo.ProdInfoVO;

public interface ProdInfoDAO {
	public void insert(ProdInfoVO productVO);
	public void update(ProdInfoVO productVO);
	public boolean delete(Integer prodNo);
	public ProdInfoVO findByPrimaryKey(Integer prodNo);
	public List<ProdInfoVO> getAll();
	public List<ProdInfoVO> findByProdCategory(Integer ProdCategoryNo);
}
