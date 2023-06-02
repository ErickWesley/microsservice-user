package tumnus.user.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tumnus.user.domain.entity.User;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private String nome;
    private String sobrenome;
    private String email;
    private String cpf;
    private String endereco;

    public static UserResponse converterParaUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setNome(user.getNome());
        userResponse.setSobrenome(user.getSobrenome());
        userResponse.setEmail(user.getEmail());
        userResponse.setCpf(user.getCpf());
        userResponse.setEndereco(user.getEndereco());
        return userResponse;
    }

    public static List<UserResponse> converterParaListResponse(List<User> usuarios) {
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user : usuarios) {
            userResponses.add(converterParaUserResponse(user));
        }
        return userResponses;
    }

}
