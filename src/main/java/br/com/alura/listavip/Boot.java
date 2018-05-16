package br.com.alura.listavip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Boot {

    // Ele inicia no http://localhost:8080/

    // Roda ao iniciar o servidor
    public static void main(String[] args) {
        // Rodar a config da classe
        SpringApplication.run(Boot.class, args);
    }

    /*
    // Mapeamento
    @RequestMapping("/")
    // Retorna no corpo
    @ResponseBody
    String ola() {
        return "Seja bem vindo!";
    }
	  */
    
    // O Spring gerencia o @Bean
    /*
    @Bean
    public DataSource dataSource() {
        // Criando o data source
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/listavip");
        dataSource.setUsername("root");
        dataSource.setPassword("si");

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        dataSource.setConnectionProperties(properties);

        return dataSource;
    }
    */
}