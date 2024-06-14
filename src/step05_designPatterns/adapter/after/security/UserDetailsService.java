package step05_designPatterns.adapter.after.security;

public interface UserDetailsService {
    UserDetails loadUserByUsername(String username);
}
