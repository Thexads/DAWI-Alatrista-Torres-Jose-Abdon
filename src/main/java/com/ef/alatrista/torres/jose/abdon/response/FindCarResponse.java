package com.ef.alatrista.torres.jose.abdon.response;

import com.ef.alatrista.torres.jose.abdon.dto.CarDTO;

public record FindCarResponse(String code,
                              String error,
                              Iterable<CarDTO> cars) {
}
