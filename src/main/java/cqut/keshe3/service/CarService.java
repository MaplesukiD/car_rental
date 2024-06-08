package cqut.keshe3.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cqut.keshe3.Exception.CommonException;
import cqut.keshe3.domain.Car;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author MaplesukiD
* @description 针对表【car】的数据库操作Service
* @createDate 2024-05-30 22:23:33
*/
public interface CarService extends IService<Car> {

    // 汽车入库
    void saveCar(Car car) throws CommonException;

    // 更新汽车信息
    void updateCar(Car car) throws CommonException;

    // 汽车出库
    void deleteById(Integer id) throws CommonException;

    // 汽车分页
    Page<Car> getCarPage(int currentPage, int pageSize, String carName, String color, String carType);
}
