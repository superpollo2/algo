package co.com.comll.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class UserDTO {

    private String  nombres;
    private String  apellidos;
    private String  cedula;
    private String  fechaNacimiento;
    private String  ciudadNacimiento;
    private String  ciudadResidencia;
    private String  estadoCivil;
}
