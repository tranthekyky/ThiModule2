import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manager {
    PhoneBook phoneBook = new PhoneBook();
    Exception exception = new Exception();
    Scanner scanner = new Scanner(System.in);
    public void handleMenu () {
        int choice ;
        do {
            mainMenu();
            choice =exception.inputNumberInt();
            switch (choice) {
                case 1:
                    displayMenu();
                    break;
                case 2:
                    addUserMenu();
                    break;
                case 3:
                    updateUserMenu();
                    break;
                case 4:
                    removeUserMenu();
                    break;
                case 5:
                    searchUserMenuByName();
                    break;
                case 6:
                    searchUserMenuByPhone();
                    break;
                case 7:

                case 8:
                    phoneBook.writeDataPhoneBook(phoneBook.getUsers());
                    break;
            }
        }while (choice != 0);
    }
    public void mainMenu () {
        System.out.println("=== CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ===");
        System.out.println("1. Xem danh sách .");
        System.out.println("2. Thêm mới .");
        System.out.println("3. Cập nhật danh bạ . ");
        System.out.println("4. Xoá .");
        System.out.println("5. Tìm kiếm theo tên .");
        System.out.println("6. Tìm kiếm theo số điện thoại .");
        System.out.println("7. Đọc từ file .");
        System.out.println("8. Lưu dữ liệu .");
        System.out.println();
        System.out.println("Chọn chức năng theo số : ");
    }
    public void displayMenu () {
        int pageSize = 5 ;
        for (int i = 0; i < phoneBook.getUsers().size(); i++) {
            int end = Math.min(i + pageSize, phoneBook.getUsers().size());
            List<User> users = phoneBook.getUsers().subList(i , end);
            for (User user : users) {
                System.out.println(user);
            }
            if ( end < phoneBook.getUsers().size()) {
                System.out.println("Nhấn Enter để hiện thêm ...");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
    public String choiceType () {
        int choice ;
        do {
            System.out.println("1. Gia đình .");
            System.out.println("2. Bạn bè .");
            System.out.println("3. Công việc .");
            System.out.println();
            System.out.println("Chọn loại danh bạ :");
            choice = exception.inputNumberInt();
            switch (choice) {
                case 1:
                   return "Gia đình";
                case 2:
                   return "Bạn bè";
                case 3:
                    return "Công việc";
            }
        }while (choice != 0) ;
        return null;
    }
    public void addUserMenu () {
        System.out.println("---- Thêm Mới ----");
        System.out.println("Nhập số điện thoại : ");
        String phone = exception.regexNumberPhone();
        System.out.println("Nhập họ và tên :");
        String name = exception.inputString();
        System.out.println("Nhập giới tính :");
        String gender = exception.inputString();
        System.out.println("Nhập tuổi :");
        int age = exception.inputNumberInt();
        System.out.println("Nhập Email :");
        String email = exception.regexNumberEmail();
        System.out.println("Nhập địa chỉ :");
        String address = exception.inputString();
        System.out.println("Chọn loại danh bạ :");
        String tyoe = choiceType();
        User user = new User(name,age,gender,email,phone,address,tyoe);
        phoneBook.addUser(user);
        System.out.println("Thêm thành cồng !");

    }
    public void removeUserMenu () {
        System.out.println("---- Xoá ----");
        System.out.println("Nhập số điện thoại cần xoá :");
        String phone = exception.inputString();
        phoneBook.removeUser(phone);
        System.out.println("Xoá thành công !");

    }
    public void updateUserMenu () {
        System.out.println("---- Sửa Mới ----");
        System.out.println("Nhập số điện thoại cũ: ");
        String phone = exception.checkPhone();
        System.out.println("Nhập số điện thoại mới: ");
        String phoneNew = exception.regexNumberPhone();
        System.out.println("Nhập họ và tên cần sửa:");
        String name = exception.inputString();
        System.out.println("Nhập giới tính cần sửa:");
        String gender = exception.inputString();
        System.out.println("Nhập tuổi cần sửa:");
        int age = exception.inputNumberInt();
        System.out.println("Nhập Email cần sửa:");
        String email = exception.regexNumberEmail();
        System.out.println("Nhập địa chỉ cần sửa:");
        String address = exception.inputString();
        System.out.println("Chọn loại danh bạ cần sửa:");
        String tyoe = choiceType();
        User user = new User(name,age,gender,email,phoneNew,address,tyoe);
        phoneBook.updateUser(user,phone);
        System.out.println("Sưa thành công");

    }
    public void searchUserMenuByName () {
        System.out.println("Nhập tên cần tim : ");
        String name = exception.inputString();
        for (User user : phoneBook.searchUserByName(name)) {
            System.out.println(user);
        }

    }
    public void searchUserMenuByPhone () {
        System.out.println("Nhập số điện thoại : ");
        String phone = exception.regexNumberPhone();
        for (User user : phoneBook.searchUserByPhone(phone)) {
            System.out.println(user);
        }
    }




}
