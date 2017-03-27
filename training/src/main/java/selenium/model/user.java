package selenium.model;

public class user {
    /**
     * Логин пользователя
     */
    public String login;

    /**
     * Пароль
     */
    public String password;

    /**
     * Подтверждение пароля
     */
    public String passwordConfirmation;

    /**
     * Email
     */
    public String email;

    /**
     * Создать пользователя с валидными данными для регистрации
     * @return экземпляр объекта {@link user}
     */
    public static user createValidUser() {
        user user = new user();
        user.login = "uadecltest";
        user.password = "15cf80f1";
        user.passwordConfirmation = user.password;
        user.email = "lenykm@edi.su";
        return user;
    }
}