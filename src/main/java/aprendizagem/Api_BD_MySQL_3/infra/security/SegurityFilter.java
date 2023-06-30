package aprendizagem.Api_BD_MySQL_3.infra.security;

import aprendizagem.Api_BD_MySQL_3.domain.users.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SegurityFilter extends OncePerRequestFilter {


    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var token = recuperarToken(request); // captura token do cabeçario para teste

        if(token != null){
            var subject = tokenService.getSubject(token);// testa tokem e retorna o nome do usuario
            var usuario = repository.findByLogin(subject);

            var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }


        filterChain.doFilter(request,response); // libera para acessar os controllers


    }

    private String recuperarToken(HttpServletRequest request) {

        var tokenDoHeader = request.getHeader("Authorization");
        if(tokenDoHeader != null){
            return tokenDoHeader.replace("Bearer ", "");
        }
        return null;
    }
}
