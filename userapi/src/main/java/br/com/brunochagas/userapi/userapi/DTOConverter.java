package br.com.brunochagas.userapi.userapi;

public class DTOConverter {
    
    public static UserDTO convert(User user){
        UserDTO userDTO = new UserDTO(user.getNome(), user.getCpf(), user.getEndereco(), user.getEmail(), user.getTelefone(), user.getDataCadastro());
        return userDTO;
    }
}
