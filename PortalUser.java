import java.time.Instant;
import java.util.UUID;

public abstract class PortalUser {
    private final UUID id;
    private final String username;
    private final String fullName;
    private final Instant createdAt;

    protected PortalUser(String username, String fullName) {
        this.id = UUID.randomUUID();
        this.username = requireText(username, "Логин");
        this.fullName = requireText(fullName, "ФИО пользователя");
        this.createdAt = Instant.now();
    }

    public final UUID getId() {
        return id;
    }

    public final String getUsername() {
        return username;
    }

    public final String getFullName() {
        return fullName;
    }

    public final Instant getCreatedAt() {
        return createdAt;
    }

    public final String renderCabinet() {
        StringBuilder cabinet = new StringBuilder("Личный кабинет")
                .append("\nПользователь: ").append(fullName)
                .append("\nЛогин: ").append(username)
                .append("\nРоль: ").append(getRoleName())
                .append("\nID учетной записи: ").append(id);

        String details = getProfileDetails();
        if (!details.isEmpty()) {
            cabinet.append('\n').append(details);
        }

        cabinet.append("\nДоступные разделы:");
        for (String action : getAvailableActions()) {
            cabinet.append("\n- ").append(action);
        }
        return cabinet.toString();
    }

    protected abstract String getRoleName();

    protected abstract String[] getAvailableActions();

    protected String getProfileDetails() {
        return "";
    }

    protected static String requireText(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " не должно быть пустым");
        }
        return value.trim();
    }
}
