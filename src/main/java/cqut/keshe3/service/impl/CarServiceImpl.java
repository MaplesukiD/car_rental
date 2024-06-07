package cqut.keshe3.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cqut.keshe3.Exception.CommonException;
import cqut.keshe3.domain.Car;
import cqut.keshe3.service.CarService;
import cqut.keshe3.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
* @author MaplesukiD
* @description 针对表【car】的数据库操作Service实现
* @createDate 2024-05-30 22:23:33
*/
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements CarService{

    @Autowired
    private CarMapper carMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    // 汽车入库
    @Override
    public void saveCar(Car car) throws CommonException {
        // 传入数据：车牌号、车类型、颜色、价格、租金/天、押金、描述(可以为空)
        // 缺少数据：创建时间(自动填充)、租借状态

        // 1.添加缺少信息
        car.setState(0);

        // 2.检查车辆是否已经入库
        LambdaQueryWrapper<Car> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Car::getCarNumber, car.getCarNumber());
        Car temp = carMapper.selectOne(lqw);
        if(temp != null){
            throw new CommonException("车辆 " + car.getCarNumber() + " 已在库中");
        }

        // 3.入库
        int flag = carMapper.insert(car);

        // 4.入库失败
        if(flag != 1){
            throw new CommonException("车辆 " + car.getCarNumber() + " 入库失败");
        }
    }

    // 更新汽车信息
    @Override
    public void updateCar(Car car) throws CommonException {
        // 1.更新信息
        int flag = carMapper.updateById(car);

        // 2.更新失败
        if (flag != 1){
            throw new CommonException("车辆 " + car.getCarNumber() + " 更新失败");
        }
    }

    @Override
    public Page<Car> getCarPage(int currentPage, int pageSize) {
        Page<Car> page = new Page<>(currentPage, pageSize);
        return carMapper.selectPage(page, null);
    }

    // 汽车出库
    @Override
    public void deleteById(Integer id) throws CommonException {
        // 1.查看当前车辆的状态
        Car car = carMapper.selectById(id);

        // 2.如果在租 则抛异常
        if(car.getState() == 1){
            throw new CommonException("汽车在租，不能删除！");
        }

        // 3.汽车空闲 执行删除
        int flag = carMapper.deleteById(id);
        // 4.删除失败
        if (flag != 1){
            throw new CommonException("汽车 " + id + " 删除失败");
        }
    }
}




