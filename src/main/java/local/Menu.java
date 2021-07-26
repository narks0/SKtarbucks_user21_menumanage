package local;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Menu_table")
public class Menu {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;            //메뉴ID
    private String menuNm;      //메뉴명
    private Long pCnt;          //가용재고
    private String chkDate;     //재고체크일
    private Long price;         //가격

    @PostPersist
    public void onPostPersist(){
        MenuRegistered menuRegistered = new MenuRegistered();
        BeanUtils.copyProperties(this, menuRegistered);
        menuRegistered.publishAfterCommit();
    }

    @PreUpdate
    public  void onPreUpdate(){
        /*
        강제적 Delay
        try {
            Thread.currentThread().sleep((long)10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
    }

    @PostUpdate
    public void onPostUpdate(){

        MenuChanged menuChanged = new MenuChanged();
        BeanUtils.copyProperties(this, menuChanged);
        menuChanged.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove(){
        MenuDeleted menuDeleted = new MenuDeleted();
        BeanUtils.copyProperties(this, menuDeleted);
        menuDeleted.publishAfterCommit();

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
