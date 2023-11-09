package com.example.multidb.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.spring.SpringTransactionManager
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@Qualifier("primary")
annotation class PrimaryDataSource

@Qualifier("secondary")
annotation class SecondaryDataSource


@Configuration
@EnableTransactionManagement
class DatasourceConfiguration {
    @Bean
    @PrimaryDataSource
    @ConfigurationProperties(prefix = "spring.datasource.hikari.primary")
    fun primaryHikariConfig(): HikariConfig {
        return HikariConfig()
    }

    @Bean
    @PrimaryDataSource
    @Primary
    fun primaryDataSource(
        @PrimaryDataSource hikariConf: HikariConfig
    ): DataSource {
        return HikariDataSource(hikariConf)
    }

    @Bean("primaryTransactionManager")
    @Primary
    @PrimaryDataSource
    fun primaryTransactionManager(
        @PrimaryDataSource dataSource: DataSource
    ): SpringTransactionManager {
        return SpringTransactionManager(dataSource, showSql = true)
    }

    @Bean
    @SecondaryDataSource
    @ConfigurationProperties(prefix = "spring.datasource.hikari.secondary")
    fun secondaryHikariConfig(): HikariConfig {
        return HikariConfig()
    }

    @Bean
    @SecondaryDataSource
    fun secondaryDataSource(
      @SecondaryDataSource hikariConf: HikariConfig
    ): DataSource {
        return HikariDataSource(hikariConf)
    }

    @Bean("secondaryTransactionManager")
    @SecondaryDataSource
    fun secondaryTransactionManager(@SecondaryDataSource dataSource: DataSource): SpringTransactionManager {
        return SpringTransactionManager(
            dataSource = dataSource, showSql = true
        )
    }
}
