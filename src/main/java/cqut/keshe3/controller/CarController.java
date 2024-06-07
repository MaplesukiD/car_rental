package cqut.keshe3.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cqut.keshe3.Exception.CommonException;
import cqut.keshe3.common.Code;
import cqut.keshe3.common.Result;
import cqut.keshe3.domain.Car;
import cqut.keshe3.service.CarService;
import cqut.keshe3.service.impl.CarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author MaplesukiD
 * @since 2024/6/2 16:58
 */

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    /**
     汽车入库
     * @param car
     * @return: cqut.keshe3.common.Result<java.lang.String>
     */
    @PostMapping
    public Result<String> save(@RequestBody Car car){
        try {
            carService.saveCar(car);
            return new Result<>(Code.SAVE_OK, Code.SAVE_OK_MESSAGE);
        }catch (CommonException e){
            return new Result<>(Code.SAVE_ERR, e.getMessage());
        }
    }

    /**
     更新汽车租借状态
     * @param car
     * @return: cqut.keshe3.common.Result<java.lang.String>
     */
    @PutMapping
    public Result<String> update(@RequestBody Car car){
        try {
            carService.updateCar(car);
            return new Result<>(Code.UPDATE_OK, Code.UPDATE_OK_MESSAGE);
        }catch (CommonException e){
            return new Result<>(Code.UPDATE_ERR, e.getMessage());
        }
    }

    /**
     汽车列表分页查询
     * @param currentPage
     * @param pageSize
     * @return: cqut.keshe3.common.Result<com.baomidou.mybatisplus.extension.plugins.pagination.Page<cqut.keshe3.domain.Car>>
     */
    @GetMapping("/page")
    public Result<Page<Car>> getPage(@RequestParam int currentPage, @RequestParam int pageSize){
        Page<Car> carPage = carService.getCarPage(currentPage, pageSize);
        return new Result<>(Code.GET_OK,carPage,Code.GET_OK_MESSAGE);
    }

    /**
     汽车出库
     * @param id
     * @return: cqut.keshe3.common.Result<java.lang.String>
     */
    @DeleteMapping
    public Result<String> delete(@RequestParam Integer id){
        try {
            carService.deleteById(id);
            return new Result<>(Code.DELETE_OK, Code.DELETE_OK_MESSAGE);
        } catch (CommonException e) {
            return new Result<>(Code.DELETE_ERR, e.getMessage());
        }
    }
}
