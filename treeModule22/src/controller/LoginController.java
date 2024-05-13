package controller;

import service.LoginService;
import view.ProductMenu;

import java.util.Scanner;

public class LoginController {
    public static void controllerLogin() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        LoginService loginService = new LoginService();

        System.out.print("Mời bạn chọn: ");
        int option = scanner.nextInt();
        System.out.println();

        boolean exit=true;
        while (exit){
            switch (option){
                case 1:{
                    loginService.login();
                    break;
                }
                case 0:{
                    System.exit(0);
                    break;
                }
                default:{
                    System.out.println("Yêu cầu của bạn chọn không có trong Menu.");
                    ProductMenu.showMenuProduct();
                    break;
                }
            }
        }
    }
}
