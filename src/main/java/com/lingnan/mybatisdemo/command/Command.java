package com.lingnan.mybatisdemo.command;

/**
 * Created by Administrator on 2018/6/8.
 * 表层为命令模式
 * 里层为责任链模式
 */
public abstract class Command {

    public String execute(CommandVo commandVo){
        CommandName commandName = this.buildChain();
        if (commandName != null)
            return commandName.handleMessage(commandVo, 1);
        System.out.println("   该功能尚未实现！！！");
        commandVo.pop();
        return "";
    }

    /**
     * 建立处理链
     */
    protected abstract CommandName buildChain();

}
