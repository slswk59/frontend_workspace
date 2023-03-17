package shopping.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import shopping.dto.WishDTO;

public class WishDaoImp implements WishDAO {
	
	private SqlSession sqlSession;
	
	public WishDaoImp() {
		
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public int insertWish(WishDTO wish) {
		return sqlSession.insert("shopping.dao.WishDAO.insertWish", wish);
	}

	@Override
	public int deleteWish(int wish_key) {
		return sqlSession.delete("shopping.dao.WishDAO.deleteWish", wish_key);
	}

	@Override
	public List<WishDTO> getWishList(String id) {
		return sqlSession.selectList("shopping.dao.WishDAO.getWishList", id);
	}

}
