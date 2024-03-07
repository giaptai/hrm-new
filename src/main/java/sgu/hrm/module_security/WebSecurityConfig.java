package sgu.hrm.module_security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import sgu.hrm.module_utilities.enums.RoleTaiKhoan;

import java.util.List;

import static java.util.Arrays.*;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig implements WebMvcConfigurer {

    private final TaiKhoanUserDetailsService taiKhoanUserDetailsService;

    private final JWTAuthFilter jwtAuthFilter;
// basic auth
    /* InMemoryUserDetailsManager
     * Không cần làm cái gì hết
     * Chỉ cần tạo userdetails
     * {noop} cho phép lưu mật khẩu plain text không mã hóa
     * */
    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails minhthu = User.builder()
                .username("ThuNTM")
                .password("{noop}123456")
                .roles("ADMIN").build();
        UserDetails tai = User.builder()
                .username("TaiNG")
                .password("{noop}123456")
                .roles("EMPLOYEE").build();
        return new InMemoryUserDetailsManager(minhthu, tai);
    }
    */
    //JDBC Authentication plain text
//    @Bean
//    public UserDetailsManager userDetailsManager(DataSource dataSource){
//        return new JdbcUserDetailsManager(dataSource);
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        security.cors(corsConfigurer -> corsConfigurer.configurationSource(corsConfigurationSource()))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(configure ->
                                configure
                                        .requestMatchers("/dang-nhap").permitAll()
                                        .requestMatchers("/ca-nhan/tai-khoan").hasAnyAuthority("ADMIN", "EMPLOYEE")
                                        .requestMatchers("/nhan-vien/**").hasAuthority("ADMIN")
                                        .requestMatchers("/ca-nhan/*").hasAuthority("EMPLOYEE")
                                        .anyRequest().permitAll()
                        //need form with post method
                        //and spring security magic will do the rest
//                ).formLogin(flogin ->
//                        flogin
//                                .loginProcessingUrl("/authenticateTheUser").permitAll()
                )
                .logout(logout ->
                        logout
                                .logoutUrl("/dang-xuat").permitAll())
                .exceptionHandling(execHandle ->
                        execHandle
                                .accessDeniedPage("/tu-choi")
                                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
                )
                .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider()).addFilterBefore(
                        jwtAuthFilter, UsernamePasswordAuthenticationFilter.class
                );
        return security.build();
    }

    //cors
//    @Bean
//    public WebMvcConfigurer webMvcConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**")
//                        .allowedOrigins("http://localhost:8082/**")
//                        .allowedMethods("GET", "POST", "PATCH", "DELETE")
//                        .maxAge(3600);
//            }
//        };
//    }

    //another cors
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:8082"));
        configuration.setAllowedMethods(asList("GET", "POST", "PATCH", "DELETE"));
        configuration.setAllowedHeaders(List.of("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(taiKhoanUserDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    //mã hóa mật khẩu plain-text hoặc bcrypt
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
