package shopping.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import shopping.dto.WishDTO;

public class WishDaoImp implements WishDAO {
	private SqlSession sqlSession;

	public WishDaoImp(SqlSession sqlSession) {
	    this.sqlSession = sqlSession;
	}

	@Override
	public List<WishDTO> selectWishList(String id) {
		return sqlSession.selectList("shopping.wish.selectWishList", id);
	}

	@Override
	public int deleteWish(int wish_key) {
		return sqlSession.delete("shopping.wish.deleteWish", wish_key);
	}

	@Override
	public int insertWish(WishDTO wishDto) {
		return sqlSession.insert("shopping.wish.insertWish", wishDto);
	}

	@Override
	public int insertCart(WishDTO wishDto) {
		return sqlSession.insert("shopping.wish.insertCart", wishDto);
	}

	@Override
	public int moveCart(int wish_key, String id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("wish_key", wish_key);
		map.put("id", id);
		return sqlSession.insert("shopping.wish.moveCart", map);
	}

	@Override
	public int deleteWishByIdAndProductKey(String id, int product_key) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("product_key", product_key);
		return sqlSession.delete("shopping.wish.deleteWishByIdAndProductKey", map);
	}

}
