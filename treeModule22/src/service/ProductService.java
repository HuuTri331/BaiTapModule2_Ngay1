package service;

import model.Cart;
import model.Product;
import storage.productStorage.ReadWriteFileProduct;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IService<Product> {
    Scanner scanner = new Scanner(System.in);
    private static List<Product> productList = ReadWriteFileProduct.getInstance().readFile();

    @Override
    public void add() throws InterruptedException {
        System.out.println("__________Thêm Sản Phẩm__________");
        System.out.print("Nhập mã sản phẩm: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();

        System.out.print("Nhập tên danh mục sản phẩm: ");
        String nameCategory = scanner.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Nhập số lượng sản phẩm: ");
        int quantity = scanner.nextInt();

        productList.add(new Product(id, name, nameCategory, price, quantity));

        ReadWriteFileProduct.getInstance().writeFile(productList);
        System.out.println("Bạn đã thêm sản phẩm thành công.");
        System.out.println();
    }

    @Override
    public void edit() throws InterruptedException {
        System.out.println("__________Chỉnh Sửa Sản Phẩm__________");
        show();
        System.out.print("Nhập mã sản phẩm mà bạn muốn chỉnh sửa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Product productToEdit = null;
        for (Product product : productList) {
            if (product.getId() == id) {
                productToEdit = product;
                break;
            }
        }

        if (productToEdit == null) {
            System.out.println("Không tìm thấy mã sản phẩm cần chỉnh sửa trong danh sách sản phẩm.");
            System.out.println();
            return;
        }

        System.out.print("Nhập tên sản phẩm: ");
        String newName = scanner.nextLine();

        System.out.print("Nhập tên danh mục sản phẩm: ");
        String newNameCategory = scanner.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        double newPrice = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Nhập số lượng sản phẩm: ");
        int newQuantity = scanner.nextInt();

        productToEdit.setName(newName);
        productToEdit.setNameProductCategory(newNameCategory);
        productToEdit.setPrice(newPrice);
        productToEdit.setQuantity(newQuantity);

        ReadWriteFileProduct.getInstance().writeFile(productList);
        System.out.println("Đã chỉnh sửa sản phẩm thành công.");
        System.out.println();
    }

    @Override
    public void delete() throws InterruptedException {
        System.out.println("__________Xóa Sản Phẩm__________");
        show();
        System.out.print("Nhập mã sản phẩm mà bạn muốn xóa: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        boolean remove = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.remove(i);
                remove = true;
                break;
            }
        }

        if (remove) {
            ReadWriteFileProduct.getInstance().writeFile(productList);
            System.out.println("Đã xóa thành công.");
        } else {
            System.out.println("Không tìm thấy mã sản phẩm cần xóa trong danh sách sản phẩm.");
        }
        System.out.println();
    }

    @Override
    public void show() throws InterruptedException {
        System.out.printf("| %-3s | %-30s | %-20s | %-8s | %-8s | %n", "ID", "NAME", "NAME CATEGORY", "PRICE", "QUANTITY");
        System.out.println("_____________________________________________________________________________________");
        for (Product product : productList) {
            System.out.printf("| %-3s | %-30s | %-20s | %-8s | %-8s | %n", product.getId(),product.getName(),product.getNameProductCategory(),product.getPrice(),product.getQuantity());
        }
        System.out.println();
    }

    @Override
    public void findById() throws InterruptedException {
        System.out.println("_____Tìm kiếm sản phẩn theo mã sản phẩm._____");
        System.out.print("Nhập mã sản phẩm cần tìm: ");
        int id=scanner.nextInt();
        scanner.nextLine();

        boolean find=false;
        for (Product product:productList){
            if (product.getId()==id){
                System.out.printf("| %-3s | %-30s | %-20s | %-8s | %-8s | %n", "ID", "NAME", "NAME CATEGORY", "PRICE", "QUANTITY");
                System.out.println("_____________________________________________________________________________________");
                System.out.printf("| %-3s | %-30s | %-20s | %-8s | %-8s | %n", product.getId(),product.getName(),product.getNameProductCategory(),product.getPrice(),product.getQuantity());
                find=true;
            }
        }
        if (!find) {
            System.out.println("Không tìm thấy sản phẩm có mã là " + id);
        }
        System.out.println();
    }

    @Override
    public void findByName() throws InterruptedException {
        System.out.println("_____Tìm kiếm sản phẩn theo tên sản phẩm._____");
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String name = scanner.nextLine();

        boolean find=false;
        for (Product product:productList){
            if (product.getName().equalsIgnoreCase(name)){
                System.out.printf("| %-3s | %-30s | %-20s | %-8s | %-8s | %n", "ID", "NAME", "NAME CATEGORY", "PRICE", "QUANTITY");
                System.out.println("_____________________________________________________________________________________");
                System.out.printf("| %-3s | %-30s | %-20s | %-8s | %-8s | %n", product.getId(),product.getName(),product.getNameProductCategory(),product.getPrice(),product.getQuantity());
                find=true;
            }
        }
        if (!find) {
            System.out.println("Không tìm thấy sản phẩm có tên là " + name);
        }
        System.out.println();
    }

    public void findByCategory() throws InterruptedException{
        System.out.println("_____Tìm kiếm sản phẩn theo tên danh mục sản phẩm._____");
        System.out.print("Nhập tên danh mục sản phẩm cần tìm: ");
        String nameCategory = scanner.nextLine();

        boolean find=false;
        System.out.printf("| %-3s | %-30s | %-20s | %-8s | %-8s | %n", "ID", "NAME", "NAME CATEGORY", "PRICE", "QUANTITY");
        System.out.println("_____________________________________________________________________________________");
        for (Product product:productList){
            if (product.getNameProductCategory().equalsIgnoreCase(nameCategory)){
                System.out.printf("| %-3s | %-30s | %-20s | %-8s | %-8s | %n", product.getId(),product.getName(),product.getNameProductCategory(),product.getPrice(),product.getQuantity());
                find=true;
            }
        }
        if (!find) {
            System.out.println("Không tìm thấy sản phẩm có tên là " + nameCategory);
        }
        System.out.println();
    }

    public void findByPrice() throws InterruptedException{
        System.out.println("_____Tìm kiếm sản phẩn theo giá sản phẩm._____");
        System.out.print("Nhập giá sản phẩm cần tìm: ");
        double price=scanner.nextDouble();
        scanner.nextLine();

        boolean find=false;
        System.out.printf("| %-3s | %-30s | %-20s | %-8s | %-8s | %n", "ID", "NAME", "NAME CATEGORY", "PRICE", "QUANTITY");
        System.out.println("_____________________________________________________________________________________");
        for (Product product:productList){
            if (product.getPrice()==price){
                System.out.printf("| %-3s | %-30s | %-20s | %-8s | %-8s | %n", product.getId(),product.getName(),product.getNameProductCategory(),product.getPrice(),product.getQuantity());
                find=true;
            }
        }
        if (!find) {
            System.out.println("Không tìm thấy sản phẩm có giá là " + price);
        }
        System.out.println();
    }

    public static void setProductList(List<Cart> cartList){
        for (Cart cart:cartList){
            for (Product product:productList){
                if(cart.getNameProduct().equalsIgnoreCase(product.getName())){
                    product.setQuantity(product.getQuantity()-cart.getQuantity());
                }
            }
        }
        ReadWriteFileProduct.getInstance().writeFile(productList);
    }

}
