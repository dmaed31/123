import java.time.LocalDate;

public final class MedicalPortalDemo {
    private MedicalPortalDemo() {
    }

    public static void main(String[] args) {
        PortalUser admin = new AdminUser(
                "admin01",
                "Мария Смирнова",
                "Регистратура");
        PatientCard patient = new PatientCard(
                "Алексей Петров",
                LocalDate.of(1995, 5, 12),
                "+7 999 000-00-00",
                "alexey.petrov@example.com",
                "Москва");

        MedicalDocument[] documents = {
                new HealthStatusCertificate(
                        patient,
                        "Противопоказания не выявлены",
                        LocalDate.now().plusMonths(6)),
                new VaccinationCertificate(
                        patient,
                        "Вакцинация от гриппа",
                        LocalDate.now().minusMonths(1),
                        LocalDate.now().plusMonths(11))
        };

        System.out.println(admin.renderCabinet());
        System.out.println();
        System.out.println(patient.format());
        for (MedicalDocument document : documents) {
            System.out.println();
            System.out.println(document.generate());
            System.out.println("Статус: " + document.getStatus());
        }
    }
}
