package cqut.keshe3.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @TableName car
 */
@TableName(value ="car")
public class Car implements Serializable {
    /**
     * 车id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 车名
     */
    private String carName;

    /**
     * 车牌号
     */
    private String carNumber;

    /**
     * 类型
     */
    private String carType;

    /**
     * 颜色
     */
    private String color;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 租赁价格/天
     */
    private BigDecimal rentPrice;

    /**
     * 押金
     */
    private Integer deposit;

    /**
     * 图片
     */
    private String img;

    /**
     * 0-油车 1-电车
     */
    private Integer electric;

    /**
     * 座位数
     */
    private Integer seat;

    /**
     * 门数
     */
    private Integer door;

    /**
     * 0-手动 1-自动
     */
    private Integer auto;

    /**
     * 动力 (单位：T)
     */
    private BigDecimal motivity;

    /**
     * 0-前驱 1-后驱 2-四驱
     */
    private Integer drive;

    /**
     * 汽油型号（92、95、98）
     */
    private Integer petrol;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 车id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 车id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 车名
     */
    public String getCarName() {
        return carName;
    }

    /**
     * 车名
     */
    public void setCarName(String carName) {
        this.carName = carName;
    }

    /**
     * 车牌号
     */
    public String getCarNumber() {
        return carNumber;
    }

    /**
     * 车牌号
     */
    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    /**
     * 类型
     */
    public String getCarType() {
        return carType;
    }

    /**
     * 类型
     */
    public void setCarType(String carType) {
        this.carType = carType;
    }

    /**
     * 颜色
     */
    public String getColor() {
        return color;
    }

    /**
     * 颜色
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 租赁价格/天
     */
    public BigDecimal getRentPrice() {
        return rentPrice;
    }

    /**
     * 租赁价格/天
     */
    public void setRentPrice(BigDecimal rentPrice) {
        this.rentPrice = rentPrice;
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
     * 图片
     */
    public String getImg() {
        return img;
    }

    /**
     * 图片
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * 0-油车 1-电车
     */
    public Integer getElectric() {
        return electric;
    }

    /**
     * 0-油车 1-电车
     */
    public void setElectric(Integer electric) {
        this.electric = electric;
    }

    /**
     * 座位数
     */
    public Integer getSeat() {
        return seat;
    }

    /**
     * 座位数
     */
    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    /**
     * 门数
     */
    public Integer getDoor() {
        return door;
    }

    /**
     * 门数
     */
    public void setDoor(Integer door) {
        this.door = door;
    }

    /**
     * 0-手动 1-自动
     */
    public Integer getAuto() {
        return auto;
    }

    /**
     * 0-手动 1-自动
     */
    public void setAuto(Integer auto) {
        this.auto = auto;
    }

    /**
     * 动力 (单位：T)
     */
    public BigDecimal getMotivity() {
        return motivity;
    }

    /**
     * 动力 (单位：T)
     */
    public void setMotivity(BigDecimal motivity) {
        this.motivity = motivity;
    }

    /**
     * 0-前驱 1-后驱 2-四驱
     */
    public Integer getDrive() {
        return drive;
    }

    /**
     * 0-前驱 1-后驱 2-四驱
     */
    public void setDrive(Integer drive) {
        this.drive = drive;
    }

    /**
     * 汽油型号（92、95、98）
     */
    public Integer getPetrol() {
        return petrol;
    }

    /**
     * 汽油型号（92、95、98）
     */
    public void setPetrol(Integer petrol) {
        this.petrol = petrol;
    }

    /**
     * 状态
     */
    public Integer getState() {
        return state;
    }

    /**
     * 状态
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述
     */
    public void setDescription(String description) {
        this.description = description;
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
        Car other = (Car) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCarName() == null ? other.getCarName() == null : this.getCarName().equals(other.getCarName()))
            && (this.getCarNumber() == null ? other.getCarNumber() == null : this.getCarNumber().equals(other.getCarNumber()))
            && (this.getCarType() == null ? other.getCarType() == null : this.getCarType().equals(other.getCarType()))
            && (this.getColor() == null ? other.getColor() == null : this.getColor().equals(other.getColor()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getRentPrice() == null ? other.getRentPrice() == null : this.getRentPrice().equals(other.getRentPrice()))
            && (this.getDeposit() == null ? other.getDeposit() == null : this.getDeposit().equals(other.getDeposit()))
            && (this.getImg() == null ? other.getImg() == null : this.getImg().equals(other.getImg()))
            && (this.getElectric() == null ? other.getElectric() == null : this.getElectric().equals(other.getElectric()))
            && (this.getSeat() == null ? other.getSeat() == null : this.getSeat().equals(other.getSeat()))
            && (this.getDoor() == null ? other.getDoor() == null : this.getDoor().equals(other.getDoor()))
            && (this.getAuto() == null ? other.getAuto() == null : this.getAuto().equals(other.getAuto()))
            && (this.getMotivity() == null ? other.getMotivity() == null : this.getMotivity().equals(other.getMotivity()))
            && (this.getDrive() == null ? other.getDrive() == null : this.getDrive().equals(other.getDrive()))
            && (this.getPetrol() == null ? other.getPetrol() == null : this.getPetrol().equals(other.getPetrol()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCarName() == null) ? 0 : getCarName().hashCode());
        result = prime * result + ((getCarNumber() == null) ? 0 : getCarNumber().hashCode());
        result = prime * result + ((getCarType() == null) ? 0 : getCarType().hashCode());
        result = prime * result + ((getColor() == null) ? 0 : getColor().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getRentPrice() == null) ? 0 : getRentPrice().hashCode());
        result = prime * result + ((getDeposit() == null) ? 0 : getDeposit().hashCode());
        result = prime * result + ((getImg() == null) ? 0 : getImg().hashCode());
        result = prime * result + ((getElectric() == null) ? 0 : getElectric().hashCode());
        result = prime * result + ((getSeat() == null) ? 0 : getSeat().hashCode());
        result = prime * result + ((getDoor() == null) ? 0 : getDoor().hashCode());
        result = prime * result + ((getAuto() == null) ? 0 : getAuto().hashCode());
        result = prime * result + ((getMotivity() == null) ? 0 : getMotivity().hashCode());
        result = prime * result + ((getDrive() == null) ? 0 : getDrive().hashCode());
        result = prime * result + ((getPetrol() == null) ? 0 : getPetrol().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", carName=").append(carName);
        sb.append(", carNumber=").append(carNumber);
        sb.append(", carType=").append(carType);
        sb.append(", color=").append(color);
        sb.append(", price=").append(price);
        sb.append(", rentPrice=").append(rentPrice);
        sb.append(", deposit=").append(deposit);
        sb.append(", img=").append(img);
        sb.append(", electric=").append(electric);
        sb.append(", seat=").append(seat);
        sb.append(", door=").append(door);
        sb.append(", auto=").append(auto);
        sb.append(", motivity=").append(motivity);
        sb.append(", drive=").append(drive);
        sb.append(", petrol=").append(petrol);
        sb.append(", state=").append(state);
        sb.append(", description=").append(description);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
