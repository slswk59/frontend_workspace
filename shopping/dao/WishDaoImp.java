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
    public List<WishDTO> selectWishListByUserId(int userId) {
        return sqlSession.selectList("wish.selectWishListByUserId", userId);
    }

    @Override
    public int insertCartByUserIdAndProductId(int userId, int productId) {
        return sqlSession.insert("wish.insertCartByUserIdAndProductId", new Object[] { userId, productId });
    }

    @Override
    public int deleteWishByUserIdAndProductId(int userId, int productId) {
        return sqlSession.delete("wish.deleteWishByUserIdAndProductId", new Object[] { userId, productId });
    }
    
}
