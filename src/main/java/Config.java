public class Config {

//This configuration class has three private properties

    private String url;
    private String username;
    private String password;


//Each getter takes the property and declares that if the property is null
//Assign it with a specified object appropriate value

    public String getUrl() {
        if (url == null){
            url = "jdbc:mysql://localhost/adlister_db?serverTimezone=UTC&useSSL=false";
        }
        return url;
    }

    public String getUsername() {
        if(username == null) {
            username = "codyTheDuck";
        }
        return username;
    }


    public String getPassword() {
        if(password == null) {
            password = "cody";
        }
        return password;
    }

}
