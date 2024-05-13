package service;

import model.User;
import storage.userStorage.ReadWriteFileUser;
import view.EmployeeMenu;
import view.ManagerMenu;

import java.util.List;
import java.util.Scanner;

public class LoginService {
    Scanner scanner = new Scanner(System.in);
    public static List<User> userList = ReadWriteFileUser.getInstance().readFile();
    public static String currentUser;

    public void login() throws InterruptedException {
        boolean isSucceeded = false;
        System.out.println("__________Đăng nhập__________");
        System.out.print("Nhập Username: ");
        String username = scanner.nextLine();
        System.out.print("Nhập Password: ");
        String password = scanner.nextLine();

        for (User user : userList) {
            if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
                isSucceeded = true;
                currentUser = username;
                if (user.getRole().equalsIgnoreCase("Manager")) {
                    System.out.println("Đăng nhập thành công.");
                    System.out.println();
                    ManagerMenu.showMenuManager();
                    break;
                } else {
                    if (user.getRole().equalsIgnoreCase("Employee")) {
                        System.out.println("Đăng nhập thành công.");
                        System.out.println();
                        EmployeeMenu.showEmployeeMenu();
                        break;
                    }
                }
            }
        }
        if (!isSucceeded) {
            System.out.println("Username hoặc Password không chính xác.");
            System.out.println();
            login();
        }
    }

    public static String showUsername() {
        StringBuilder showUesrname = new StringBuilder();
        for (User user : userList) {
            if (currentUser.equals(user.getUserName())) {
                showUesrname.append(user.getFullName());
            }
        }
        return showUesrname.toString();
    }
}