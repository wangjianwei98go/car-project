package cn.lnj.project.car.controller;

public class aaaa {
    public static void main(String[] args) {
        String url = "http://localhost:8085/car/jsp/detail.jsp?carId=2&bookname=3&bookprice=8";
        int params = url.indexOf("?");
        String canshu = url.substring(params + 1);
        int index = canshu.indexOf("=");
        String param = canshu.substring(0,index);
        //参数id
        String id = canshu.substring(index+1);

        System.out.println("canshu: "+canshu);
        System.out.println("param:  "+param);
        System.out.println(id);
    }
}
