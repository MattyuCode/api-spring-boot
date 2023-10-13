package com.sistema.SistemaWebAuxiliatura.DTO;

import java.util.Date;

public record AuthenticationResponse(String access_token, String user, Date expirationDate) {
}
