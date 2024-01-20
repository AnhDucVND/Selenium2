package Page_MyAccount.MyDGO.MyDGOUIs;

import org.openqa.selenium.By;

public class LoginPageUI {
    public static String USERNAME_FIELD="//input[@placeholder='Nhập tên đăng nhập']";
    public static String PASSWORD_FIELD="//input[@id='typepassword']";
    public static String LOGIN_BUTTON="//span[contains(text(),\"Đăng nhập\")]/parent::button";
    public static String WELLCOME_LABEL="//span[contains(text(),\"Chào mừng\")]";
    public static String HYPERLINK_MTK="//span[contains(text(),\"Mở tài khoản mới\")]";
}
