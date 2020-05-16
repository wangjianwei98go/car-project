package cn.lnj.project.car.service;


import cn.lnj.project.car.data.Shenhe;
import net.sf.json.JSONObject;

public interface ShenheService {


    /**
     * 插入商家
     *
     * @param shenhe 商家
     */
    void insert(Shenhe shenhe);


    /**
     * 查询一个商家下的所有管理员
     *
     * @param orderid 商家id
     * @return
     */
    JSONObject selectShopAdmin(String orderid);
    /**
     * 查询一个商家下的所有管理员
     *
     * @param orderid 商家id
     * @return
     */
    JSONObject selectShopAdmin1(String orderid);

  public   void updateshenhe(String orderid);
}
