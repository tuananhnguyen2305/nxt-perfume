package nxt.perfume.service.account;

import nxt.perfume.dto.CreateAccountDTO;
import nxt.perfume.http.response.ApiResponse;

public interface AccountService {
    ApiResponse createAccount(CreateAccountDTO dto);
}
