package com.ef.alatrista.torres.jose.abdon.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HikariCpConfig {

    @Value("${DB_FABRIC_URL}")
    private String dbFabricCRUDUrl;
    @Value("${DB_FABRIC_USER}")
    private String dbFabricCRUDUser;
    @Value("${DB_FABRIC_PASS}")
    private String dbFabricCRUDPass;
    @Value("${DB_FABRIC_DRIVER}")
    private String dbFabricCRUDDriver;

    @Bean
    public HikariDataSource HikariCPDataSource() {
        HikariConfig config = new HikariConfig();
        /**
         * Configurar propiedad de conexion a BD
         */
        config.setJdbcUrl(dbFabricCRUDUrl);
        config.setUsername(dbFabricCRUDUser);
        config.setPassword(dbFabricCRUDPass);
        config.setDriverClassName(dbFabricCRUDDriver);
        /**
         * Configurar propiedades del pool de HikariCP
         * - MaximumPoolSize: Máximo # de conexiones del pool.
         * - MinimumIdle: Mínimo # de conexiones inactivas del pool.
         * - IdleTimeout: Tiempo máximo de espera para
         *      eliminar una conexión inactiva.
         * - ConnectionTimeout: Tiempo máximo de espera
         *      para conectarse a la BD.
         */
        config.setMaximumPoolSize(20);
        config.setMinimumIdle(5);
        config.setIdleTimeout(300000);
        config.setConnectionTimeout(30000);

        System.out.println("###### HikariCP initialized ######");
        return new HikariDataSource(config);

    }
}
