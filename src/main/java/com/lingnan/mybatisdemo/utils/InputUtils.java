package com.lingnan.mybatisdemo.utils;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/6/11.
 */
public class InputUtils{
    private  Scanner scanner = new Scanner(System.in);
    private static InputUtils inputUtils = new InputUtils();
    private InputUtils(){}

    public static InputUtils getInstance() {
        return inputUtils;
    }
    public Scanner getScanner() {
        return scanner;
    }
}
