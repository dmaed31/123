import java.time.LocalDate;
import java.util.UUID;

public final class PatientCard {
    private final UUID id;
    private final String fullName;
    private final LocalDate birthDate;
    private final String phone;
    private final String email;
    private final String address;

    public PatientCard(
            String fullName,
            LocalDate birthDate,
            String phone,
            String email,
            String address) {
        this.id = UUID.randomUUID();
        this.fullName = requireText(fullName, "ФИО");
        if (birthDate == null || birthDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Дата рождения указана некорректно");
        }
        this.birthDate = birthDate;
        this.phone = requireText(phone, "Телефон");
        this.email = requireText(email, "Email");
        this.address = requireText(address, "Адрес");
    }

    public UUID getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String format() {
        return "Карточка пациента"
                + "\nID: " + id
                + "\nФИО: " + fullName
                + "\nДата рождения: " + birthDate
                + "\nТелефон: " + phone
                + "\nEmail: " + email
                + "\nАдрес: " + address;
    }

    private static String requireText(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " не должно быть пустым");
        }
        return value.trim();
    }
}
