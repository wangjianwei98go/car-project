package cn.lnj.project.car.controller;

import cn.lnj.project.car.data.Order;
import cn.lnj.project.car.data.Shop;
import cn.lnj.project.car.data.User;
import cn.lnj.project.car.service.CarService;
import cn.lnj.project.car.service.OrderService;
import cn.lnj.project.car.service.ShopService;
import cn.lnj.project.car.service.UserService;
import cn.lnj.project.car.util.SendMail;
import com.sun.org.apache.xpath.internal.operations.Or;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 订单控制层，用户确定租车后发送 用户id，车辆id，商家id
 *
 * @author 刘乃杰
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private CarService carService;
    @Autowired
    private SendMail sendMail;
    @Autowired
    private UserService userService;
    @Autowired
    private ShopService shopService;


    /**
     * 用户完成租赁后，向订单表新增记录，车辆表更新数据，数量减少,用户的租赁次数加一
     *
     * @param carId  车辆id
     * @param userId 用户id
     * @param shopId 商家id
     * @param price  价格
     * @param count  数量
     */
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    @ResponseBody()
    public void insert(@RequestParam String carId, String userId, String shopId, double price, int count, int day) {
        //订单表插入数据
        orderService.insertOrder(carId, userId, shopId, price, day);
        carService.updateCarAmount(carId, count);
        User user = userService.selectUser(userId);
        //用户表更新租赁次数
        User user1 = new User();
        user1.setUserId(userId);
        user1.setRentCount(user.getRentCount() + 1);
        userService.updateUser(user1);
        // 租赁成功后给用户和商家发送邮件，先屏蔽
        // Shop shop= shopService.selectShop(shopId);
        //sendMail.successInform(user.getUserEmail(),user.getUserName(),shop.getShopEmail(),shop.getShopName(),shop.getShopPhone());
    }

    /**
     * 查询订单， 根据用户id查询用户的订单
     *
     * @param userId 用户id
     * @return
     */
    @RequestMapping(value = "/userId", method = RequestMethod.GET)
    @ResponseBody()
    public JSONObject selectByUserId(@RequestParam String userId) {
        return null;
    }

    /**
     * 用户续租
     *
     * @param userId 用户id
     * @param price  价格
     * @param count  数量
     */
    @RequestMapping(value = "/again", method = RequestMethod.GET)
    @ResponseBody()
    public void again(@RequestParam String orderId, String userId, double price, int count, int day) {
        //编辑订单表更新数据数据
        //orderService.insertOrder(carId,userId,shopId,price,day);
        // carService.updateCarAmount(carId,count);
        Order order = new Order();
        Order order1 = orderService.FindById(orderId);
        order.setOrderId(orderId);
        order.setPrice(price + order1.getPrice());
        long l = new Long((long) day);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format1.parse(order1.getEndTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date date1 = addDate(date, l);
        String endtime = formatter.format(date1);
        order.setEndTime(endtime);
        orderService.editOrder(order);
        User user = userService.selectUser(userId);
        //用户表更新租赁次数
        User user1 = new User();
        user1.setUserId(userId);
        user1.setRentCount(user.getRentCount() + 1);
        userService.updateUser(user1);
        // 租赁成功后给用户和商家发送邮件，先屏蔽
        // Shop shop= shopService.selectShop(shopId);
        //sendMail.successInform(user.getUserEmail(),user.getUserName(),shop.getShopEmail(),shop.getShopName(),shop.getShopPhone());
    }

    public static Date addDate(Date date, long day) {
        long time = date.getTime(); // 得到指定日期的毫秒数
        day = day * 24 * 60 * 60 * 1000; // 要加上的天数转换成毫秒数
        time += day; // 相加得到新的毫秒数
        return new Date(time); // 将毫秒数转换成日期
    }
}
