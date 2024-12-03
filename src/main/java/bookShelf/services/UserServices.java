package bookShelf.services;

import bookShelf.dtos.requests.SignUpRequest;
import bookShelf.dtos.responses.SignUpResponse;

public interface UserServices {
    SignUpResponse signUp (SignUpRequest signUpRequest);
}
