package shopping.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import shopping.dto.WishDTO;

public class WishDaoImp implements WishDAO {
    
    private SqlSession sqlSession;

    public WishDaoImp(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    // 해당 회원의 찜 목록 조회
    @Override
    public List<WishDTO> selectWishListByMemberId(String memberId) {
        return sqlSession.selectList("shopping.dao.WishDAO.selectWishListByMemberId", memberId);
    }

    // 찜한 상품을 카트에 추가
    @Override
    public int insertCartByWishKey(int wishKey) {
        return sqlSession.insert("shopping.dao.WishDAO.insertCartByWishKey", wishKey);
    }

    // 찜한 상품 삭제
    @Override
    public int deleteWishByWishKey(int wishKey) {
        return sqlSession.delete("shopping.dao.WishDAO.deleteWishByWishKey", wishKey);
    }
}
