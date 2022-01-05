package cn.edu.tongji.uniplus.notificationcenter.model;

public enum StatusEnum {
    UNSEND(0, "未发送"),
    UNREAD(1, "未读取"),
    READ(2, "已读取");

    private final Integer code;
    private final String name;

    StatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static boolean contains(Integer code) throws
            NullPointerException {
        if (null == code) {
            throw new NullPointerException("constant code is null");
        } else {
            StatusEnum[] var1 = values();
            for (StatusEnum eum : var1) {
                if (code.equals(eum.getCode())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static StatusEnum valueOf(Integer code) throws
            NullPointerException, EnumConstantNotPresentException {
        if (null == code) {
            throw new NullPointerException("constant code is null");
        } else {
            StatusEnum[] var1 = values();
            for (StatusEnum statusEnum : var1) {
                if (code.equals(statusEnum.getCode())) {
                    return statusEnum;
                }
            }
        }
        throw new EnumConstantNotPresentException(StatusEnum.class,
                code.toString());
    }

    public Integer getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }
}