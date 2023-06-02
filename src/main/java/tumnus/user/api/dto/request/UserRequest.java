package tumnus.user.api.dto.request;

import lombok.*;
import tumnus.user.domain.entity.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String nome;
    private String sobrenome;
    private String email;
    private String cpf;
    private String endereco;


    public static User converterParaUserRequest(UserRequest userRequest) {
        User user = new User();
        user.setNome(userRequest.getNome());
        user.setSobrenome(userRequest.getSobrenome());
        user.setEmail(userRequest.getEmail());
        user.setCpf(userRequest.getCpf());
        user.setEndereco(userRequest.getEndereco());
        return user;
    }


}
