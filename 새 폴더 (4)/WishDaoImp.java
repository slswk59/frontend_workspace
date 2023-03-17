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
    public List<WishDTO> selectWishListById(String id) {
        return sqlSession.selectList("shopping.mapper.WishMapper.selectWishListById", id);
    }

    @Override
    public void deleteWish(int wishKey) {
        sqlSession.delete("shopping.mapper.WishMapper.deleteWish", wishKey);
    }

    @Override
    public void addCartFromWish(int wishKey, String id) {
        sqlSession.insert("shopping.mapper.CartMapper.addCartFromWish", new Object[] {wishKey, id});
        sqlSession.delete("shopping.mapper.WishMapper.deleteWish", wishKey);
    }
    
}
