package cqut.keshe3.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 一个自定义的ObjectMapper类，注册JavaTimeModule
 用于解决对Java 8日期和时间类型（如java.time.LocalDateTime）的支持
 */
public class CustomObjectMapper extends ObjectMapper {

    public CustomObjectMapper() {
        registerModule(new JavaTimeModule());
    }

}
