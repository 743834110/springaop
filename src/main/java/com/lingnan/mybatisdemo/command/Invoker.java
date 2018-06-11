package com.lingnan.mybatisdemo.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/6/8.
 */
public class Invoker{

    private CommandVo commandVo = CommandVo.getInstance();
    private List<String> options = CommandEnum.getOptions();
    private Map<String, String> stringMap = new HashMap<String, String>(){
        {
            this.put("1", "ONE");
            this.put("2", "TWO");
            this.put("3", "THREE");
        }
    };

    /**
     * 执行命令
     * @param commandString
     * @return
     */
    public String execute(String commandString){

        String result = null;
        if (this.commandVo.getSize() != 0)
            result = this.commandVo.getBase();
        else
            result = commandString;
        if (this.options.contains(result)){
            String className = CommandEnum.valueOf(this.stringMap.get(result))
                    .getClassName();
            try {
                Command command = (Command) Class.forName(className).newInstance();
                System.out.println(commandString);
                if (commandVo.getSize() == 0)
                    this.commandVo.input(result);
                result = command.execute(commandVo);
                result  = result.equals("")? this.initString(): result;
                return result;
            } catch (Exception e){
                result = "该命令尚未实现。。。。。。\n";
                e.printStackTrace();
            }
        }
        else
            result = this.initString();
        return result;
    }

    public String initString() {
        StringBuilder builder = new StringBuilder();
        builder.append("###############欢迎使用书籍购买系统###############");
        builder.append("\n");
        builder.append("  请选择登录身份：");
        builder.append("\n");
        builder.append("   1. 普通用户身份登录");
        builder.append("\n");
        builder.append("   2. 管理员身份登录");
        builder.append("\n");
        builder.append("   3. 超级管理员身份登录");
        builder.append("\n");
        builder.append("################################################");
        builder.append("\n");
        return builder.toString();
    }
}
