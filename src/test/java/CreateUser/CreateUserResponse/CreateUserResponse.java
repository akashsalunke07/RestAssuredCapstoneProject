package CreateUser.CreateUserResponse;


import lombok.Getter;
import lombok.Setter;

@Getter
public
class CreateUserResponse{

	@Setter
	private int statusCode;

	private String firstName;
	private String lastName;
	private String id;
	private String updatedDate;
	private String email;
	private String registerDate;
}