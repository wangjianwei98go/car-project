package cn.lnj.project.car.dao;

import cn.lnj.project.car.data.carId;
import org.springframework.stereotype.Repository;

@Repository
public interface CarIdDao {
    carId  selectBycarid(String carid);
}
