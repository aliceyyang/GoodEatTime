package com.tibame.tga104.order.dao;

import java.util.List;

import com.tibame.tga104.order.vo.ProdOrderVO;

public interface ProdOrderDAO_interface {
	
	public void insert(ProdOrderVO prodOrderVO);
	public void delete(Integer prodOrderNo);
	public void update(ProdOrderVO prodOrderVO);
	public ProdOrderVO select(Integer prodOrderNo);
	public List<ProdOrderVO> getAll();

}
