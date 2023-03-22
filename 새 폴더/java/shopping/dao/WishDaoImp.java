package shopping.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import shopping.dto.WishDTO;

public class WishDaoImp implements WishDAO {

    private SqlSession sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void insertWish(String id, int pr_key) {
    	
    	sqlSession.insert("insertWish", Map.of("id", id, "pr_key", pr_key));
    }

    @Override
    public List<WishDTO> selectWishListByMemberId(String id) {
    	
    	return sqlSession.selectList("selectWishListByMemberId", id);
    }

    @Override
    public void insertCartByWishKey(int wish_key) {
    	
    	sqlSession.insert("insertCartByWishKey", wish_key);
    }

    @Override
    public void deleteWishByWishKey(int wish_key) {
    	
    	sqlSession.delete("deleteWishByWishKey", wish_key);
    }

}
