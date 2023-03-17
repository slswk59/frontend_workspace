package shopping.dto;

public class WishDTO {
    private int wish_key;
    private String id; // 사용자 아이디
    private int product_key; // 상품 키
    private String wish_reg_date; // 등록 날짜
    private String wish_del_date; // 삭제 날짜

    public WishDTO() {

    }

    public int getWish_key() {
        return wish_key;
    }

    public void setWish_key(int wish_key) {
        this.wish_key = wish_key;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getProduct_key() {
        return product_key;
    }

    public void setProduct_key(int product_key) {
        this.product_key = product_key;
    }

    public String getWish_reg_date() {
        return wish_reg_date;
    }

    public void setWish_reg_date(String wish_reg_date) {
        this.wish_reg_date = wish_reg_date;
    }

    public String getWish_del_date() {
        return wish_del_date;
    }

    public void setWish_del_date(String wish_del_date) {
        this.wish_del_date = wish_del_date;
    }
}
