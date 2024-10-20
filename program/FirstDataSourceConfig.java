/*package program;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
    basePackages = "com.example.repository.first", // Change to your first repository package
    entityManagerFactoryRef = "firstEntityManagerFactory",
    transactionManagerRef = "firstTransactionManager"
)
public class FirstDataSourceConfig {

    @Primary
    @Bean(name = "firstDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.first")
    public DataSource firstDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "firstEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean firstEntityManagerFactory(
        EntityManagerFactoryBuilder builder,
        @Qualifier("firstDataSource") DataSource dataSource) {
        return builder
            .dataSource(dataSource)
            .packages("com.example.model.first") // Change to your first model package
            .persistenceUnit("first")
            .build();
    }

    @Primary
    @Bean(name = "firstTransactionManager")
    public DataSourceTransactionManager firstTransactionManager(
        @Qualifier("firstDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}*/
