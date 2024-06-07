package cqut.keshe3.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cqut.keshe3.domain.Car;
import cqut.keshe3.domain.Check;
import cqut.keshe3.service.CheckService;
import cqut.keshe3.mapper.CheckMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author MaplesukiD
* @description 针对表【check】的数据库操作Service实现
* @createDate 2024-05-30 22:24:05
*/
@Service
public class CheckServiceImpl extends ServiceImpl<CheckMapper, Check>
    implements CheckService{

    @Autowired
    private CheckMapper checkMapper;

    @Override
    public Page<Check> getCheckPage(Integer currentPage, Integer pageSize) {
        Page<Check> page = new Page<>(currentPage, pageSize);
        return checkMapper.selectPage(page,null);
    }
}




