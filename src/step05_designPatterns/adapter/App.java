package step05_designPatterns.adapter;

import step05_designPatterns.adapter.after.AccountService;
import step05_designPatterns.adapter.after.AccountUserDetailsService;
import step05_designPatterns.adapter.after.security.LoginHandler;
import step05_designPatterns.adapter.after.security.UserDetailsService;

public class App {
    public static void main(String[] args) {
        // 동작 체크용
        AccountService accountService = new AccountService();
        UserDetailsService userDetailsService = new AccountUserDetailsService(accountService);
        LoginHandler loginHandler = new LoginHandler(userDetailsService);
        String login = loginHandler.login("admin", "admin");
        System.out.println(login);
    }
}
