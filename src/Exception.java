import java.util.Scanner;

public class Exception {
    Scanner sc = new Scanner(System.in);
    PhoneBook phoneBook = new PhoneBook();
    public int inputNumberInt () {
        int number ;
        do {
            try {
                number = Integer.parseInt(sc.nextLine());
                return number;
            }catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập dữ liệu là số !");
            }
        }while(true) ;
    }
    public String inputString () {
        return sc.nextLine();
    }
    public String checkPhone () {
        String phone ;
        while (true) {
            try {
                phone = regexNumberPhone();
                if (phoneBook.getIndexUser(phone) == -1) {
                    System.out.println("Số điện thoại không tồn tại , vui lòng nhập lại :");
                }else {
                    return phone ;
                }
            }catch (IllegalArgumentException e) {
                System.out.println("Vui long nhaap laij ");
            }
        }
    }
    public String regexNumberPhone () {
        String regex = "^(0|\\+84)[3-9][0-9]{8}$" ;
        String str ;
        do {
            str = inputString() ;
            if (str.matches(regex)) {
                return str ;
            }else {
                System.err.println("Sai dịnh dạng số có 10 chữ số !! ( VD : 0365... ; 0983... )");
            }
        }while (true) ;
    }
    public String regexNumberEmail () {
        String regex = "^[a-zA-Z0-9._%+-]+@gmail\\.com$" ;
        String str ;
        do {
            str = inputString() ;
            if (str.matches(regex)) {
                return str ;
            }else {
                System.err.println("Sai định dạng !! ( VD : txt12@gmail.com , user34Ggmail.com)");
            }
        }while (true) ;
    }
    public String regexName () {
            String regex = "^[A-Z][a-z]*\\s[A-Z][a-z]*$\n" ;
        String str ;
        do {
            str = inputString() ;
            if (str.matches(regex)) {
                return str ;
            }else {
                System.err.println("Bắt đầu bằng chữ cái in hoa , VD : Tran The Ky , Nguyen Van A ...");
            }
        }while (true) ;
    }

}
