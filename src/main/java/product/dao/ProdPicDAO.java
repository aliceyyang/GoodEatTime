package product.dao;

import java.util.List;

import product.vo.ProdPicVO;

public interface ProdPicDAO {
	public ProdPicVO insert(ProdPicVO prodPicVO);
	public ProdPicVO update(ProdPicVO prodPicVO);
	public boolean delete(Integer prodPicNo);
	public ProdPicVO findByPrimaryKey(Integer prodPicNo);
	public List<ProdPicVO> getAll();
	public List<ProdPicVO> findByProdCategory(Integer ProdPicNo);
}
