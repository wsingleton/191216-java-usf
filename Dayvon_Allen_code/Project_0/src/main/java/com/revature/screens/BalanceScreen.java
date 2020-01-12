package com.revature.screens;
import com.revature.repos.AccountRepository;
import static com.revature.BankDriver.*;

public class BalanceScreen extends Screen {
    public BalanceScreen(String name, String route) {
        super(name, route);
    }

    @Override
    public void render() {
        AccountRepository acctRepo = new AccountRepository();
        System.out.println("Available balance: $" + acctRepo.findAccountBalanceById());
        System.out.println("Press enter to go back to customer portal");
        System.out.print(">");
        String input = console.nextLine();
        router.navigate("/customer");

    }
}
