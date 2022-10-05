package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Student_Reg")
public class Student implements SuperEntity{
    @Id
    private String studentId;
    private String name;
    private String address;
    private String nic;
    private String contact;
    private String birthday;
    private String gender;
    private String regDate;

    public Student() {
    }

    public Student(String studentId, String name, String address, String nic, String contact, String birthday, String gender, String regDate) {
        this.studentId = studentId;
        this.name = name;
        this.address = address;
        this.nic = nic;
        this.contact = contact;
        this.birthday = birthday;
        this.gender = gender;
        this.regDate = regDate;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", nic='" + nic + '\'' +
                ", contact='" + contact + '\'' +
                ", birthday='" + birthday + '\'' +
                ", gender='" + gender + '\'' +
                ", regDate='" + regDate + '\'' +
                '}';
    }
}
