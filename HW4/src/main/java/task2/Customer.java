package task2;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Customer  {
    private String FIO;
    private LocalDate birthDay;
    private String phone;
    private Gender gender;

    public Customer(String FIO, LocalDate birthDay, String phone, Gender gender) {
        this.FIO = FIO;
        this.birthDay = birthDay;
        this.phone = phone;
        this.gender = gender;
    }

}
