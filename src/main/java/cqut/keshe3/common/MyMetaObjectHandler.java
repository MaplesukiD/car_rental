package cqut.keshe3.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Date;


/**
 自定义元数据对象处理器
 */
@Configuration
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     插入操作，自动填充
     * @param metaObject
     * @return: void
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        metaObject.setValue("createTime", LocalDateTime.now());
    }

    /**
     更新操作，自动填充
     * @param metaObject
     * @return: void
     */
    @Override
    public void updateFill(MetaObject metaObject) {
//        metaObject.setValue("updateTime", LocalDateTime.now());
    }
}
