package alura.paulo.forumhub.domain.user;

public record DadosListUser(
        Long id,
        String nome,
        String email,
        Boolean status
) {
    public DadosListUser(User user) {
        this(user.getId(), user.getNome(), user.getEmail(), user.getStatus());
    }
}
