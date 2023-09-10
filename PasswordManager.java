import java.util.Scanner;

public class PasswordManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("密码管理系统");
            System.out.println("1. 加密密码");
            System.out.println("2. 解密密码");
            System.out.println("3. 判断密码强度");
            System.out.println("4. 生成密码");
            System.out.println("5. 退出");
            System.out.print("请选择操作：");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("请输入要加密的密码：");
                    scanner.nextLine(); // Consume newline
                    String passwordToEncrypt = scanner.nextLine();
                    String encryptedPassword = encryptPassword(passwordToEncrypt);
                    System.out.println("加密后的密码：" + encryptedPassword);
                    break;
                case 2:
                    System.out.print("请输入要解密的密码：");
                    scanner.nextLine(); // Consume newline
                    String passwordToDecrypt = scanner.nextLine();
                    String decryptedPassword = decryptPassword(passwordToDecrypt);
                    System.out.println("解密后的密码：" + decryptedPassword);
                    break;
                case 3:
                    System.out.print("请输入要判断强度的密码：");
                    scanner.nextLine(); // Consume newline
                    String passwordToCheck = scanner.nextLine();
                    int strength = checkPasswordStrength(passwordToCheck);
                    System.out.println("密码强度： " + strength);
                    break;
                case 4:
                    String generatedPassword = generatePassword();
                    System.out.println("生成的密码：" + generatedPassword);
                    break;
                case 5:
                    System.out.println("感谢使用密码管理系统，再见！");
                    System.exit(0);
                default:
                    System.out.println("无效的选项，请重新选择。");
            }
        }
    }

    // 加密密码
    public static String encryptPassword(String password) {
        StringBuilder encryptedPassword = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            char c = (char) (password.charAt(i) + i + 3);
            encryptedPassword.append(c);
        }
        encryptedPassword.reverse();
        encryptedPassword = new StringBuilder(encryptedPassword.charAt(encryptedPassword.length() - 1)
                + encryptedPassword.substring(1, encryptedPassword.length() - 1) + encryptedPassword.charAt(0));
        return encryptedPassword.toString();
    }

    // 解密密码
    public static String decryptPassword(String encryptedPassword) {
        encryptedPassword = encryptedPassword.substring(encryptedPassword.length() - 1)
                + encryptedPassword.substring(1, encryptedPassword.length() - 1) + encryptedPassword.charAt(0);
        StringBuilder decryptedPassword = new StringBuilder(encryptedPassword).reverse();
        for (int i = 0; i < decryptedPassword.length(); i++) {
            char c = (char) (decryptedPassword.charAt(i) - i - 3);
            decryptedPassword.setCharAt(i, c);
        }
        return decryptedPassword.toString();
    }

    // 判断密码强度
    public static int checkPasswordStrength(String password) {
        int length = password.length();
        if (length < 8) {
            return 1;
        } else if (length < 12) {
            return 2;
        } else {
            return 3;
        }
    }

    // 生成密码
    public static String generatePassword() {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int randomChar = (int) (Math.random() * 62); // 0-61的随机数
            char c;
            if (randomChar < 10) {
                c = (char) ('0' + randomChar);
            } else if (randomChar < 36) {
                c = (char) ('a' + randomChar - 10);
            } else {
                c = (char) ('A' + randomChar - 36);
            }
            password.append(c);
        }
        return password.toString();
    }
}
