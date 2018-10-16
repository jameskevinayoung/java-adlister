public class Config {
    private String url;
    private String username;
    private String password;

    public String getUrl(){
        url = "jdbc:mysql://localhost/adlister_db?serverTimezone=UTC&useSSL=false";
        return url;
    }

    public String getUsername() {
        username = "codyTheDuck";
        return username;
    }


    public String getPassword() {
        password = "cody";
        return password;
    }

}
