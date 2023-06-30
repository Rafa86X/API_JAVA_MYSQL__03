package aprendizagem.Api_BD_MySQL_3.controller;

import aprendizagem.Api_BD_MySQL_3.domain.users.DataLogin;
import aprendizagem.Api_BD_MySQL_3.domain.users.User;
import aprendizagem.Api_BD_MySQL_3.infra.security.DataresposeJWT;
import aprendizagem.Api_BD_MySQL_3.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class AutenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DataLogin dados){

        var token = new UsernamePasswordAuthenticationToken(dados.login(),dados.password());
        var authentication = manager.authenticate(token);

        var tokenJWT =  tokenService.tokenGeneration((User) authentication.getPrincipal());

        return ResponseEntity.ok( new DataresposeJWT(tokenJWT));

    }
}
