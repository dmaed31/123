import java.time.Instant;
import java.util.UUID;

public abstract class MedicalDocument {
    private final UUID id;
    private final PatientCard patient;
    private final Instant createdAt;
    private DocumentStatus status;
    private String generatedContent;

    protected MedicalDocument(PatientCard patient) {
        if (patient == null) {
            throw new IllegalArgumentException("Карточка пациента не должна быть пустой");
        }
        this.id = UUID.randomUUID();
        this.patient = patient;
        this.createdAt = Instant.now();
        this.status = DocumentStatus.DRAFT;
    }

    public final UUID getId() {
        return id;
    }

    public final PatientCard getPatient() {
        return patient;
    }

    public final String getPatientName() {
        return patient.getFullName();
    }

    public final Instant getCreatedAt() {
        return createdAt;
    }

    public final DocumentStatus getStatus() {
        return status;
    }

    public final String getDocumentType() {
        return documentType();
    }

    public final String generate() {
        if (generatedContent == null) {
            String body = requireText(renderBody(), "Содержимое документа");
            generatedContent = "Документ: " + documentType()
                    + "\nПациент: " + patient.getFullName()
                    + "\nДата создания: " + createdAt
                    + "\n\n" + body;
            status = DocumentStatus.GENERATED;
        }
        return generatedContent;
    }

    protected abstract String documentType();

    protected abstract String renderBody();

    protected static String requireText(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " не должно быть пустым");
        }
        return value.trim();
    }
}
