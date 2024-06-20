package cqut.keshe3.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import cqut.keshe3.common.Code;
import cqut.keshe3.common.Result;
import cqut.keshe3.domain.Check;
import cqut.keshe3.dto.CheckDto;
import cqut.keshe3.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MaplesukiD
 * @since 2024/6/2 16:59
 */

@RestController
@RequestMapping("/check")
public class CheckController {


    @Autowired
    private CheckService checkService;

    @PostMapping
    public Result<String> save(@RequestBody Check check) {
        if(checkService.save(check)) {
            return new Result<>(Code.SAVE_OK, Code.SAVE_OK_MESSAGE);
        }
        return new Result<>(Code.SAVE_ERR,Code.SAVE_ERR_MESSAGE);
    }

    @DeleteMapping
    public Result<String> deleteById(@RequestParam Integer id){
        if(checkService.removeById(id)){
            return new Result<>(Code.DELETE_OK, Code.DELETE_OK_MESSAGE);
        }
        return new Result<>(Code.DELETE_ERR,Code.DELETE_ERR_MESSAGE);
    }

    @PutMapping
    public Result<String> update(@RequestBody Check check){
        if(checkService.saveOrUpdate(check)){
            return new Result<>(Code.UPDATE_OK, Code.UPDATE_OK_MESSAGE);
        }
        return new Result<>(Code.UPDATE_ERR,Code.UPDATE_ERR_MESSAGE);
    }

    @GetMapping
    public Result<Check> getById(@RequestParam Integer id){
        Check check = checkService.getById(id);
        if(check != null){
            return new Result<>(Code.GET_OK, check, Code.GET_OK_MESSAGE);
        }
        return new Result<>(Code.GET_ERR, Code.GET_ERR_MESSAGE);
    }

    @GetMapping("/page")
    public Result<Page> getPage(@RequestParam String carNumber,@RequestParam String startDate, @RequestParam String endDate, @RequestParam String status,@RequestParam Integer currentPage, @RequestParam Integer pageSize) {
        Page<CheckDto> checkPage = checkService.getCheckPage(carNumber,startDate,endDate,status,currentPage, pageSize);
        return new Result<>(Code.GET_OK, checkPage, Code.GET_OK_MESSAGE);
    }

    @GetMapping("/{carId}")
    public Result<List<Check>> getByCarId(@PathVariable("carId") Integer carId) {
        List<Check> checkList = checkService.getByCarId(carId);
        return new Result<>(Code.GET_OK, checkList, Code.GET_OK_MESSAGE);
    }
}
