package designpattern._1_creational._004_builder.example_03_Immutable_Object;

public class UserApp {

	public static void main(String[] args) {
		
		// Client Code
		User user = new User.UserBuilder()
		                .setFirstName("John")
		                .setLastName("Doe")
		                .setAge(30)
		                .setAddress("123 Main St")
		                .build();
		
		
		System.out.println(user);
	}
	
}
