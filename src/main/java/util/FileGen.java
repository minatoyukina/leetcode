package util;


import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ccq
 * @since 2021/3/8 10:53
 */
public class FileGen {

    @Test
    public void test() throws IOException {
        String path = "D:\\minato\\leetcode\\src\\main\\java";
        for (int i = 0; i < 60; i++) {
            String reg = "\\_" + (i * 50 + 1) + "__" + (i * 50 + 50);
            File f = new File(path + reg);
            if (!f.exists()) {
                System.out.println(f.mkdir());
            }
            String pre = f.getPath();
            for (int j = 1; j <= 50; j++) {
                File child = new File(pre + "\\_" + (i * 50 + j));
                if (!child.exists()) {
                    System.out.println(child.mkdir());
                    File file = new File(child.getPath() + "\\Demo01.java");
                    FileWriter fileWriter = new FileWriter(file);
                    String code = "package " +
                            child.getPath().replace(path, "").replace("\\", ".").substring(1) +
                            ";\n\n" +
                            "import org.junit.Test;\n" +
                            "\n" +
                            "public class Demo01 {\n" +
                            "\n" +
                            "\n" +
                            "    @Test\n" +
                            "    public void test() {\n" +
                            "\n" +
                            "    }\n" +
                            "    \n" +
                            "}";
                    System.out.println(code);
                    fileWriter.write(code);
                    fileWriter.flush();
                    fileWriter.close();
                }
            }
        }
    }
}
