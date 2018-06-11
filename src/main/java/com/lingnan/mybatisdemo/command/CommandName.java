package com.lingnan.mybatisdemo.command;

/**
 * Created by Administrator on 2018/6/11.
 */
public abstract class CommandName {

    private CommandName next;

    public CommandName(CommandName next){
        this.next = next;
    }
    /**
     * 判断该命令是否是当前可以处理的命令，
     * 如果不是，将传递为一下个处理点
     * @param commandVo
     * @param handleLevel
     * @return
     */
    public final String handleMessage(CommandVo commandVo, int handleLevel){
        System.out.println(this + ": " + commandVo.getSize());
        int level = getHandleLevel();
        if (level == commandVo.getSize())
            return response(commandVo);

        if (this.next != null)
            return this.next.handleMessage(commandVo, handleLevel + 1);
        return "";
    }
    protected abstract int getHandleLevel();

    protected abstract String response(CommandVo commandVo);
}
