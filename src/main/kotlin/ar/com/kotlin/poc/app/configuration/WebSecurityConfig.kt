package ar.com.kotlin.poc.app.configuration

import ar.com.kotlin.poc.security.filter.JWTAuthorizationFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@EnableWebSecurity
@Configuration
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    @Bean
    fun jwtAuthorizationFilter() = JWTAuthorizationFilter()

    override fun configure(http: HttpSecurity) {
             http.csrf().disable()
                 .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

             http.addFilterBefore(jwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter::class.java)
                 .authorizeRequests()
                 .antMatchers(HttpMethod.POST, "/user").permitAll()
                 .antMatchers("/auth/login").permitAll()
                 .anyRequest().authenticated()
    }
}