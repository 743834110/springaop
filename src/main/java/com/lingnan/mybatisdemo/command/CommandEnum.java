package com.lingnan.mybatisdemo.command;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/11.
 */
public enum CommandEnum {

    ONE("common.CommonCommand", "1"),
    TWO("admin.AdminCommand", "2"),
    THREE("superadmin.SuperAdminCommand", "3");


    private String className;
    private static final String PREFIX = "com.lingnan.mybatisdemo.command.";
    private String selection;
    CommandEnum(String element, String selection){
        this.className = PREFIX + element;
        this.selection = selection;
    }

    public static List<String> getOptions(){
        List<String> list = new ArrayList<>();
        for (CommandEnum elem: CommandEnum.values())
            list.add(elem.selection);
        return list;
    }
    public String getClassName() {
        return className;
    }

    @Override
    public String toString() {
        return "CommandEnum{" +
                "className='" + className + '\'' +
                ", selection=" + selection +
                '}';
    }
}
