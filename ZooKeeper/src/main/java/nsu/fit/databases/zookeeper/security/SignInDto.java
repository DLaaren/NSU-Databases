package nsu.fit.databases.zookeeper.security;

public record SignInDto(
        String login,
        String password) {
}
