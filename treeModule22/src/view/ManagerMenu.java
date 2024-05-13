package view;

import controller.ManagerController;

public class ManagerMenu {
    public static void showMenuManager() throws InterruptedException{
        System.out.println("__________Menu__________");
        System.out.println("1. Quản lý sản phẩm.");
//        System.out.println("2. Quản lý danh mục sản phẩm.");
//        System.out.println("3. Quản lý nhân sự.");
//        System.out.println("4. Quản lý hóa đơn.");
        System.out.println("0. Đăng xuất.");
        ManagerController.controllerManager();
    }
}
