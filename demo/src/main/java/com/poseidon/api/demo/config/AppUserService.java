package com.poseidon.api.demo.config;

import com.poseidon.api.demo.domain.User;
import com.poseidon.api.demo.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Tool used with AppUser and SpringSecurityConfig
 *  @author w-boar
 *  @version 1.0
 */
@Service
public class AppUserService implements UserDetailsService {
    /**
     *  * @param UserRepository
     */
    private UserRepository userRepository;

    public AppUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);
        AppUser appUser = new AppUser(user);
        return appUser;
    }
}
