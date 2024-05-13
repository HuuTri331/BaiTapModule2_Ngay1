package view;

import controller.LoginController;

public class LoginMenu {
    public static void showMenuLogin() throws InterruptedException{
        System.out.println("_____SUPERMARKET CODEGYM_____");
        System.out.println("1. Đăng nhập.");
        System.out.println("0. Thoát chương trình.");
        LoginController.controllerLogin();
    }
}
