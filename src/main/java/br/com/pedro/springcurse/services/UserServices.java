package br.com.pedro.springcurse.services;


import br.com.pedro.springcurse.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.logging.Logger;


@Service
public class UserServices implements UserDetailsService {
    @Autowired
    UserRepository repository;

    public UserServices(UserRepository repository) {
        this.repository = repository;
    }

    private Logger logger = Logger.getLogger(UserServices.class.getName());


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("FINDING ONE USER by name: " + username);
        var user = repository.findByUsername(username);
        if (user != null) {

            return user;

        } else {
            throw new UsernameNotFoundException("Username " + username + " not found");
        }
    }
}
