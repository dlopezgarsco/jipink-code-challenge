package dlopezgarsco.jipink_code_challenge

import io.r2dbc.h2.H2ConnectionConfiguration
import io.r2dbc.h2.H2ConnectionFactory
import io.r2dbc.spi.ConnectionFactory
import org.flywaydb.core.Flyway
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories


@Configuration
@EnableR2dbcRepositories
class DatabaseConfiguration : AbstractR2dbcConfiguration() {
  @Value("\${spring.flyway.url}")
  private val flywayUrl: String = ""

  @Value("\${spring.r2dbc.username}")
  private val userName: String = ""

  @Value("\${spring.r2dbc.password}")
  private val password: String = ""

  @Value("\${spring.r2dbc.dbname}")
  private val dbName: String = ""

  @Bean
  override fun connectionFactory(): ConnectionFactory {
    return H2ConnectionFactory(
      H2ConnectionConfiguration.builder()
        .inMemory(dbName)
        .username(userName)
        .password(password)
        .build()
    )
  }

  @Bean(initMethod = "migrate")
  fun flyway(): Flyway {
    return Flyway.configure()
      .dataSource(
        flywayUrl,
        userName,
        password
      )
      .baselineOnMigrate(true)
      .load()
  }

}