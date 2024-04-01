package user.project.userbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// If a user with a given id does not exist in the database, we will throw a ResourceNotFoundException
// Spring Boot will catch this exception, get the error message from the exception
// and send the error message along with the HTTP-status to the client
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
