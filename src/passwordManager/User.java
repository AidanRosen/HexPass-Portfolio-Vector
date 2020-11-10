package passwordManager;

public class User
{
    private String username;
    private String password;

    public void userPass(String uname, String passwd)
    {
        this.username = uname;
        this.password = passwd;
    }
//we would use this object by doing User.username OR User.password

    //These are methods to work
    public String getUsername()
    {
        return this.username;
    }

    public String getPassword()
    {
        return this.password;
    }
}