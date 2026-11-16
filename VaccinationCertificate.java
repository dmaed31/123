import java.time.LocalDate;

public final class VaccinationCertificate extends MedicalCertificate {
    private final String vaccineName;
    private final LocalDate vaccinationDate;

    public VaccinationCertificate(
            PatientCard patient,
            String vaccineName,
            LocalDate vaccinationDate,
            LocalDate validUntil) {
        super(patient, validUntil);
        if (vaccinationDate == null) {
            throw new IllegalArgumentException("Дата вакцинации не должна быть пустой");
        }
        this.vaccineName = requireText(vaccineName, "Название вакцины");
        this.vaccinationDate = vaccinationDate;
    }

    @Override
    protected String documentType() {
        return "Справка о вакцинации";
    }

    @Override
    protected String certificateDetails() {
        return "Вакцина: " + vaccineName + "\nДата вакцинации: " + vaccinationDate;
    }
}
