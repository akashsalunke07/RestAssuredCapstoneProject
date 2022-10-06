package GetUserUnderYourAccount.GetUsersUnderYourAccountResponse;

import java.util.List;
import lombok.Data;
import lombok.Setter;

@Data
public class GetUserResponseUnderYourAccount {

	@Setter
	private int statusCode;

	private int total;
	private List<DataItem> data;
	private int limit;
	private int page;
}