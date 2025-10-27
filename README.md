# Submit Mod S

## Описание проекта

Сервисная часть Minecraft мода, которая сохраняем комментарии пользователя в бд на Postgres.

Основные функции:
- Создание нового пользователя в бд (Функционал реализован но не утвержден).
- Добавление нового сообщения пользователя в бд.

## Технологии

- **Java**: 21
- **Spring Boot**: 3.5.6
- **Spring Data JPA**: 3.5.6
- **PostgreSQL**: latest
- **Maven**: 3.9.11
- **Postman**: latest
- **Git**: 2.46.2.windows.1
- **Docker**: version 28.3.3, build 980b856

### Основные endpoints API

| Метод | Endpoint                        | Описание                              |
|-------|---------------------------------|---------------------------------------|
| POST  | `/submit-mod/`                  | Добавить нового пользователя          |
| POST  | `/submit-mod/{id}/new-message/` | Добавить новое сообщения пользователя |

### Пример запроса
**Создание задачи**:
```bash
POST http://localhost:8080/submit-mod/
Content-Type: application/json

{
    "username": "Jojo",
    "uuid": "hfhfhjs-74ch8-lll7" 
}
```

**Ответ**:
```json
{
  "id": 1,
  "username": "Jojo",
  "uuid": "hfhfhjs-74ch8-lll7",
  "createdAt": "2025-10-27T17:33:28.5609466",
  "userMessages": []
}
```