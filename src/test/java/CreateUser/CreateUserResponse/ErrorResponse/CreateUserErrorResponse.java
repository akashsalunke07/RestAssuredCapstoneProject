package CreateUser.CreateUserResponse.ErrorResponse;



import lombok.Getter;
import lombok.Setter;

@Getter
public class CreateUserErrorResponse{


	@Setter
	private int statusCode;

	private Data data;
	private String error;


}