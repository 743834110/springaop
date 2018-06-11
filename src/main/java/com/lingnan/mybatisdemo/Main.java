package com.lingnan.mybatisdemo;


import com.lingnan.mybatisdemo.command.Invoker;
import com.lingnan.mybatisdemo.utils.InputUtils;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Invoker invoker = new Invoker();
        Scanner scanner = InputUtils.getInstance().getScanner();
        String result = "";
        result = invoker.initString();
        System.out.println(result);
        while (scanner.hasNextLine()){
            String command = scanner.nextLine().trim();
            result = invoker.execute(command);
            System.out.println(result);

        }
    }
}
