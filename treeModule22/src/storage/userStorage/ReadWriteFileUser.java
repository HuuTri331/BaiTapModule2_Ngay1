package storage.userStorage;

import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFileUser implements IUserStorage {
    private static ReadWriteFileUser instance;

    private ReadWriteFileUser() {
    }

    public static ReadWriteFileUser getInstance() {
        if (instance == null) {
            synchronized (ReadWriteFileUser.class) {
                if (instance == null)
                    instance = new ReadWriteFileUser();
            }
        }
        return instance;
    }

    private static final File file = new File("user.txt");

    @Override
    public void writeFile(List<User> userList) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            StringBuilder userString = new StringBuilder();
            for (User user : userList) {
                userString.append(user.getId()).append(",").append(user.getUserName()).append(",").append(user.getPassword()).append(",").append(user.getFullName()).append(",").append(user.getGender()).append(",").append(user.getRole()).append(",").append(user.getPhoneNumber()).append("\n");
            }
            bufferedWriter.write(userString.toString());
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> readFile() {
        List<User> userList = new ArrayList<>();
        String line;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                String[] userString = line.split(",");
                if (userString.length != 7) {
                    continue;
                }
                int id = Integer.parseInt(userString[0].trim());
                String username = userString[1].trim();
                String password = userString[2].trim();
                String fullName = userString[3].trim();
                String gender = userString[4].trim();
                String role = userString[5].trim();
                String phone = userString[6].trim();

                User user = new User(id, username, password, fullName, gender, role, phone);
                userList.add(user);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }
}