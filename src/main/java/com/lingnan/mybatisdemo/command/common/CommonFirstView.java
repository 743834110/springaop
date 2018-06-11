package com.lingnan.mybatisdemo.command.common;


import com.lingnan.mybatisdemo.bean.Customer;
import com.lingnan.mybatisdemo.mapper.CustomerMapper;
import com.lingnan.mybatisdemo.utils.Config;
import com.lingnan.mybatisdemo.utils.InputUtils;
import com.lingnan.mybatisdemo.command.CommandName;
import com.lingnan.mybatisdemo.command.CommandVo;
import com.lingnan.mybatisdemo.utils.SessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/6/11.
 */
public class CommonFirstView extends CommandName {


    /*
     * 当前命令处理级别
     */
    private final int CURRENT_LEVEL = 1;

    public CommonFirstView(CommandName next) {
        super(next);
    }

    @Override
    protected int getHandleLevel() {
        return CURRENT_LEVEL;
    }

    /**
     *
     *
     * @return
     */
    @Override
    protected String response(CommandVo commandVo) {
        String result = this.initString();
        System.out.println(result);
        Scanner scanner = InputUtils.getInstance().getScanner();
        String username;
        String password;
        while (scanner.hasNextLine()){
            String input = scanner.nextLine();
            if (input.equals("1")) {
                //this.registerString();
                System.out.println("未完成......\n");
                return "";
            }

            else if (input.equals("2")) {
                boolean success = this.loginString();
                if (success) {
                    commandVo.input("2");
                    return "登录成功......\n";
                }
            }

            else if (input.equals("3")){
                commandVo.pop();
                return "";
            }
            System.out.println(result);
        }
        return null;
    }

    public void registerString(){

    }

    public boolean loginString(){
        StringBuilder builder = new StringBuilder();
        builder.append("################################################");
        builder.append("\n");
        Scanner scanner = InputUtils.getInstance().getScanner();
        builder.append("  请输入你的账号：\n");
        System.out.println(builder.toString());
        String username = scanner.nextLine();
        builder = new StringBuilder();
        builder.append("  请输入你的密码：\n");
        System.out.println(builder.toString());
        String password = scanner.nextLine();
        SqlSession session = SessionFactory.getSession();
        CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
        Map<String, String> map = new HashMap<>();
        map.put("account", username);
        map.put("password", password);
        List<Customer> customers = customerMapper.selectCustomerWithNameAndPassword(map);
        SessionFactory.close();
        if (customers.size() == 0){
            System.out.println("登录失败......\n");
            return false;
        }
        else{
            Config.getInstance().setCustomer(customers.get(0));
            return true;
        }
    }

    public String initString() {
        StringBuilder builder = new StringBuilder();
        builder.append("################################################");
        builder.append("\n");
        builder.append("  请选择操作方式：");
        builder.append("\n");
        builder.append("   1. 注册");
        builder.append("\n");
        builder.append("   2. 登录");
        builder.append("\n");
        builder.append("   3. 返回上一级");
        builder.append("\n");
        builder.append("################################################");
        builder.append("\n");
        return builder.toString();
    }

}
