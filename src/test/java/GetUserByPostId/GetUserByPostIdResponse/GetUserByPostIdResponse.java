package GetUserByPostId.GetUserByPostIdResponse;

import lombok.Getter;
import lombok.Setter;

@Getter
public class GetUserByPostIdResponse{

	@Setter
	private int statusCode;

	private String firstName;
	private String lastName;
	private String gender;
	private String phone;
	private String dateOfBirth;
	private Location location;
	private String id;
	private String updatedDate;
	private String title;
	private String picture;
	private String email;
	private String registerDate;

	@Getter
	public class Location{
		private String country;
		private String city;
		private String street;
		private String timezone;
		private String state;
	}
}