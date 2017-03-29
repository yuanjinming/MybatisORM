package dao.model;

import dao.mapper.PmsUserMapper;
import java.util.Date;

import common.mybatis.BaseEntity;


public class PmsUser extends BaseEntity<Long, PmsUserMapper> {
    /**
     * ID
     */
    private Long id;

    /**
     * version
     */
    private Integer version;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 用户帐号
     */
    private String userNo;

    /**
     * 用户类型（1:超级管理员，2:普通管理员，3:用户主帐号，4:用户子帐号）
     */
    private String userType;

    /**
     * 主帐号ID
     */
    private Long mainUserId;

    /**
     * 登录密码
     */
    private String userPwd;

    /**
     * 姓名
     */
    private String userName;

    /**
     * 手机号
     */
    private String mobileNo;

    /**
     * 邮箱
     */
    private byte[] email;

    /**
     * 状态(100:可用，101:不可用 )
     */
    private Integer status;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 是否更改过密码
     */
    private Integer isChangedPwd;

    /**
     * 连续输错密码次数
     */
    private Integer pwdErrorCount;

    /**
     * 最后输错密码时间
     */
    private Date pwdErrorTime;

    /**
     * 备注
     */
    private String remark;

    @Override
    public Long getPrimaryKey() {
        return id;
    }

    @Override
    public String tableName() {
        return DB.tableName;
    }

    /**
     * id ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    @Deprecated
    @Override
    public void setDefaultValues() {
        if (null == this.version) {
            this.version = 0;
        }
        if (null == this.createTime) {
            this.createTime = new Date();
        }
        if (null == this.mainUserId) {
            this.mainUserId = 0l;
        }
        if (null == this.pwdErrorCount) {
            this.pwdErrorCount = 0;
        }
    }

    /**
     * 获取version
     * version version
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置version
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 获取创建时间
     * create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取用户帐号
     * user_no 用户帐号
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     * 设置用户帐号
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    /**
     * 获取用户类型（1:超级管理员，2:普通管理员，3:用户主帐号，4:用户子帐号）
     * user_type 用户类型（1:超级管理员，2:普通管理员，3:用户主帐号，4:用户子帐号）
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 设置用户类型（1:超级管理员，2:普通管理员，3:用户主帐号，4:用户子帐号）
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * 获取主帐号ID
     * main_user_id 主帐号ID
     */
    public Long getMainUserId() {
        return mainUserId;
    }

    /**
     * 设置主帐号ID
     */
    public void setMainUserId(Long mainUserId) {
        this.mainUserId = mainUserId;
    }

    /**
     * 获取登录密码
     * user_pwd 登录密码
     */
    public String getUserPwd() {
        return userPwd;
    }

    /**
     * 设置登录密码
     */
    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    /**
     * 获取姓名
     * user_name 姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取手机号
     * mobile_no 手机号
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * 设置手机号
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * 获取邮箱
     * email 邮箱
     */
    public byte[] getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     */
    public void setEmail(byte[] email) {
        this.email = email;
    }

    /**
     * 获取状态(100:可用，101:不可用 )
     * status 状态(100:可用，101:不可用 )
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态(100:可用，101:不可用 )
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取最后登录时间
     * last_login_time 最后登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置最后登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取是否更改过密码
     * is_changed_pwd 是否更改过密码
     */
    public Integer getIsChangedPwd() {
        return isChangedPwd;
    }

    /**
     * 设置是否更改过密码
     */
    public void setIsChangedPwd(Integer isChangedPwd) {
        this.isChangedPwd = isChangedPwd;
    }

    /**
     * 获取连续输错密码次数
     * pwd_error_count 连续输错密码次数
     */
    public Integer getPwdErrorCount() {
        return pwdErrorCount;
    }

    /**
     * 设置连续输错密码次数
     */
    public void setPwdErrorCount(Integer pwdErrorCount) {
        this.pwdErrorCount = pwdErrorCount;
    }

    /**
     * 获取最后输错密码时间
     * pwd_error_time 最后输错密码时间
     */
    public Date getPwdErrorTime() {
        return pwdErrorTime;
    }

    /**
     * 设置最后输错密码时间
     */
    public void setPwdErrorTime(Date pwdErrorTime) {
        this.pwdErrorTime = pwdErrorTime;
    }

    /**
     * 获取备注
     * remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static class DB {
        public static final String primaryKey = "id";

        public static final String tableName = "edu_edmo_pms_user";

        /**
         * ID
         */
        public static final String id = "id";

        /**
         * version
         */
        public static final String version = "version";

        /**
         * 创建时间
         */
        public static final String createTime = "create_time";

        /**
         * 用户帐号
         */
        public static final String userNo = "user_no";

        /**
         * 用户类型（1:超级管理员，2:普通管理员，3:用户主帐号，4:用户子帐号）
         */
        public static final String userType = "user_type";

        /**
         * 主帐号ID
         */
        public static final String mainUserId = "main_user_id";

        /**
         * 登录密码
         */
        public static final String userPwd = "user_pwd";

        /**
         * 姓名
         */
        public static final String userName = "user_name";

        /**
         * 手机号
         */
        public static final String mobileNo = "mobile_no";

        /**
         * 邮箱
         */
        public static final String email = "email";

        /**
         * 状态(100:可用，101:不可用 )
         */
        public static final String status = "status";

        /**
         * 最后登录时间
         */
        public static final String lastLoginTime = "last_login_time";

        /**
         * 是否更改过密码
         */
        public static final String isChangedPwd = "is_changed_pwd";

        /**
         * 连续输错密码次数
         */
        public static final String pwdErrorCount = "pwd_error_count";

        /**
         * 最后输错密码时间
         */
        public static final String pwdErrorTime = "pwd_error_time";

        /**
         * 备注
         */
        public static final String remark = "remark";
    }
}