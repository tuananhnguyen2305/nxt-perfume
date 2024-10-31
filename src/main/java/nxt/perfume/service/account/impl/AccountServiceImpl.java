package nxt.perfume.service.account.impl;

import nxt.perfume.dto.CreateAccountDTO;
import nxt.perfume.entity.Account;
import nxt.perfume.http.response.ApiResponse;
import nxt.perfume.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class AccountServiceImpl implements AccountService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public ApiResponse createAccount(CreateAccountDTO dto) {
        Account account = new Account();

        account.setEmail(dto.getEmail());
        account.setUsername(dto.getUsername());
        account.setPassword(dto.getPassword());
        account.setFullName(dto.getFullName());
        account.setPhoneNumber(dto.getPhoneNumber());
        account.setAddress(dto.getAddress());
        account.setAvatar(dto.getAvatar());
        account.setRole(dto.getRole());

        return new ApiResponse(200, "Create account successfully", mongoTemplate.insert(account));
    }
}
