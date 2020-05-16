package cn.lnj.project.car.data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="shenhe")
public class Shenhe {

    @Id
    private String id;
    @Column(name = "orderid")
    private String orderid;
    @Column(name="car_image")
    private String carImage;
    @Column(name = "del")
    private String del;
    @Column(name = "message")
    private String message;
    @Column(name = "money")
    private String money;
    @Column(name = "userid")
    private String userid;
    @Column(name = "style")
    private String style;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getCarImage() {
        return carImage;
    }

    public void setCarImage(String carImage) {
        this.carImage = carImage;
    }

    public String getDel() {
        return del;
    }

    public void setDel(String del) {
        this.del = del;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }



}
