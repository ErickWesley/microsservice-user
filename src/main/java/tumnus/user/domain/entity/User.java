package tumnus.user.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;

@Entity
@Table(name = "usuario")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "sobrenome")
    private String sobrenome;
    @Column(name = "email")
    private String email;
    @Column(name = "cpf")
    private String cpf;

    //Será inserida a senha posteriormente
    /*private String senha;*/

    @Column(name = "data_de_nascimento")
    private Date dataDeNascimento;
    @Column(name = "genero")
    private char genero;
    @Column(name = "telefone")
    private String telefone;

    @Column(name = "foto_de_perfil")
    private String fotoDePerfil;

    @Column(name = "endereco")
    private String endereco;

}
