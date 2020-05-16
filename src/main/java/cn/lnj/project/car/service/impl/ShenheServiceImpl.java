package cn.lnj.project.car.service.impl;

import cn.lnj.project.car.dao.CarDao;
import cn.lnj.project.car.dao.OrderDao;
import cn.lnj.project.car.dao.ShenheDao;
import cn.lnj.project.car.dao.ShopDao;
import cn.lnj.project.car.data.Order;
import cn.lnj.project.car.data.Shenhe;
import cn.lnj.project.car.data.Shop;
import cn.lnj.project.car.service.ShenheService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShenheServiceImpl implements ShenheService {

    @Autowired
    private ShenheDao shenheDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private CarDao carDao;
    @Autowired
    private ShopDao shopDao;

    @Override
    public void insert(Shenhe shenhe) {
        shenheDao.insert(shenhe);
    }

    @Override
    public JSONObject selectShopAdmin(String orderid) {
        Shenhe car = shenheDao.selectShopAdmin(orderid);
        Order order = orderDao.FindById(orderid);
        Shop shop1 = shopDao.selectById(order.getShopId());
        JSONObject result = new JSONObject();
        result.put("infoType", "car");
        if (car != null) {
            JSONObject info = new JSONObject();
            info.put("carBrand", car.getStyle());
            info.put("carName", shop1.getShopName());
            info.put("orderid", orderid);

            String[] imagesAll = car.getCarImage().split(",");
            List images = new ArrayList();
            for (String image : imagesAll) {
                if (!"".equals(image) && image != null) {
                    images.add(image);
                }
            }
            info.put("carImages", images);
            info.put("carPrice", car.getMoney());
            info.put("carInfo", car.getMessage());

            String shopId = order.getShopId();
            Shop shop = shopDao.selectById(shopId);
            info.put("shopId", shop.getShopId());
            info.put("shopName", shop.getShopName());
            info.put("shopLocation", shop.getShopLocation());
            info.put("shopPhone", shop.getShopPhone());
            info.put("shopJingDu", shop.getJingDu());
            info.put("shopWeiDu", shop.getWeidu());
            result.put("info", info);
        }

        return result;
    }

    @Override
    public JSONObject selectShopAdmin1(String orderid) {
        Shenhe car = shenheDao.selectShopAdmin(orderid);
        Order order = orderDao.FindById(orderid);
        Shop shop1 = shopDao.selectById(order.getShopId());
        JSONObject result = new JSONObject();
        result.put("infoType", "car");
        if (car != null) {
            JSONObject info = new JSONObject();
            info.put("carBrand", car.getStyle());
            info.put("carName", shop1.getShopName());
            info.put("orderid", orderid);
            if (car.getDel().equals("0")) {
                info.put("carAmount", "用户未支付罚款");
            }
            if (car.getDel().equals("1")) {
                info.put("carAmount", "用户成功支付罚款");
            }
            String[] imagesAll = car.getCarImage().split(",");
            List images = new ArrayList();
            for (String image : imagesAll) {
                if (!"".equals(image) && image != null) {
                    images.add(image);
                }
            }
            info.put("carImages", images);
            info.put("carPrice", car.getMoney());
            info.put("carInfo", car.getMessage());

            String shopId = order.getShopId();
            Shop shop = shopDao.selectById(shopId);
            info.put("shopId", shop.getShopId());
            info.put("shopName", shop.getShopName());
            info.put("shopLocation", shop.getShopLocation());
            info.put("shopPhone", shop.getShopPhone());
            info.put("shopJingDu", shop.getJingDu());
            info.put("shopWeiDu", shop.getWeidu());
            result.put("info", info);
        }

        return result;
    }

    @Override
    public void updateshenhe(String orderid){
        shenheDao.updateshenhe(orderid);
    };
}
