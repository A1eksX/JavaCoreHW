import lombok.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

//@Getter
//@Setter
// @EqualsAndHashCode
//@ToString
@AllArgsConstructor
@Data

public class Employee {
    private String FIO;
    private String position;
    private String phone;
    private BigDecimal salary;
    private LocalDate birthDate;

//    public task1.Employee(String FIO, String position, String phone, BigDecimal salary, LocalDate birthDate) {
//        this.FIO = FIO;
//        this.position = position;
//        this.phone = phone;
//        this.salary = salary;
//        this.birthDate = birthDate;
//    }

//    public String getFIO() {
//        return FIO;
//    }
//
//    public String getPosition() {
//        return position;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public BigDecimal getSalary() {
//        return salary;
//    }
//
//    public LocalDate getBirthDate() {
//        return birthDate;
//    }
//
//    public void setFIO(String FIO) {
//        this.FIO = FIO;
//    }
//
//    public void setPosition(String position) {
//        this.position = position;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public void setSalary(BigDecimal salary) {
//        this.salary = salary;
//    }
//
//    public void setBirthDate(LocalDate birthDate) {
//        this.birthDate = birthDate;
//    }

    public int getAge(){
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }

    public void increaseSalary(int value){
        this.salary = salary.add(BigDecimal.valueOf(value));
    }

//    @Override
//    public String toString() {
//        LocalDate currentDate = LocalDate.now();
//        int age = Period.between(birthDate, currentDate).getYears();
//        return String.format("%s - %s , phone    - %s,  salary - %s , age - %s ", FIO, position, phone, salary, this.getAge());
//    }

    /**
     * 1. Написать прототип компаратора - метод внутри класса сотрудника, сравнивающий
     *  две даты, представленные в виде трёх чисел гггг-мм-дд, без использования
     *  условного оператора.
     */
    public String compare(Employee e, LocalDate localDate){
        if(e.getBirthDate().isAfter(localDate)){
            return "Сотрудник родился после указанной даты";
        }else if (e.getBirthDate().isBefore(localDate)){
            return "Сотрудник родился до указанной даты";
        }else {
            return "Сотрудник родился в этот день";
        }
    }

}
