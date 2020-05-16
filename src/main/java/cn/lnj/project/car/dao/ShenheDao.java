package cn.lnj.project.car.dao;

import cn.lnj.project.car.data.Admin;
import cn.lnj.project.car.data.Shenhe;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShenheDao {

    /**
     *  插入商家
     * @param shenhe 商家
     */
    void insert(Shenhe shenhe);



    /**
     * 查询一个商家下的所有管理员
     * @param orderid 商家id
     * @return
     */
   Shenhe selectShopAdmin(String orderid);

     void updateshenhe(String orderid);

}
