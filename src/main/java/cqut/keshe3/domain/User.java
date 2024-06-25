package cqut.keshe3.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import cqut.keshe3.dto.UserRegisterDto;

import java.io.Serializable;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
public class User implements Serializable {
    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 身份证号
     */
    private String identity;

    /**
     * 真名
     */
    private String realName;

    /**
     * 性别 0-男 1-女
     */
    private Integer sex;

    /**
     * 地址
     */
    private String address;

    /**
     * 类型 0-管理 1-用户
     */
    private Integer type;

    /**
     * 活跃状态 0-禁用 1-活跃
     */
    private Integer available;

    /**
     * 头像
     */
    private String img;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 用户id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 身份证号
     */
    public String getIdentity() {
        return identity;
    }

    /**
     * 身份证号
     */
    public void setIdentity(String identity) {
        this.identity = identity;
    }

    /**
     * 真名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 真名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 性别 0-男 1-女
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 性别 0-男 1-女
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 类型 0-管理 1-用户
     */
    public Integer getType() {
        return type;
    }

    /**
     * 类型 0-管理 1-用户
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 活跃状态 0-禁用 1-活跃
     */
    public Integer getAvailable() {
        return available;
    }

    /**
     * 活跃状态 0-禁用 1-活跃
     */
    public void setAvailable(Integer available) {
        this.available = available;
    }

    /**
     * 头像
     */
    public String getImg() {
        return img;
    }

    /**
     * 头像
     */
    public void setImg(String img) {
        this.img = img;
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
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getIdentity() == null ? other.getIdentity() == null : this.getIdentity().equals(other.getIdentity()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getAvailable() == null ? other.getAvailable() == null : this.getAvailable().equals(other.getAvailable()))
            && (this.getImg() == null ? other.getImg() == null : this.getImg().equals(other.getImg()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getIdentity() == null) ? 0 : getIdentity().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getAvailable() == null) ? 0 : getAvailable().hashCode());
        result = prime * result + ((getImg() == null) ? 0 : getImg().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", identity=").append(identity);
        sb.append(", realName=").append(realName);
        sb.append(", sex=").append(sex);
        sb.append(", address=").append(address);
        sb.append(", type=").append(type);
        sb.append(", available=").append(available);
        sb.append(", img=").append(img);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public User(UserRegisterDto userRegisterDto){
        this.realName = userRegisterDto.getRealName();
        this.username = userRegisterDto.getUsername();
        this.password = userRegisterDto.getPassword();
        this.identity = userRegisterDto.getIdentity();
        this.sex = userRegisterDto.getSex();
        this.address = "";
        for (int i = 0; i < userRegisterDto.getAddress().length; i++) {
            this.address += userRegisterDto.getAddress()[i];
        }
        this.img = userRegisterDto.getImg();
    }
}