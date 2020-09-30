/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author angel
 */
public class ConexionMysql {

    private String URL = "jdbc:mysql://localhost:3306/testJPACRUD";
    private String USER = "root";
    private String PASSWORD = "";

    public DriverManagerDataSource getConexion() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(URL);
        dataSource.setUsername(USER);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

}
