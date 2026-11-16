import java.time.LocalDate;

public abstract class MedicalCertificate extends MedicalDocument {
    private final LocalDate validUntil;

    protected MedicalCertificate(PatientCard patient, LocalDate validUntil) {
        super(patient);
        if (validUntil == null || validUntil.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Срок действия не может быть пустым или в прошлом");
        }
        this.validUntil = validUntil;
    }

    public final LocalDate getValidUntil() {
        return validUntil;
    }

    public final boolean isValidOn(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Дата проверки не должна быть пустой");
        }
        return !date.isAfter(validUntil);
    }

    @Override
    protected final String renderBody() {
        return certificateDetails() + "\nДействительна до: " + validUntil;
    }

    protected abstract String certificateDetails();
}
