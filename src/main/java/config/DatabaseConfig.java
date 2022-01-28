package config;

public class DatabaseConfig {
    @EnableJpaRepositories(basePackages = "ir.maktab.data.repository")
    @PropertySource("classpath:database.properties")
    @Configuration
    @EnableTransactionManagement
    public class DatabaseConfig {

        @Autowired
        private Environment environment;

        @Bean
        DataSource dataSource() {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName(environment.getProperty("db.driver"));
            dataSource.setUrl(environment.getProperty("db.url"));
            dataSource.setUsername(environment.getProperty("db.user"));
            dataSource.setPassword(environment.getProperty("db.password"));
            return  dataSource;
        }

        @Bean
        LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
            LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
            entityManagerFactoryBean.setDataSource(dataSource);
            entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
            entityManagerFactoryBean.setPackagesToScan("ir.maktab.data.model", "ir.maktab.data.repository");
            entityManagerFactoryBean.setJpaProperties(hibernateProperties());
            return entityManagerFactoryBean;

        }

        private Properties hibernateProperties() {
            Properties jpaProperties = new Properties();
            jpaProperties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
            jpaProperties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
            jpaProperties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
            jpaProperties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
            return jpaProperties;
        }

        @Bean
        JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
            JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(entityManagerFactory);
            return transactionManager;
        }


    }
}
