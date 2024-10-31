package nxt.perfume.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Account {
    @Id
    private String id;

    private String email;
    private String username;
    private String password;
    private String fullName;
    private String phoneNumber;
    private String address;
    private String avatar;
    private String role;
}
