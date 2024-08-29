public class User {
    private String name;
    private int age;
    private String gender;
    private String email;
    private String phone;
    private String address;
    private String type ;
    public User(String name, int age, String gender, String email, String phone, String address, String type) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User { " +
                "Tên : '" + name + '\'' +
                ", Tuổi : " + age +
                ", Giới tính : '" + gender + '\'' +
                ", Email : '" + email + '\'' +
                ", Số điện thoại : '" + phone + '\'' +
                ", Địa chỉ : '" + address + '\'' +
                ", Loại danh bạ : " + type +'\'' +
                '}';
    }
}
