package io.github.lzx2005.tools;

import io.github.lzx2005.constants.FileLaction;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 测试文件根据包
 */
public class FileUtilsTest {

    /**
     * 测试文件读取是否正常
     */
    @Test
    public void read() {
        File file = new File(FileLaction.TEXT_FILE);
        assertTrue(file.exists());
        List<String> list = FileUtils.read(file);
        assertNotNull(list);
        assertTrue(list.size() > 0);
        list.forEach(System.out::println);
    }
}