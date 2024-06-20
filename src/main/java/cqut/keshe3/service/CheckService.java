package cqut.keshe3.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import cqut.keshe3.domain.Check;
import cqut.keshe3.dto.CheckDto;

import java.util.List;

/**
* @author MaplesukiD
* @description 针对表【check】的数据库操作Service
* @createDate 2024-05-30 22:24:05
*/
public interface CheckService extends IService<Check> {
    // 检查单分页
    Page<CheckDto> getCheckPage(String carNumber, String startDate, String endDate, String status, Integer currentPage, Integer pageSize);

    // 根据车辆id查询所有的检查单信息
    List<Check> getByCarId(Integer carId);
}
