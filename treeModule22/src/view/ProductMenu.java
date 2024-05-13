package view;

import controller.ProductController;

public class ProductMenu {
    public static void showMenuProduct() throws InterruptedException{
        System.out.println("__________Menu___________");
        System.out.println("1. Thêm sản phẩm.");
        System.out.println("2. Sửa sản phẩm.");
        System.out.println("3. Xóa sản phẩm.");
        System.out.println("4. Hiển thị sản phẩm.");
        System.out.println("5. Tìm kiếm sản phẩm theo mã sản phẩm.");
        System.out.println("6. Tìm kiếm sản phẩm theo tên sản phẩm.");
        System.out.println("7. Tìm kiếm sản phẩm theo tên danh mục sản phẩm.");
        System.out.println("8. Tìm kiếm sản phẩm theo giá sản phẩm.");
        System.out.println("0. Quay trở về menu quản lý.");
        ProductController.controllerProduct();
    }
}
