package br.com.mazonhenrique.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {}
