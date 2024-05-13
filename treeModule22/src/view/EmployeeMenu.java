package view;

import controller.EmployeeController;
import service.LoginService;

public class EmployeeMenu {
    public static void showEmployeeMenu() throws InterruptedException{
        System.out.println("__________"+ LoginService.showUsername() +"__________");
        System.out.println("1. Hiển thị danh sách sản phẩm.");
        System.out.println("2. Tìm kiếm sản phẩm theo mã sản phẩm.");
        System.out.println("3. Tìm kiếm sản phẩm theo tên sản phẩm.");
        System.out.println("4. Tìm kiếm sản phẩm theo danh mục sản phẩm.");
        System.out.println("5. Tìm kiếm sản phẩm theo giá sản phẩm.");
        System.out.println("6. Thêm sản phẩm vào giỏ hàng.");
        System.out.println("7. Xem giỏ hàng.");
//        System.out.println("8. Thanh toán.");
//        System.out.println("9. Xem hóa đơn.");
//        System.out.println("10. Xem thông tin cá nhân.");
//        System.out.println("0. Đăng xuất.");
        EmployeeController.controllerEmployee();
    }
}