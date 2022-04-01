package com.milan.demo.zip.service;

import java.util.Date;
import java.util.List;

import com.milan.demo.zip.model.UsageStatistics;

/**
 * On each request to API method addData will be called. 
 * 
 * @author Milan
 *
 */
public interface StatisticsService {

	
	/**
	 * Add data abuout usage statistics for a given IP and given Date.
	 * It will increase count on Statistics entity for the given IP and date.
	 * @param ip
	 * @param date
	 * @param interactions
	 */
	public void addData(String ip, Date date, int interactions);
	
	/**
	 * Obtains UsageData object for a given IP and date
	 * @param ip
	 * @param date
	 * @return
	 */
	public UsageStatistics getStatisticsForIpAndDate(String ip, Date date);
	
	/**
	 * Obtains List of UsageStatistics objects for specific date
	 * @param date
	 * @return
	 */
	public List<UsageStatistics> getStatisticsForDate(Date date);
	
	/**
	 * Obtains LIst of UsageStatistics objects for specific IP
	 * @param ip
	 * @return
	 */
	public List<UsageStatistics> getStatisticsForIp(String ip);
}
