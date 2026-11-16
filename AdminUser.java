public final class AdminUser extends PortalUser {
    private final String department;

    public AdminUser(String username, String fullName, String department) {
        super(username, fullName);
        this.department = requireText(department, "Отдел");
    }

    public String getDepartment() {
        return department;
    }

    @Override
    protected String getRoleName() {
        return "Администратор";
    }

    @Override
    protected String getProfileDetails() {
        return "Отдел: " + department;
    }

    @Override
    protected String[] getAvailableActions() {
        return new String[] {
                "Управление карточками пациентов",
                "Просмотр и генерация медицинских справок",
                "Управление учетными записями"
        };
    }
}
