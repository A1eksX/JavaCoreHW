import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Director extends Employee {
    public Director(String FIO, String position, String phone, BigDecimal salary, LocalDate birthDate) {
        super(FIO, position, phone, salary, birthDate);
    }

    /**
     * 2.  Опишите класс руководителя, наследник от сотрудника.
     * 2.1 Перенесите статический метод повышения зарплаты в класс руководителя, модифицируйте метод таким
     *     образом, чтобы он мог поднять заработную плату всем, кроме руководителей.
     * 2.2 В основной программе создайте руководителя и поместите его в общий массив сотрудников.
     * 2.3 Повысьте зарплату всем сотрудникам и проследите, чтобы зарплата руководителя не повысилась.
     */

    public void increaseSalaryForColective(List<Employee> employeeList, int value){
        for (Employee e : employeeList) {
            if (!(e instanceof Director)){
                e.increaseSalary(value);
            }
        }
    }


}
