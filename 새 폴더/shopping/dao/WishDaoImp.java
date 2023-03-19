package shopping.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import shopping.dto.WishDTO;

public class WishDaoImp implements WishDAO {
    
    private SqlSession sqlSession;

    public WishDaoImp(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<WishDTO> selectWishListByMemberId(String memberId) {
        return sqlSession.selectList("wish.selectWishListByMemberId", memberId);
    }

    @Override
    public boolean insertCartByWishKey(int wishKey) {
        sqlSession.insert("wish.insertCartByWishKey", wishKey);
		return false;
    }

    @Override
    public boolean deleteWishByWishKey(int wishKey) {
        sqlSession.update("wish.deleteWishByWishKey", wishKey);
		return false;
    }
}
