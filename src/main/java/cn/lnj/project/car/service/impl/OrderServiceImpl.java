package cn.lnj.project.car.service.impl;

import cn.lnj.project.car.dao.OrderDao;
import cn.lnj.project.car.data.Order;
import cn.lnj.project.car.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;


    @Override
    public void insertOrder(String carId, String userId, String shopId, double price, int day) {
        Order order=new Order();
        order.setOrderId(UUID.randomUUID().toString());
        order.setCarId(carId);
        order.setUserId(userId);
        order.setShopId(shopId);
        order.setPrice(price);
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        order.setOrderTime(dateString);
        long  l=new Long((long)day);
        Date date=addDate(currentTime,l);
        String endtime = formatter.format(date);
        order.setEndTime(endtime);
        orderDao.insert(order);
    }
    public static Date addDate(Date date,long day) {
        long time = date.getTime(); // 得到指定日期的毫秒数
        day = day*24*60*60*1000; // 要加上的天数转换成毫秒数
        time+=day; // 相加得到新的毫秒数
        return new Date(time); // 将毫秒数转换成日期
    }
    @Override
    public void editOrder(Order order){
        orderDao.editOrder(order);
    }
    @Override
    public Order FindById(String orderId){
      return   orderDao.FindById(orderId);
    }
}
