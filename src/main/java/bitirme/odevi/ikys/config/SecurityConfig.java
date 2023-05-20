package bitirme.odevi.ikys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .and()
//                .logout() // Çıkış işlemini yapılandırma
//                .logoutUrl("/logout") // Çıkış URL'si
//                .logoutSuccessUrl("/login?logout") // Başarılı çıkıştan sonra yönlendirilecek URL
//                .invalidateHttpSession(true) // Oturumu geçersiz kılma
//                .deleteCookies("JSESSIONID"); // Kullanıcıya ait çerezleri silme
//        http.build();
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}