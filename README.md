# Медицинский портал

Учебный Java-макет для работы с абстрактными классами и полиморфизмом.

## Структура

- `PatientCard` — общая карточка пациента.
- `MedicalDocument` — абстрактный базовый класс медицинского документа.
- `MedicalCertificate` — абстрактная основа справок со сроком действия.
- `HealthStatusCertificate` и `VaccinationCertificate` — конкретные справки.
- `DocumentStatus` — статус документа (`DRAFT` или `GENERATED`).
- `PortalUser` — абстрактный базовый класс пользователя портала.
- `AdminUser` — администратор с личным кабинетом и доступными разделами.
- `MedicalPortalDemo` — пример работы кабинета, карточки пациента и справок.

Иерархия:

```text
PortalUser (abstract)
└── AdminUser

MedicalDocument (abstract)
└── MedicalCertificate (abstract)
    ├── HealthStatusCertificate
    └── VaccinationCertificate
```

Кабинет выводит данные учетной записи и список разделов. Это демонстрационная модель без входа по паролю и без выполнения административных операций.

Запуск из папки проекта при установленном JDK:

```text
javac *.java
java MedicalPortalDemo
```
