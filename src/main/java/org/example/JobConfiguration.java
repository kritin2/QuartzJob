package org.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@Configuration
public class JobConfiguration {

    Logger logger = LoggerFactory.getLogger(getClass());

   @Bean
   public JobDetailFactoryBean artemisTokenRefreshJob(){

    JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
    jobDetailFactory.setJobClass(FirstJob.class);
    jobDetailFactory.setName("FIRST_JOB_DETAIL");
    jobDetailFactory.setDescription("Invoke Sample Job service...");
    jobDetailFactory.setDurability(true);
    return jobDetailFactory;
   }

   @Bean
     public CronTriggerFactoryBean artemisTokenRefreshJobTrigger(@Qualifier("artemisTokenRefreshJob") JobDetail job) {

        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
         trigger.setJobDetail(job);

         int frequencyInSec = 10;
         logger.info("Configuring trigger to fire every {} seconds", frequencyInSec);

         trigger.setCronExpression("0/10 * * * * ?");
         trigger.setName("Qrtz_Trigger");
         return trigger;
     }
}
