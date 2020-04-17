package com.hyc.lifeway.module.user.enums;

/**
 * @Author ：胡友成
 * @Date ：2020/4/17 9:46 下午
 * @Description：
 */
public enum UserTaskStatus {

    // 未接受
    UNACCEPTED(0),
    // 已接受未开始
    ACCEPTED(1),
    // 进行中
    DOING(2),
    // 已完成
    FINISHED(3);

    private int status;

    UserTaskStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public UserTaskStatus toEnum(Integer status) {
        if (status == null) {
            return null;
        }

        for (UserTaskStatus statusEnum : values()) {
            if (statusEnum.status == status) {
                return statusEnum;
            }
        }

        return null;
    }
}
