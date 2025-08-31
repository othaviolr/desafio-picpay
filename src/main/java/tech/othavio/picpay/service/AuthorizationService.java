package tech.othavio.picpay.service;


import org.springframework.stereotype.Service;
import tech.othavio.picpay.client.AuthorizationClient;
import tech.othavio.picpay.client.dto.TransferDto;
import tech.othavio.picpay.entity.Transfer;
import tech.othavio.picpay.exception.PicPayException;

@Service
public class AuthorizationService {

    private final AuthorizationClient authorizationClient;

    public AuthorizationService(AuthorizationClient authorizationClient) {
        this.authorizationClient = authorizationClient;
        }

    public boolean isAuthorized(TransferDto transfer) {

        var resp = authorizationClient.isAuthorized();

        if (resp.getStatusCode().isError()) {
            throw new PicPayException();
        }

        return resp.getBody().authorized();
    }
}
