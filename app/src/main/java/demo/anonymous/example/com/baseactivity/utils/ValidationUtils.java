package demo.anonymous.example.com.baseactivity.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Anonymous on 2017/6/7.
 */

public class ValidationUtils {
    /**
     * java验证手机号
     *
     * @param mobile
     */
    public static boolean checkMobile(String mobile) {
        Pattern p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
        Matcher m = p.matcher(mobile);
        return m.matches();
    }

    /**
     * 验证Email
     * 格式：zhangsan@zuidaima.com，zhangsan@xxx.com.cn，xxx代表邮件服务商
     *
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkEmail(String email) {
        String regex = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?";
        return Pattern.matches(regex, email);
    }

    /**
     * 验证身份证号码
     *
     * @param idCard 居民身份证号码15位或18位，最后一位可能是数字或字母
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkIdCard(String idCard) {
        String regex = "[1-9]\\d{13,16}[a-zA-Z0-9]{1}";
        return Pattern.matches(regex, idCard);
    }

    /**
     * 验证中文
     *
     * @param chinese 中文字符
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkChinese(String chinese) {
        String regex = "^[\u4E00-\u9FA5]+$";
        return Pattern.matches(regex, chinese);
    }

    /**
     * 验证日期（年月日）
     *
     * @param birthday 日期，格式：1992-09-03，或1992.09.03
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkBirthday(String birthday) {
        String regex = "[1-9]{4}([-./])\\d{1,2}\\1\\d{1,2}";
        return Pattern.matches(regex, birthday);
    }

    /**
     * 匹配IP地址
     * <p>
     * 如：192.168.1.1，127.0.0.1，没有匹配IP段的大小
     *
     * @param ipAddress IPv4标准地址
     * @return 验证成功返回true，验证失败返回false
     */
    public static boolean checkIpAddress(String ipAddress) {
        String regex = "[1-9](\\d{1,2})?\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))";
        return Pattern.matches(regex, ipAddress);
    }

}
