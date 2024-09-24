package designpattern._1_creational._004_builder.example_03_Immutable_Object;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
class User {

    private final String firstName;
    private final String lastName;
    private final int age;
    private final String address; 

    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.address = builder.address;
    }
    
    static class UserBuilder {

    	private String firstName; // Not final
    	private String lastName; // Not final
    	private int age; // Not final
    	private String address; // Not final
    
    	 public UserBuilder setFirstName(String firstName) {
             this.firstName = firstName;
             return this;
         }

         public UserBuilder setLastName(String lastName) {
             this.lastName = lastName;
             return this;
         }

         public UserBuilder setAge(int age) {
             this.age = age;
             return this;
         }

         public UserBuilder setAddress(String address) {
             this.address = address;
             return this;
         }

         public User build() {
        	 return new User(this);
         }
    }
}
