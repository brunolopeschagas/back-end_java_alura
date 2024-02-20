package br.com.brunochagas.userapi.userapi;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    @NotBlank(message = "CPF é obrigatório")
    private String cpf;
    private String endereço;
    @NotBlank(message = "E-Mail é obrigatório")
    private String email;
    private String telefone;
    private LocalDateTime dadaCadastro;

    public static UserDTO convert(User user){
        UserDTO userDTO = new UserDTO(user.getNome(), user.getCpf(), user.getEndereco(), user.getEmail(), user.getTelefone(), user.getDataCadastro());
        return userDTO;
    }

    public static UserDTO convert(UserDTO user){
        UserDTO userDTO = new UserDTO();
        userDTO.setNome(user.getNome());
        userDTO.setEndereço(user.getEndereço());
        userDTO.setCpf(user.getCpf());
        userDTO.setEmail(user.getEmail());
        userDTO.setTelefone(user.getTelefone());
        userDTO.setDadaCadastro(user.getDadaCadastro());
        return userDTO;
    }
}
