package com.hhplus.lecture;

public record ErrorResponse(
        String code,
        String message
) {
}