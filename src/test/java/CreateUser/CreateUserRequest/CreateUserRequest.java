package CreateUser.CreateUserRequest;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateUserRequest{
	private String lastName;
	private String firstName;
	private String email;
}