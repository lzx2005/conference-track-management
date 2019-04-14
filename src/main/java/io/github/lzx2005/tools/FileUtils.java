package io.github.lzx2005.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件工具
 * @author Li Zhengxian
 */
public class FileUtils {

    /**
     * 读取文件
     * @param file
     * @return
     */
    public List<String> read(File file){
        ArrayList<String> strings = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                strings.add(line);
            }
            reader.close();
            return strings;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

}
