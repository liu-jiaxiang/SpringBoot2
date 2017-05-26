package task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PrintTimeTask {

	private static final Logger log = LoggerFactory.getLogger(PrintTimeTask.class);
	
	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate = 5000)
	public void printCurrentTime() {
		System.out.println("The time is now {}" + simpleDateFormat.format(new Date()));
	}
}
