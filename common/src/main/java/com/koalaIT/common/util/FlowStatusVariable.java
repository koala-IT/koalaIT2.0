package com.koalaIT.common.util;

public enum FlowStatusVariable {
    WAITING_FOR_REVIEW("待处理",0),AGENT_PASSED("代理商审核通过",1),AGENT_NOT_PASSED("代理商审核未通过",-1),REVIEW_PASSED("审核通过",2),
            ADMIN_NOT_PASSED("平台审核未通过",-2),ALLOWANCE_SENT("已派发",3),COMPLETED("已完成",4);

    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private FlowStatusVariable(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 普通方法
    public static String getName(int index) {
        for (FlowStatusVariable c : FlowStatusVariable.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    // get set 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
