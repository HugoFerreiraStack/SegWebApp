package br.com.seg.econotaxi.oauth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("econotaxi_restservice");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .and()
                .authorizeRequests()
                .antMatchers("/gs-app-websocket/**").permitAll()
                .antMatchers("/rest/usuario/nova-conta/**").permitAll()
                .antMatchers("/rest/corridaLocal/**").permitAll()
                .antMatchers("/rest/usuario/versaoApp").permitAll()
                .antMatchers("/rest/usuario/deslogarMotorista").permitAll()
                .antMatchers("/rest/usuario/versaoApp/").permitAll()
                .antMatchers("/rest/usuario/deslogarMotorista/").permitAll()
                .antMatchers("/rest/usuario/passageiros/").permitAll()
                .antMatchers("/rest/**").authenticated()
                .anyRequest().denyAll();

    }
}
