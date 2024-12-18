package com.ef.alatrista.torres.jose.abdon.response;

import com.ef.alatrista.torres.jose.abdon.dto.CarDetailDTO;

public record FindDetailsCarResponse(String code,
                                     String error,
                                     CarDetailDTO carDetailDTO) {
}
