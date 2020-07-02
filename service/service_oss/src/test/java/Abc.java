import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author 乐心湖
 * @date 2020/6/30 22:50
 **/
public class Abc {
    @Test
    public void test1(){
        String localDate= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println(localDate);
    }
}
