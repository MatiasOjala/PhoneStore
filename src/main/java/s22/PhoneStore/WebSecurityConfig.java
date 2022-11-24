package s22.PhoneStore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import s22.PhoneStore.service.UserDetailServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig {
	@Autowired
	private UserDetailServiceImpl userDetailsService;

	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {

		return http.authorizeRequests(auth -> {
			auth.antMatchers("/phoneslist/**").permitAll();
			auth.antMatchers("/mainpage/**").permitAll();
			
			// Jos käyttäjä on ADMIN, hänellä on oikeudet kaikkialle.
			auth.antMatchers("/add/**").hasAuthority("ADMIN");
			auth.antMatchers("/save/**").hasAuthority("ADMIN");
			auth.antMatchers("/delete/**").hasAuthority("ADMIN");
			auth.antMatchers("/edit/**").hasAuthority("ADMIN");
			auth.antMatchers("/api/**").hasAuthority("ADMIN");
			auth.antMatchers("/applicationUsers/**").hasAuthority("ADMIN");
			auth.antMatchers("/profile/**").hasAuthority("ADMIN");
			auth.antMatchers("/phones/**").hasAuthority("ADMIN");
			// kaikki http pyynnöt autentikoidaan
			auth.anyRequest().authenticated();
		}).csrf().ignoringAntMatchers("h2-console").and()
				// Kertoo minne mennä onnistuneen kirjautumisen jälkeen
				.formLogin().defaultSuccessUrl("/mainpage", true).and()
				// Uloskirjautuminen sallittu kaikille
				.logout().permitAll().and()

				//
				.httpBasic(Customizer.withDefaults()).build();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
}