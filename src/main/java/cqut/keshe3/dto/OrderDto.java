package cqut.keshe3.dto;

import cqut.keshe3.domain.Order;
import lombok.Data;

@Data
public class OrderDto extends Order {

    // 用户名
    private String username;

    // 车名
    private String carName;

}
