package cn.edu.tongji.uniplus.order.model;

public enum StatusEnum {
    UNPAID(0, "未付款"),
    PAID(1, "已付款"),
    SHIPPED(2, "已发货"),
    RECEIVED(3, "已收货"),
    EVALUATED(4, "已评价"),
    REVOKED(-1, "已撤销"),
    REFUNDED(-2, "已退款");

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