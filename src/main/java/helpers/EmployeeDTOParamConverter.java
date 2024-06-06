package helpers;

import dto.EmployeeIdDto;
import jakarta.ws.rs.ext.ParamConverter;

import java.time.LocalDate;

public class EmployeeDTOParamConverter implements ParamConverter {
    @Override
    public Object fromString(String value) {

        int department_Code;
        int idSeq;
        String hire_date;

        department_Code = Integer.parseInt(value.substring(0, 2));
        idSeq = Integer.parseInt(value.substring(2, 6));
        hire_date = value.substring(6);

        EmployeeIdDto employeeIdDto = new EmployeeIdDto(department_Code, idSeq, hire_date);

        return employeeIdDto;
    }

    @Override
    public String toString(Object value) {
        return value.toString();
    }
}