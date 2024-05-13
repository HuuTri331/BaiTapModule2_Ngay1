package service;

import model.Bill;
import model.Cart;
import model.Product;
import model.User;
import storage.billStorage.ReadWriteFileBill;
import storage.cartStorage.ReadWriteFileCart;
import storage.productStorage.ReadWriteFileProduct;
import storage.userStorage.ReadWriteFileUser;
import view.EmployeeMenu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService {
    Scanner scanner = new Scanner(System.in);
    List<Cart> cartList = ReadWriteFileCart.getInstance().readFile();
    List<Product> productList = ReadWriteFileProduct.getInstance().readFile();
    List<User> userList= ReadWriteFileUser.getInstance().readFile();
    List<Bill> billList= ReadWriteFileBill.getInstance().readFile();

    public void addCart() throws InterruptedException {
        ProductService productService = new ProductService();
        productService.show();

        System.out.print("Nhập mã phẩm muốn mua: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean exit = false;
        for (Product product : productList) {
            if (product.getId() == id) {
                exit = true;
                boolean checkQuantity = false;
                while (!checkQuantity) {
                    boolean overZero = false;
                    while (!overZero) {
                        System.out.print("Nhập số lượng: ");
                        int quantity = scanner.nextInt();
                        scanner.nextLine();

                        if (quantity > 0) {
                            overZero = true;
                            if (quantity <= product.getQuantity()) {
                                checkQuantity = true;
                                Cart cart = new Cart(id, product.getName(), quantity, product.getPrice());

                                cartList.add(cart);
                                ReadWriteFileCart.getInstance().writeFile(cartList);
                                System.out.println("Sản phẩm đã được thêm vào giỏ hàng.");
                                System.out.println();
                                showCart();

                                break;
                            } else {
                                System.out.println("Số lượng không được lớn hơn số lượng tồn.");
                            }
                        } else {
                            System.out.println("Số lương phải lơn hơn 0.");
                        }
                    }
                }
            }
        }
        if(!exit){
            System.out.println("Không tìm thấy mã sản phẩm bạn muốn mua.");
            addCart();
        }
    }

    public void showCart() {
        double total = 0;
        int count = 1;
        System.out.printf("| %-3s | %-30s | %-10s | %-8s | %-8s | %n", "ID", "NAME PRODUCT", "QUANTITY ", "PRICE", "TOTAL PRICE");
        System.out.println("_______________________________________________________________________________");
        for (Cart cart : cartList) {
            System.out.printf("| %-3s | %-30s | %-10s | %-8s | %-8s | %n", count++, cart.getNameProduct(), cart.getQuantity(), cart.getPrice(), cart.getTotalAmount());
            total += cart.getTotalAmount();
        }
        System.out.printf("Total: %.2f", total);
        System.out.println();
    }
}
