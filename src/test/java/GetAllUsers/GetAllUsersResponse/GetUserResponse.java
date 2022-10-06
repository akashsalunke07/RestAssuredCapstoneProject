package GetAllUsers.GetAllUsersResponse;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
public class GetUserResponse{

	@Setter
	private int statusCode;

	private List<DataItem> data;
	private int total;
	private int limit;
	private int page;

	@Getter
	public static class DataItem{
		private String firstName;
		private String lastName;
		private String id;
		private String title;
		private String picture;
	}
}