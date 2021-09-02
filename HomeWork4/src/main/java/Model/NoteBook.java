package Model;

import java.util.HashMap;
import java.util.Map;

public class NoteBook{

    Map<String, String> info = new HashMap<>();

    public void putField(String key, String value)
    {
        info.put(key, value);
    }

/*     private String surname;
    private String name;
    private String patronymic;
    private String nickname;
    private String comment;
    private String group;
    private String homeNumber;
    private String mobileNumber1;
    private String mobileNumber2;
    private String email;
    private String skype;
    private String address;
    private String inputDate;
    private String lastChangeDate;

    public String getSurname() { return surname; }

    public String getName() { return name; }

    public String getPatronymic() { return patronymic; }

    public String getNickname() { return nickname; }

    public String getComment() { return comment; }

    public String getGroup() { return group; }

    public String getHomeNumber() { return homeNumber; }

    public String getMobileNumber1() { return mobileNumber1; }

    public String getMobileNumber2() { return mobileNumber2; }

    public String getEmail() { return email; }

    public String getSkype() { return skype; }

    public String getAddress() { return address; }

    public String getInputDate() { return inputDate; }

    public String getLastChangeDate() { return lastChangeDate; }

    public void setSurname(String surname) { this.surname = surname; }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public void setMobileNumber1(String mobileNumber1) {
        this.mobileNumber1 = mobileNumber1;
    }

    public void setMobileNumber2(String mobileNumber2) {
        this.mobileNumber2 = mobileNumber2;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public void setLastChangeDate(String lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }*/
}
