package step05_designPatterns.adapter.after.security;

public class LoginHandler {
    UserDetailsService userDetailsService;
    public LoginHandler(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public String login(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if(userDetails.getPassword().equals(password)) {
            return userDetails.getUsername();
        }else {
            throw new IllegalArgumentException("password error");
        }
    }
}
