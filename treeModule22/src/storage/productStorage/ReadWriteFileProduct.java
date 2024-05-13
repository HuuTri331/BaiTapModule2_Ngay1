package storage.productStorage;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadWriteFileProduct implements IProductStorage {
    private static ReadWriteFileProduct instance;

    private ReadWriteFileProduct() {
    }

    public static ReadWriteFileProduct getInstance() {
        if (instance == null) {
            synchronized (ReadWriteFileProduct.class) {
                if (instance == null) {
                    instance = new ReadWriteFileProduct();
                }
            }
        }
        return instance;
    }

    private static final File file = new File("product.txt");

    @Override
    public void writeFile(List<Product> productList) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            StringBuilder productString = new StringBuilder();
            for (Product product : productList) {
                productString.append(product.getId()).append(",").append(product.getName()).append(",").append(product.getNameProductCategory()).append(",").append(product.getPrice()).append(",").append(product.getQuantity()).append("\n");
            }
            bufferedWriter.write(productString.toString());
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> readFile() {
        List<Product> productList = new ArrayList<>();
        String line;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                String[] productString = line.split(",");
                if (productString.length != 5) {
                    continue;
                }
                int idProduct = Integer.parseInt(productString[0].trim());
                String nameProduct = productString[1].trim();
                String nameProductCategory = productString[2].trim();
                double price = Double.parseDouble(productString[3].trim());
                int quantity = Integer.parseInt(productString[4].trim());

                Product product = new Product(idProduct, nameProduct, nameProductCategory, price, quantity);
                productList.add(product);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }
}
