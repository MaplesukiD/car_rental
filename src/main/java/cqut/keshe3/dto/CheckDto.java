package cqut.keshe3.dto;

import cqut.keshe3.domain.Check;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author MaplesukiD
 * @since 2024/6/11 19:07
 */

@Data
public class CheckDto extends Check {
    // 用户名
    private String username;
    // 车名
    private String carName;
    //车牌号
    private String carNumber;

}
