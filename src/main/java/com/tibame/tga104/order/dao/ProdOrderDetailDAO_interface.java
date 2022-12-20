package com.tibame.tga104.order.dao;

import java.util.List;

import com.tibame.tga104.order.vo.ProdOrderDetailVO;

public interface ProdOrderDetailDAO_interface {
	
	public ProdOrderDetailVO insert(ProdOrderDetailVO prodOrderDetailVO);
	public boolean delete(Integer prodOrderNo, Integer prodQty); 
	public ProdOrderDetailVO update(ProdOrderDetailVO prodOrderDetailVO);
	public ProdOrderDetailVO select(Integer prodOrderNo, Integer prodQty);
	public List<ProdOrderDetailVO> select(Integer prodOrderNo);
	public List<ProdOrderDetailVO> getAll();
}
