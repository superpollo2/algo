package co.com.comll.r2dbc.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Configuration
@ConfigurationProperties(prefix = "postgresql")
public class PostgresqlConnectionProperties{

        private String dbname;
        private Integer schema;
        private String username;
        private String password;
        private String host;
        private Integer port;
}
