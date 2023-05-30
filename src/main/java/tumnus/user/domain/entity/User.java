package tumnus.user.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String cpf;
    private String senha;
    private Date dataDeNascimento;
    private char genero;
    private String telefone;
    private String fotoDePerfil;
    private String endereco;

}
