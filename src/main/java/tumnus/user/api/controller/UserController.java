package tumnus.user.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tumnus.user.domain.entity.User;
import tumnus.user.domain.service.UserService;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UserController {

    private UserService service;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        User usuarioSalvo = service.salvar(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> read(@PathVariable Long id) {
        Optional<User> optionalUser = service.buscarPorId(id);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            User user = optionalUser.get();
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        Optional<User> optionalUser = service.buscarPorId(id);
        if (optionalUser.isPresent()) {
            User usuarioExistente = optionalUser.get();
            usuarioExistente.setNome(user.getNome());
            usuarioExistente.setCpf(user.getCpf());
            User usuarioAtualizado = service.salvar(usuarioExistente);
            return ResponseEntity.ok(usuarioAtualizado);
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }

}
