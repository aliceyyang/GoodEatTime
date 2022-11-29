package order.dao;

import java.util.List;

import order.vo.ProdOrderDetailVO;

public interface ProdOrderDetailDAO_interface {
	
	public void insert(ProdOrderDetailVO prodOrderDetailVO);
	public void delete(Integer prodOrderNo); 
	public void update(ProdOrderDetailVO prodOrderDetailVO);
	public ProdOrderDetailVO select(Integer prodOrderNo);
	public List<ProdOrderDetailVO> getAll();
}
