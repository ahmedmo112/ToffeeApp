public interface IAuthentication {
    public boolean login(String email, String password);
    public boolean logout();
    public boolean register(String email, String password, String name, String phone, String address);
    public boolean resetPassword(String email);
}
