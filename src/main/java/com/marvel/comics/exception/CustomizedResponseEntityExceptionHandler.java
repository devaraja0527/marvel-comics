package com.marvel.comics.exception;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.marvel.comics.controller.MarvelCharactersController;



@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final Logger logger = LogManager.getLogger(MarvelCharactersController.class);
			
	@Override
    protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.error("ServletRequestBindingException "+ ex.getMessage());
        return new ResponseEntity<>(INVALID_REQUEST, headers, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.info("HttpRequestMethodNotSupportedException [{}]", ex.getMessage());
        return new ResponseEntity<>(INVALID_REQUEST_METHOD, headers, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.info("MethodArgumentNotValidException [{}] - WebRequest[{}]", ex.getMessage(), request);
        return new ResponseEntity<>(INVALID_REQUEST, headers, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.info("HttpMessageNotReadableException [{}]", ex.getMessage());
        return new ResponseEntity<>(INVALID_REQUEST, headers, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.info("HttpMediaTypeNotSupportedException [{}]", ex.getMessage());
        return new ResponseEntity<>(MEDIATYPE_NOT_SUPPORTED, headers, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @ExceptionHandler({HttpMessageConversionException.class, MethodArgumentTypeMismatchException.class})
    public final ResponseEntity<Object> handleInvalidRequestDataException(Exception ex, WebRequest request) {
        logger.info("{} [{}]", ex.getClass().getSimpleName(), ex.getMessage());
        return new ResponseEntity<>(INVALID_REQUEST, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleExceptions(Exception ex, WebRequest request) {
        logger.error("Exception [{}]", ex.getMessage(), ex);
        return new ResponseEntity<>(UNEXPECTED_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
	private static final String INVALID_REQUEST = "In Valid Request";
	private static final String INVALID_REQUEST_METHOD = "In valid Method";
	private static final String MEDIATYPE_NOT_SUPPORTED = "Media Type not supported";
	private static final String UNEXPECTED_ERROR = "Un Expected Error";
			
}
