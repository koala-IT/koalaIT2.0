package com.koalaIT.common.util;


public enum TransacTypeVariable {
        RECHARGE("充值","01"),PROFIT_DEDUCTION("做单","02"),SALE("售卖","04"),
                  WITHDRAWS("提现","05"),RAKEBACK("返佣","06"),REBATE("返利","11"),CONSUME("消费","12"),INTEREST("提现手续费","13"),
                    A_SCORE("云豆","A"),B_SCORE("代金券","B"),PAIFA_SCORE("派发积分","03");
    private String type;
    private String typeName;

    // 构造方法
    private TransacTypeVariable(String typeName, String type) {
        this.type = type;
        this.typeName = typeName;
    }

    // 普通方法
    public static String getName(String type) {
        for (TransacTypeVariable c : TransacTypeVariable.values()) {
            if (c.getType().equals(type)) {
                return c.getTypeName();
            }
        }
        return null;
    }

    // get set 方法
    public String getTypeName() {
        return this.typeName;
    }

    public void setTypeName(String name) {
        this.typeName = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
