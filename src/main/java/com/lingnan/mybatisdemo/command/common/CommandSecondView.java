package com.lingnan.mybatisdemo.command.common;


import com.lingnan.mybatisdemo.bean.Book;
import com.lingnan.mybatisdemo.bean.Cart;
import com.lingnan.mybatisdemo.bean.CartItem;
import com.lingnan.mybatisdemo.bean.Customer;
import com.lingnan.mybatisdemo.command.CommandName;
import com.lingnan.mybatisdemo.command.CommandVo;
import com.lingnan.mybatisdemo.mapper.BookMapper;
import com.lingnan.mybatisdemo.mapper.CartItemMapper;
import com.lingnan.mybatisdemo.mapper.CartMapper;
import com.lingnan.mybatisdemo.utils.Config;
import com.lingnan.mybatisdemo.utils.InputUtils;
import com.lingnan.mybatisdemo.utils.SessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/6/11.
 */
public class CommandSecondView extends CommandName {

    /*
     * 当前命令处理级别
     */
    private final int CURRENT_LEVEL = 2;

    public CommandSecondView(CommandName next) {
        super(next);
    }

    @Override
    protected int getHandleLevel() {
        return CURRENT_LEVEL;
    }

    @Override
    protected String response(CommandVo commandVo) {
        Scanner scanner = InputUtils.getInstance().getScanner();
        String result = this.initString();
        System.out.println(result);
        while (scanner.hasNextLine()){
            String operation = scanner.nextLine();
            if (operation.equals("1")){
                boolean bool = this.findAllBooksString();
            }
            else if (operation.equals("2")){
                boolean bool = this.buyBooks();

            }
            else if (operation.equals("3")){
                commandVo.pop();
            }
            System.out.println(this.initString());
        }
        return "";
    }

    private boolean findAllBooksString(){

        SqlSession session = SessionFactory.getSession();
        BookMapper bookMapper = session.getMapper(BookMapper.class);
        List<Book> books = bookMapper.findAllBooks();
        books.forEach(System.out::println);
        return true;
    }


    private boolean buyBooks(){
        StringBuilder builder = new StringBuilder();
        builder.append("################################################");
        builder.append("\n");
        builder.append(  "请输入将要购买的书籍的编号：");
        builder.append("\n");
        System.out.println(builder.toString());
        builder.delete(0, builder.length());
        Scanner scanner = InputUtils.getInstance().getScanner();
        System.out.println("   请输入书籍编号：");
        String isbn = scanner.nextLine();
        System.out.println("   请输入购买数量：");
        String count = scanner.nextLine();
        SqlSession session = SessionFactory.getSession();
        CartItemMapper cartItemMapper = session.getMapper(CartItemMapper.class);
        CartMapper cartMapper = session.getMapper(CartMapper.class);
        Customer customer = Config.getInstance().getCustomer();
        try {
            Cart cart = cartMapper.getCustomerCart(customer.getUserId());
            cartItemMapper.insertCartItem(
                    new CartItem(null, cart.getCartId(), isbn, Integer.valueOf(count), null)
            );
            session.commit();
            System.out.println("购买成功！！！");
        } catch (Exception e){
            System.out.println("   购买失败！！！");
            return false;
        }
        builder.append("\n");
        builder.append("################################################");
        builder.append("\n");
        return true;
    }

    private String initString(){
        StringBuilder builder = new StringBuilder();
        builder.append("################################################");
        builder.append("\n");
        builder.append("  请选择操作方式：");
        builder.append("\n");
        builder.append("   1. 查看商品信息");
        builder.append("\n");
        builder.append("   2. 购买商品");
        builder.append("\n");
        builder.append("   3. 返回上一步");
        builder.append("\n");
        builder.append("################################################");
        builder.append("\n");
        return builder.toString();
    }
}
