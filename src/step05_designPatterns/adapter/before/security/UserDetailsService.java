package step05_designPatterns.adapter.before.security;

public interface UserDetailsService {
    UserDetails loadUserByUsername(String username);
}
