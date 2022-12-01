package product.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import product.vo.ProdPicVO;

public class ProdPicDAO_Hibernate implements ProdPicDAO {
	private SessionFactory sessionFactory;
	public ProdPicDAO_Hibernate(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public ProdPicVO insert(ProdPicVO prodPicVO) {
		if (prodPicVO != null) {
			return (ProdPicVO)this.getSession().save(prodPicVO);
		}
		return null;
	}

	@Override
	public ProdPicVO update(ProdPicVO prodPicVO) {
		if (prodPicVO != null && prodPicVO.getProdPicNo() != null) {
			ProdPicVO temp = this.getSession().get(ProdPicVO.class, prodPicVO.getProdPicNo());
			if (temp != null) {
				return (ProdPicVO) this.getSession().merge(prodPicVO);
			}
		}
		return null;
	}

	@Override
	public boolean delete(Integer prodPicNo) {
		if (prodPicNo != null) {
			ProdPicVO temp = this.getSession().get(ProdPicVO.class, prodPicNo);
			if(temp != null) {
				this.getSession().delete(temp);
				return true;
			}
		}
		return false;
	}

	@Override
	public ProdPicVO findByPrimaryKey(Integer prodPicNo) {
		if (prodPicNo != null) {
			return this.getSession().get(ProdPicVO.class, prodPicNo);
		}
		return null;
	}

	@Override
	public List<ProdPicVO> getAll() {
		return this.getSession().createQuery("from ProdPicVO", ProdPicVO.class).list();
	}

	@Override
	public List<ProdPicVO> findByProdCategory(Integer ProdPicNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
