package com.xtt.ids;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IdsApplicationTests {

    public static List<String> fileStreamToString() throws IOException {
        String msg = "";
        File file = new File("D:\\Code\\ioTest\\logBroadcastFiles.log");
        List<String> dataList = new ArrayList<>();
        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            int line = 0;
            String str;
            while (true) {
                str = bufferedReader.readLine();
                if (str != null) {
                    if (line < 1000) {
                        line++;
                    } else {
                        dataList.add(msg);
                        msg = "";
                        line = 0;
                    }
                    msg += str;
                } else {
                    dataList.add(msg);
                    break;
                }
            }
        }
        return dataList;
    }
    @Test
    public void contextLoads() throws IOException {
        List<String> list = IdsApplicationTests.fileStreamToString();

    }

}
