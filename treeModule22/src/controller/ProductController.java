package controller;

import service.ProductService;
import view.ManagerMenu;
import view.ProductMenu;

import java.util.Scanner;

public class ProductController {
    public static void controllerProduct() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        ProductService productService = new ProductService();

        System.out.print("Mời bạn chọn: ");
        int option = scanner.nextInt();
        System.out.println();

        boolean exit = true;
        while (exit) {
            switch (option) {
                case 1: {
                    productService.add();
                    ProductMenu.showMenuProduct();
                    break;
                }
                case 2: {
                    productService.edit();
                    ProductMenu.showMenuProduct();
                    break;
                }
                case 3: {
                    productService.delete();
                    ProductMenu.showMenuProduct();
                    break;
                }
                case 4: {
                    productService.show();
                    ProductMenu.showMenuProduct();
                    break;
                }
                case 5: {
                    productService.findById();
                    ProductMenu.showMenuProduct();
                    break;
                }
                case 6: {
                    productService.findByName();
                    ProductMenu.showMenuProduct();
                    break;
                }
                case 7: {
                    productService.findByCategory();
                    ProductMenu.showMenuProduct();
                    break;
                }
                case 8: {
                    productService.findByPrice();
                    ProductMenu.showMenuProduct();
                    break;
                }
                case 0: {
                    System.out.println();
                    ManagerMenu.showMenuManager();
                    break;
                }
                default: {
                    System.out.println("Yêu cầu của bạn chọn không có trong Menu.");
                    ProductMenu.showMenuProduct();
                    break;
                }
            }
        }
    }
}