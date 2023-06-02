package tumnus.user.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tumnus.user.api.dto.request.UserRequest;
import tumnus.user.api.dto.response.UserResponse;
import tumnus.user.domain.entity.User;
import tumnus.user.domain.service.UserService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<UserResponse> salvarUsuario(@RequestBody UserRequest userRequest) {
        User user = UserRequest.converterParaUserRequest(userRequest);
        User usuarioSalvo = service.salvar(user);
        UserResponse userResponse = UserResponse.converterParaUserResponse(usuarioSalvo);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> listarUsuarioPorId(@PathVariable Long id) {
        Optional<User> optionalUser = service.buscarPorId(id);
        if (optionalUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        else {
            User user = optionalUser.get();
            return ResponseEntity.status(HttpStatus.OK).body(UserResponse.converterParaUserResponse(optionalUser.get()));
        }
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> listarTodos() {
        List<User> usuarios = service.listarTodos();
        List<UserResponse> userResponses = UserResponse.converterParaListResponse(usuarios);
        return ResponseEntity.status(HttpStatus.OK).body(userResponses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> editarUsuario(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        Optional<User> optionalUser = service.buscarPorId(id);
        User user = UserRequest.converterParaUserRequest(userRequest);

        if (optionalUser.isPresent()) {
            User usuarioExistente = optionalUser.get();
            usuarioExistente.setNome(userRequest.getNome());
            usuarioExistente.setCpf(userRequest.getCpf());
            User usuarioAtualizado = service.salvar(usuarioExistente);
            UserResponse userResponse = UserResponse.converterParaUserResponse(usuarioAtualizado);
            return ResponseEntity.ok(userResponse);
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deletarUsuario(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
