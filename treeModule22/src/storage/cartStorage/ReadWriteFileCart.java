package storage.cartStorage;

import model.Cart;
import storage.productStorage.ReadWriteFileProduct;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFileCart implements ICartStorage{
    private static ReadWriteFileCart instance;

    private ReadWriteFileCart() {
    }

    public static ReadWriteFileCart getInstance() {
        if (instance == null) {
            synchronized (ReadWriteFileProduct.class) {
                if (instance == null) {
                    instance = new ReadWriteFileCart();
                }
            }
        }
        return instance;
    }

    private static final File file = new File("cart.txt");


    @Override
    public void writeFile(List<Cart> cartList) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            StringBuilder cartString = new StringBuilder();
            for (Cart cart : cartList) {
                cartString.append(cart.getId()).append(",").append(cart.getNameProduct()).append(",").append(cart.getQuantity()).append(",").append(cart.getPrice()).append(",").append("\n");
            }
            bufferedWriter.write(cartString.toString());
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Cart> readFile() {
        List<Cart> cartList = new ArrayList<>();
        String line;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                String[] cartString = line.split(",");
                if (cartString.length != 4) {
                    continue;
                }
                int id = Integer.parseInt(cartString[0].trim());
                String nameProduct = cartString[1].trim();
                int quantity = Integer.parseInt(cartString[2].trim());
                double price = Double.parseDouble(cartString[3].trim());

                Cart cart = new Cart(id, nameProduct, quantity, price);
                cartList.add(cart);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return cartList;
    }
}

