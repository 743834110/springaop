package com.lingnan.mybatisdemo.command.common;


import com.lingnan.mybatisdemo.command.Command;
import com.lingnan.mybatisdemo.command.CommandName;
import com.lingnan.mybatisdemo.command.CommandVo;

/**
 * Created by Administrator on 2018/6/11.
 */
public class CommonCommand extends Command {

    @Override
    protected CommandName buildChain() {
        CommandThirdView commandThirdView = new CommandThirdView(null);
        CommandSecondView commandSecondView = new CommandSecondView(commandThirdView);
        return new CommonFirstView(commandSecondView);
    }

    @Override
    public String execute(CommandVo commandVo) {
        CommandName commandName = this.buildChain();
        return commandName.handleMessage(commandVo, 1);
    }


}
