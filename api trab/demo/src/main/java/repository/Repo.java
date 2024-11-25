package repository;

import model.Tarefa;
import org.springframework.scheduling.config.Task;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class Repo implements UserDetailsService {

    public static Tarefa save(Task tarefa) {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Usuário fixo para teste. Substitua por lógica de banco de dados.
        if ("admin".equals(username)) {
            return new User("admin", new BCryptPasswordEncoder().encode("password"), Collections.emptyList());
        }
        throw new UsernameNotFoundException("Usuário não encontrado");
    }
}
