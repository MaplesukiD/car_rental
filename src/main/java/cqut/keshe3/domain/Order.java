package cqut.keshe3.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 
 * @TableName order
 */
@TableName(value ="`order`")
public class Order implements Serializable {
    /**
     * 订单id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 车辆id
     */
    private Integer carId;

    /**
     * 检查单id
     */
    private Integer checkId;

    /**
     * 押金
     */
    private Integer deposit;

    /**
     * 租赁价格
     */
    private BigDecimal rentPrice;

    /**
     * 租赁天数
     */
    private Integer days;

    /**
     * 总支付
     */
    private BigDecimal total;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 0-进行中 1-等待检查单 2-订单完成
     */
    private Integer status;

    /**
     * 扣除押金（详情见检查单）
     */
    private Integer deductionDeposit;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 订单id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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
     * 检查单id
     */
    public Integer getCheckId() {
        return checkId;
    }

    /**
     * 检查单id
     */
    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    /**
     * 押金
     */
    public Integer getDeposit() {
        return deposit;
    }

    /**
     * 押金
     */
    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    /**
     * 租赁价格
     */
    public BigDecimal getRentPrice() {
        return rentPrice;
    }

    /**
     * 租赁价格
     */
    public void setRentPrice(BigDecimal rentPrice) {
        this.rentPrice = rentPrice;
    }

    /**
     * 租赁天数
     */
    public Integer getDays() {
        return days;
    }

    /**
     * 租赁天数
     */
    public void setDays(Integer days) {
        this.days = days;
    }

    /**
     * 总支付
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * 总支付
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    /**
     * 创建时间
     */
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**
     * 0-进行中 1-等待检查单 2-订单完成
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 0-进行中 1-等待检查单 2-订单完成
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 扣除押金（详情见检查单）
     */
    public Integer getDeductionDeposit() {
        return deductionDeposit;
    }

    /**
     * 扣除押金（详情见检查单）
     */
    public void setDeductionDeposit(Integer deductionDeposit) {
        this.deductionDeposit = deductionDeposit;
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
        Order other = (Order) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCarId() == null ? other.getCarId() == null : this.getCarId().equals(other.getCarId()))
            && (this.getCheckId() == null ? other.getCheckId() == null : this.getCheckId().equals(other.getCheckId()))
            && (this.getDeposit() == null ? other.getDeposit() == null : this.getDeposit().equals(other.getDeposit()))
            && (this.getRentPrice() == null ? other.getRentPrice() == null : this.getRentPrice().equals(other.getRentPrice()))
            && (this.getDays() == null ? other.getDays() == null : this.getDays().equals(other.getDays()))
            && (this.getTotal() == null ? other.getTotal() == null : this.getTotal().equals(other.getTotal()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getDeductionDeposit() == null ? other.getDeductionDeposit() == null : this.getDeductionDeposit().equals(other.getDeductionDeposit()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCarId() == null) ? 0 : getCarId().hashCode());
        result = prime * result + ((getCheckId() == null) ? 0 : getCheckId().hashCode());
        result = prime * result + ((getDeposit() == null) ? 0 : getDeposit().hashCode());
        result = prime * result + ((getRentPrice() == null) ? 0 : getRentPrice().hashCode());
        result = prime * result + ((getDays() == null) ? 0 : getDays().hashCode());
        result = prime * result + ((getTotal() == null) ? 0 : getTotal().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getDeductionDeposit() == null) ? 0 : getDeductionDeposit().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", carId=").append(carId);
        sb.append(", checkId=").append(checkId);
        sb.append(", deposit=").append(deposit);
        sb.append(", rentPrice=").append(rentPrice);
        sb.append(", days=").append(days);
        sb.append(", total=").append(total);
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
        sb.append(", deductionDeposit=").append(deductionDeposit);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}