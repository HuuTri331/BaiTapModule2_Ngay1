package controller;

import view.*;

import java.util.Scanner;

public class ManagerController {
    public static void controllerManager() throws InterruptedException{
        Scanner scanner=new Scanner(System.in);

        System.out.print("Mời bạn chọn: ");
        int option=scanner.nextInt();

        boolean exit=true;
        while (exit){
            switch (option){
                case 1:{
                    ProductMenu.showMenuProduct();
                    break;
                }
                case 2:{
//                   ProductCategoryMenu.showMenuCategory();
                    break;
                }
                case 3:{
//                    EmployeeManagerMenu.showEmployeeManagerMenu();
                    break;
                }
                case 4:{
//                    BillMenu.showMenuBill();
                    break;
                }
                case 0:{
                    LoginMenu.showMenuLogin();
                    break;
                }
                default:{
                    System.out.println("Yêu cầu của bạn chọn không có trong Menu.");
                    ManagerMenu.showMenuManager();
                    break;
                }
            }
        }
    }

}