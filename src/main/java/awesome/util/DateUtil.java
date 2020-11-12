package awesome.util;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Component
@Repository
public class DateUtil {
    public String formatLocalDateTimeToDatabaseStyle(LocalDateTime time){
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(time);
    }
}

