package local;

public class MenuChanged extends AbstractEvent {

    private Long id;
    private String menuNm;
    private String chkDate;
    private Long pCnt;
    private Long price;         //가격

    public MenuChanged(){
        super();
    }

    public Long getpCnt() {
        return pCnt;
    }
    public void setpCnt(Long pCnt) {
        this.pCnt = pCnt;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuNm() {
        return menuNm;
    }
    public void setMenuNm(String menuNm) {
        this.menuNm = menuNm;
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
