package jbxq_tzdb.modules.task.utils;

import jbxq_tzdb.modules.task.entity.ScheduleJob;

public class ScheduleJobUtils {
     public static jbxq_tzdb.core.quartz.data.ScheduleJob entityToData(ScheduleJob scheduleJobEntity){
    	 jbxq_tzdb.core.quartz.data.ScheduleJob scheduleJob=new jbxq_tzdb.core.quartz.data.ScheduleJob();
    	 scheduleJob.setBeanClass(scheduleJobEntity.getBeanClass());
    	 scheduleJob.setCronExpression(scheduleJobEntity.getCronExpression());
    	 scheduleJob.setDescription(scheduleJobEntity.getDescription());
    	 scheduleJob.setIsConcurrent(scheduleJobEntity.getIsConcurrent());
    	 scheduleJob.setJobName(scheduleJobEntity.getJobName());
    	 scheduleJob.setJobGroup(scheduleJobEntity.getJobGroup());
    	 scheduleJob.setJobStatus(scheduleJobEntity.getJobStatus());
    	 scheduleJob.setMethodName(scheduleJobEntity.getMethodName());
    	 scheduleJob.setSpringBean(scheduleJobEntity.getSpringBean());
    	 return scheduleJob;
     }
}
