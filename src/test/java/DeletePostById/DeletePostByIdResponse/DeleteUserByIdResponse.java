package DeletePostById.DeletePostByIdResponse;

import lombok.Data;
import lombok.Setter;
import lombok.Singular;

@Data
public class DeleteUserByIdResponse{

	@Setter
	private int statusCode;
	private String id;
}