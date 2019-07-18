package com.mybatis.data.file;

import java.io.*;
import java.util.ArrayList;

/**
 * @Description: 读取文件
 * @Author: ZX
 * @Date: 2019/7/18 10:35
 */
public class InputFile {

    /**
     * MyBatis 实体类路径
     */
    private final static String filePath = "D:\\GitHub\\test-service\\src\\main\\java\\com\\test\\base\\domain";
    /**
     * JPA实体类生成路径
     */
    private final static String newPath = "src\\main\\java\\com\\mybatis\\data\\jpa\\";

    public static void main(String[] args) {
        readFile(filePath);
    }

    /**
     * 递归读取文件
     *
     * @param readPath
     */
    public static void readFile(String readPath) {
        File path = new File(readPath);
        File[] files = path.listFiles();
        assert files != null;
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println(file.getParent());
                readFile(file.getAbsolutePath());
            }
            if (file.isFile()) {
                System.out.println("  -- " + file.getName());
                disposeFile(file);
            }
        }
    }

    /**
     * 输出文件
     *
     * @param fileName
     * @param txt
     */
    public static void writeFile(String fileName, ArrayList<String> txt) {
        try {
            File file = new File(newPath + fileName);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            for (String line : txt) {
                bw.write(line);
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 处理文件
     *
     * @param file
     */
    public static void disposeFile(File file) {
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            ArrayList<String> list = new ArrayList<>();
            list.add("package com.mybatis.data.jpa;");
            list.add("import javax.persistence.Column;");
            list.add("import javax.persistence.Entity;");
            list.add("import javax.persistence.Id;");
            list.add("import javax.persistence.Table;");

            // 读取行
            String line;
            // 字段注释
            String note = "";
            // 记录主键出现的位置
            int i = 0;
            while (true) {
                line = br.readLine();
                // 跳过原有包路径
                if (line.contains("package")) {
                    continue;
                }

                // 加入注解
                if (line.contains("class")) {
                    // 截取类名
                    String trim = line.substring(line.indexOf("class") + 6, line.indexOf("implements")).trim();
                    list.add("@Entity");
                    list.add("@Table(name=\"" + upperOrLower(trim) + "\")");
                }

                // 提取中文注释
                if (isChinese(line)) {
                    if (line.contains("*")) {
                        note = line.substring(line.indexOf("*") + 1).trim();
                    }
                }

                // 字段注解
                if (line.contains("private")) {
                    i++;
                    // 主键注解（一般第一个字段为主键）
                    if (i == 1) {
                        list.add("    @Id");
                        if (line.contains(" Integer ")) {
                            list.add("    @Column(columnDefinition = \"int not null Comment '" + note + "'\")");
                        }
                        if (line.contains(" Long ")) {
                            list.add("    @Column(columnDefinition = \"bigint not null Comment '" + note + "'\")");
                        }
                        if (line.contains(" String ")) {
                            list.add("    @Column(columnDefinition = \"varchar(64) not null Comment '" + note + "'\")");
                        }
                    } else { // 非主键注解
                        if (line.contains(" Integer ")) {
                            list.add("    @Column(columnDefinition = \"int Comment '" + note + "'\")");
                        }
                        if (line.contains(" Long ")) {
                            list.add("    @Column(columnDefinition = \"bigInt Comment '" + note + "'\")");
                        }
                        if (line.contains(" BigDecimal ")) {
                            list.add("    @Column(columnDefinition = \"decimal(16, 2) Comment '" + note + "'\")");
                        }
                        if (line.contains(" String ")) {
                            list.add("    @Column(columnDefinition = \"varchar(256) Comment '" + note + "'\")");
                        }
                        if (line.contains(" Date ")) {
                            list.add("    @Column(columnDefinition = \"datetime Comment '" + note + "'\")");
                        }
                    }
                }

                // 忽略get set toString equals hashCode 等方法
                if (line.contains("public") && !line.contains("class")) {
                    break;
                }

                list.add(line);
            }

            list.add("}");

            // 输出文件
            writeFile(file.getName(), list);

            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断一个字符串是否含有中文
     *
     * @param str
     * @return
     */
    public static boolean isChinese(String str) {
        if (str == null) {
            return false;
        }
        for (char c : str.toCharArray()) {
            // 有一个中文字符就返回
            if (isChinese(c)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断一个字符是否是中文
     *
     * @param c
     * @return
     */
    public static boolean isChinese(char c) {
        // 根据字节码判断
        return c >= 0x4E00 && c <= 0x9FA5;
    }

    /**
     * 判断字母大小写，并拼接表名
     *
     * @param str
     * @return
     */
    public static String upperOrLower(String str) {
        StringBuilder tableName = new StringBuilder();
        for (int j = 0; j < str.length(); j++) {
            char chr = str.charAt(j);
            // 如果是大写，则转小写并添加下划线（首字母除外）
            if (Character.isUpperCase(chr)) {
                if (j == 0) {
                    tableName.append(Character.toLowerCase(chr));
                } else {
                    tableName.append("_");
                    tableName.append(Character.toLowerCase(chr));
                }
            } else if (Character.isLowerCase(chr)) {
                tableName.append(chr);
            }
        }
        return tableName.toString();
    }
}
