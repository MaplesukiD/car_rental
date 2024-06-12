package cqut.keshe3.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 
 * @TableName check
 */
@TableName(value = "`check`")
public class Check implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 检修日期
     */
    private LocalDateTime checkDate;

    /**
     * 车辆id
     */
    private Integer carId;

    /**
     * 异常信息
     */
    private String error;

    /**
     * 检查得分 0 - 100 100分不扣钱
     */
    private Integer score;

    /**
     * 租车人id
     */
    private Integer userId;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 0未处理 1处理
     */
    private Integer status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    public Integer getId() {
        return id;
    }

    /**
     * id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 检修日期
     */
    public LocalDateTime getCheckDate() {
        return checkDate;
    }

    /**
     * 检修日期
     */
    public void setCheckDate(LocalDateTime checkDate) {
        this.checkDate = checkDate;
    }

    /**
     * 车辆id
     */
    public Integer getCarId() {
        return carId;
    }

    /**
     * 车辆id
     */
    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    /**
     * 异常信息
     */
    public String getError() {
        return error;
    }

    /**
     * 异常信息
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * 检查得分 0 - 100 100分不扣钱
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 检查得分 0 - 100 100分不扣钱
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 租车人id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 租车人id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 订单id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 订单id
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * 0未处理 1处理
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 0未处理 1处理
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Check other = (Check) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCheckDate() == null ? other.getCheckDate() == null : this.getCheckDate().equals(other.getCheckDate()))
            && (this.getCarId() == null ? other.getCarId() == null : this.getCarId().equals(other.getCarId()))
            && (this.getError() == null ? other.getError() == null : this.getError().equals(other.getError()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCheckDate() == null) ? 0 : getCheckDate().hashCode());
        result = prime * result + ((getCarId() == null) ? 0 : getCarId().hashCode());
        result = prime * result + ((getError() == null) ? 0 : getError().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", checkDate=").append(checkDate);
        sb.append(", carId=").append(carId);
        sb.append(", error=").append(error);
        sb.append(", score=").append(score);
        sb.append(", userId=").append(userId);
        sb.append(", orderId=").append(orderId);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}