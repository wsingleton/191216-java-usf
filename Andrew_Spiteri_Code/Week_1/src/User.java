public class User {
    private String username, password, firstName, lastName;
    private int id;
    private Role role;


    public User(String fn, String ln, String username, String pw, Role role) {
        // a call to the super class's constructor is implicitly here if it not provided
        // super();

        firstName = fn; // "this" is not required if no parameters match the field name
        this.lastName = ln; // you can still include it though
        this.username = username; // here we must use "this" to clarify which one we are referencing
        password = pw;
        this.role = role;
    }
    public User(int id, String fn, String ln, String un, String pw, Role role) {
        this(fn, ln, un, pw, role); // constructor chaining
        this.id = id;
    }
    private void setUsername(String username){
        this.username = username;
    }
    private void setPassword(String password){
        this.password = password;
    }
    private void setFirstName(String firstName){
        this.firstName = firstName;
    }
    private void setLastName(String lastName){
        this.lastName = lastName;
    }
    private void setId(int id){ this.id = id; }
//    protected static void registerUser(String[] user){
//        User newUser = new User(user);
//    }
    public  String getUserName(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getID(){
        return id;
    }
    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
