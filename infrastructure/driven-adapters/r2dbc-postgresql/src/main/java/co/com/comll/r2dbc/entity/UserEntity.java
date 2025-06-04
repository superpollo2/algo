package co.com.comll.r2dbc.entity;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@With
@Builder(toBuilder = true)
@Table("Users")
public class UserEntity {


    private String  nombres;
    private String  apellidos;
    @Id
    private String  cedula;
    private String  fechaNacimiento;
    private String  ciudadNacimiento;
    private String  ciudadResidencia;
    private String  estadoCivil;
}
