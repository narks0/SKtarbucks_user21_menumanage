package local;

public class OrderCanceled extends AbstractEvent {

    private Long id;
    private Long menuId;
    private String menuNm;
    private Long pCnt;
    private String chkDate;
    private Long price;

    public OrderCanceled(){
        super();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getMenuId() {
        return menuId;
    }
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuNm() {
        return menuNm;
    }
    public void setMenuNm(String menuNm) {
        this.menuNm = menuNm;
    }

    public Long getPCnt() {
        return pCnt;
    }
    public void setPCnt(Long pCnt) {
        this.pCnt = pCnt;
    }

    public String getChkDate() {
        return chkDate;
    }
    public void setChkDate(String chkDate) {
        this.chkDate = chkDate;
    }

    public Long getPrice() {
        return price;
    }
    public void setPrice(Long price) {
        this.price = price;
    }

}
