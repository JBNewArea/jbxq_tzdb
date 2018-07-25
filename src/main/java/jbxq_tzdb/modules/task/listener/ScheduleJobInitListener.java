package jbxq_tzdb.modules.task.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import jbxq_tzdb.core.utils.SpringContextHolder;
import jbxq_tzdb.modules.task.service.IScheduleJobService;

public class ScheduleJobInitListener implements ApplicationListener<ContextRefreshedEvent> {

	protected IScheduleJobService scheduleJobService = SpringContextHolder.getApplicationContext()
			.getBean(IScheduleJobService.class);

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		try {
			scheduleJobService.initSchedule();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}