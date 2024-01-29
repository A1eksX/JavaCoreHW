package task2;

import lombok.Data;

import java.sql.Array;
import java.time.LocalDate;
@Data
public class Customer  {
    private String FIO;
    private LocalDate birthDay;
    private String phone;

    public Customer(String FIO, LocalDate birthDay, String phone) {
        this.FIO = FIO;
        this.birthDay = birthDay;
        this.phone = phone;
    }
//
//    @Override
//    public String toString() {
//        return String.format("FIO: %s, birthDay: %d, phone: %s ", FIO, birthDay, phone);
//    }
}
