package com.lingnan.mybatisdemo.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/6/8.
 */
public class CommandVo {

    private static CommandVo commandVo = new CommandVo();
    private CommandVo(){}
    public static CommandVo getInstance(){
        return commandVo;
    }


    // 历史命令行参数
    private List<String> historyCommands = new ArrayList<>();




    /**
     * 添加命令行参数
     * @param element
     */
    public void input(String element){
        this.historyCommands.add(element);
    }

    //获取历史参数数量
    public int getSize(){
        return this.historyCommands.size();
    }

    /**
     * 获取栈顶元素
     * @return
     */
    public String getTop(){
        return this.historyCommands.get(this.historyCommands.size() - 1);
    }

    /**
     * 获取栈顶元素
     * @return
     */
    public String getBase(){
        return this.historyCommands.get(0);
    }

    /**
     * 弹出上次输入的参数
     * @return
     */
    public void pop(){
        int size = this.historyCommands.size();
        if (size == 0)
            return;
        this.historyCommands.remove(size - 1);
    }

}
