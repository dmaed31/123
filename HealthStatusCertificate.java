import java.time.LocalDate;

public final class HealthStatusCertificate extends MedicalCertificate {
    private final String healthStatus;

    public HealthStatusCertificate(PatientCard patient, String healthStatus, LocalDate validUntil) {
        super(patient, validUntil);
        this.healthStatus = requireText(healthStatus, "Сведения о состоянии здоровья");
    }

    @Override
    protected String documentType() {
        return "Справка о состоянии здоровья";
    }

    @Override
    protected String certificateDetails() {
        return "Сведения о состоянии здоровья: " + healthStatus;
    }
}
