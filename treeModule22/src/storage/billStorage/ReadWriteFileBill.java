package storage.billStorage;

import model.Bill;
import model.Cart;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFileBill implements IBillStorage{
    private static ReadWriteFileBill instance;
    private ReadWriteFileBill(){
    }

    public static ReadWriteFileBill getInstance(){
        if (instance==null){
            synchronized (ReadWriteFileBill.class){
                if(instance==null){
                    instance=new ReadWriteFileBill();
                }
            }
        }
        return instance;
    }
    private static final File file=new File("bill.txt");
    @Override
    public void writeFile(List<Bill> billList) {
        try {
            FileWriter fileWriter=new FileWriter(file);
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            StringBuilder billString=new StringBuilder();
            for (Bill bill: billList){
                billString.append(bill.getId()).append(",")
                        .append(bill.getNameStaff()).append(",")
                        .append(bill.getDateTime()).append(",");
                for (Cart cart:bill.getBill()){
                    billString.append(cart.getId()).append(",")
                            .append(cart.getNameProduct()).append(",")
                            .append(cart.getQuantity()).append(",")
                            .append(cart.getPrice()).append(",")
                            .append(cart.getTotalAmount()).append(",").append("\n");
                }
            }
            bufferedWriter.write(billString.toString());
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Bill> readFile() {
        List<Bill> billList=new ArrayList<>();
        List<Cart> cartList=new ArrayList<>();
        String line;
        try {
            FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            while ((line=bufferedReader.readLine())!=null){
                String[] billString=line.split(",");
                if (billString.length!=8){
                    continue;
                }
                int idBill=Integer.parseInt(billString[0].trim());
                String nameStaff=billString[1].trim();
                LocalDateTime dateTime=LocalDateTime.parse(billString[2].trim());
                int idCart = Integer.parseInt(billString[3].trim());
                String nameProduct = billString[4].trim();
                int quantity = Integer.parseInt(billString[5].trim());
                double price = Double.parseDouble(billString[6].trim());
                double totalAmount = Double.parseDouble(billString[7].trim());

                Cart cart=new Cart(idCart,nameProduct,quantity,price,totalAmount);
                cartList.add(cart);

                Bill bill=new Bill(idBill,nameStaff,dateTime,cartList);
                billList.add(bill);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return billList;
    }
}