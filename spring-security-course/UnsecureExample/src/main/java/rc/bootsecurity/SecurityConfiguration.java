package rc.bootsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()  // Geliştirme için in memory şeklinde çalış
                .withUser("admin").password(passwordEncoder().encode("123")).roles("ADMIN")  // Admin ekle
                .and()
                .withUser("Kaan").password(passwordEncoder().encode("1")).roles("USER")  // Kullanıcı ekle
                .and()
                .withUser("manager").password(passwordEncoder().encode("1")).roles("MANAGER");
    }

    /**
     * ant Matcher lar verilen sıra ile çalıştırılır. Bu yüzden birbirini ezmeyecek sırada verilmeli
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/index.html").permitAll()  // Anasayfaya herkes girebilsin
                .antMatchers("/profile/**").authenticated()  // Herkes kendi profiline girebilsin
                .antMatchers("/admin/**").hasAnyRole("ADMIN")  // Admin altındaki her şeye erişim sadece admine
                .antMatchers("/management/index").hasAnyRole("ADMIN", "MANAGER")
                .and()
                .httpBasic();
    }

    /**
     * Şifrelerin nasıl tutulacağı ile ilgili ayar
     * Yapılmazsa hata verir
     * @return BCryptPasswordEncoder
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
