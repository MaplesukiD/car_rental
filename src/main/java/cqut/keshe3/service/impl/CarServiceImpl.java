package cqut.keshe3.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cqut.keshe3.domain.Car;
import cqut.keshe3.service.CarService;
import cqut.keshe3.mapper.CarMapper;
import org.springframework.stereotype.Service;

/**
* @author MaplesukiD
* @description 针对表【car】的数据库操作Service实现
* @createDate 2024-05-30 22:23:33
*/
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car>
    implements CarService{

}




