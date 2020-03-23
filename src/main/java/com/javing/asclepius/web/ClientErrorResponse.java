package com.javing.asclepius.web;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClientErrorResponse {

    private String error;
}
