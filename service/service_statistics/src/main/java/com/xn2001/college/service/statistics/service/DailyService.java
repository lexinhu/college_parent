package com.xn2001.college.service.statistics.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xn2001.college.service.statistics.entity.Daily;

import java.util.Map;

/**
 * <p>
 * 网站统计日数据 服务类
 * </p>
 *
 * @author 乐心湖
 * @since 2020-08-05
 */
public interface DailyService extends IService<Daily> {
    void createStatisticsByDay(String day);

    Map<String, Map<String, Object>> getChartData(String begin, String end);
}
