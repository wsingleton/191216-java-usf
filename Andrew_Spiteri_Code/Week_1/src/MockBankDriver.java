import java.io.IOException;

public class MockBankDriver {
    public static void main(String[] args) throws IOException {
        if()
        System.out.println("Would you like to register (enter 0) or login (enter 1)");

        switch(System.in.read()){
            case 0:
                RegisterUser.registerUser();
                break;
            case 1:
                Login.login();
                break;
            default:

                break;
        }
    }

}
