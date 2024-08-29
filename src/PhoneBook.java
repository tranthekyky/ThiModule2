import java.io.*;
import java.util.ArrayList;

public class PhoneBook {
    private ArrayList<User> users;
    public PhoneBook() {
        users = readDataPhoneBook();
    }
    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void addUser (User user) {
        users.add(user);
        writeDataPhoneBook(users);
    }
    public int getIndexUser (String phone) {
       for (int i = 0; i < users.size(); i++) {
           if (users.get(i).getPhone().equals(phone)) {
               return i;
           }
       }
       return -1;
    }
    public void removeUser (String phone) {
        int index = getIndexUser(phone);
        users.remove(index);
        writeDataPhoneBook(users);
    }
    public void updateUser (User userNew, String phone) {
        int index = getIndexUser(phone);
        users.set(index, userNew);
        writeDataPhoneBook(users);
    }
    public ArrayList<User> searchUserByName (String name) {
        ArrayList<User> usersSearch = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                usersSearch.add(users.get(i));
            }
        }
        return usersSearch;
    }
    public ArrayList<User> searchUserByPhone (String phone) {
        ArrayList<User> usersSearch = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getPhone().contains(phone)) {
                usersSearch.add(users.get(i));
            }
        }
        return usersSearch;
    }
    public void writeDataPhoneBook (ArrayList<User> users) {
        File file = new File("data/contacts.txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String data = "";
            for (User user : users) {
                data += user.getPhone() + ","+ user.getName() + "," + user.getAge()+ ","+user.getGender()+ "," + user.getAddress()+ ","  +","+user.getEmail()+ ","+user.getType() + "\n" ; ;
            }
            bufferedWriter.write(data);
            bufferedWriter.close();
        }catch (IOException e) {
            System.err.println("Lỗi ghi file");
        }
    }
    public ArrayList<User> readDataPhoneBook () {
        ArrayList<User> users = new ArrayList<>();
        File file = new File("data/contacts.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String data ;
            while ((data = bufferedReader.readLine()) != null) {
                String [] userString = data.split(",");
                String phone = userString[0];
                String name = userString[1];
                int age = Integer.parseInt(userString[2]);
                String gender = userString[3];
                String address = userString[4];
                String email = userString[5];
                String type = userString[6];
                users.add(new User(name ,age ,gender,email,phone,address, type));
            }
            bufferedReader.close();
        }catch (IOException e) {
            System.err.println("Lỗi đọc file");
        }
        return users;
    }
}
