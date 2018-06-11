package com.lingnan.mybatisdemo.command.common;


import com.lingnan.mybatisdemo.command.CommandName;
import com.lingnan.mybatisdemo.command.CommandVo;

/**
 * Created by Administrator on 2018/6/11.
 */
public class CommandThirdView extends CommandName {


    private static final int CURRENT_LEVEL = 3;

    public CommandThirdView(CommandName next) {
        super(next);
    }

    @Override
    protected int getHandleLevel() {
        return CURRENT_LEVEL;
    }

    @Override
    protected String response(CommandVo commandVo) {
        return null;
    }
}
