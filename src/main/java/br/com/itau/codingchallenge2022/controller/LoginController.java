package br.com.itau.codingchallenge2022.controller;

import br.com.itau.codingchallenge2022.dto.Login;
import br.com.itau.codingchallenge2022.dto.Session;
import br.com.itau.codingchallenge2022.model.User;
import br.com.itau.codingchallenge2022.repository.UserRepository;
import br.com.itau.codingchallenge2022.security.JWTCreator;
import br.com.itau.codingchallenge2022.security.JWTObject;
import br.com.itau.codingchallenge2022.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

/**
 * Esse {@link RestController} é responsável por receber todas
 * as requisições de login, realizá-los e gerar os tokens.
 * @author ArturBarreto
 */
@RestController
public class LoginController {

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private SecurityConfig securityConfig;
    @Autowired
    private UserRepository repository;

    @GetMapping("/login")
    public String welcome(){
        return "Para fazer login, forneça um JSON com a seguinte estrutura:\n" +
                "{\n" +
                "    \"username\": \"SEU_USER_NAME\",\n" +
                "    \"password\": \"SUA_SENHA\"\n" +
                "}\n";
    }

    @PostMapping("/login")
    public Session login(@RequestBody Login login){
        User user = repository.findByUsername(login.getUsername());
        if(user!=null) {
            boolean passwordOk =  encoder.matches(login.getPassword(), user.getPassword());
            if (!passwordOk) {
                throw new RuntimeException("Senha inválida para o usuário: " + login.getUsername());
            }
            // Estamos enviando um objeto Sessão para retornar mais informações do usuário
            Session session = new Session();
            session.setLogin(user.getUsername());

            JWTObject jwtObject = new JWTObject();
            jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
            jwtObject.setExpiration((new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION)));
            jwtObject.setRoles(user.getRoles());
            session.setToken(JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject));
            return session;
        }else {
            throw new RuntimeException("Erro ao tentar fazer login!");
        }
    }
}