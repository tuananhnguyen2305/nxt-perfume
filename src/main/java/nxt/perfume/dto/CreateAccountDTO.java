package nxt.perfume.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAccountDTO {
    private String email;
    private String username;
    private String password;
    private String fullName;
    private String phoneNumber;
    private String address;
    private String avatar;
    private String role;
}
