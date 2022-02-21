package appcentheroku.appcenttodo.jwt.security;


import appcentheroku.appcenttodo.dao.UserDao;
import appcentheroku.appcenttodo.entity.Users;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {


    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> optionalUser = userDao.findByUsername(username);
        Users users = null;
        if(optionalUser.isPresent()){
            users = optionalUser.get();
        }
        return JwtUserDetails.create(users);
    }

    public UserDetails loadUserById(Long id) throws UsernameNotFoundException {
        Optional<Users> optionalUser = userDao.findById(id);
        Users users = null;
        if(optionalUser.isPresent()){
            users = optionalUser.get();
        }
        return JwtUserDetails.create(users);
    }

}
