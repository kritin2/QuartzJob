package org.example;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class FirstJob implements Job{
    private static final Logger logger = LoggerFactory.getLogger( FirstJob.class );

    @Override
    public void execute(JobExecutionContext context) {
        logger.info( "Scheduler output: " + ZonedDateTime.now().toString() );
    }
}
