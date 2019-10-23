package com.skilldistillery.jobtracking.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobtracking.entities.IndeedListing;

@Service
public class IndeedListingServiceImpl implements IndeedListingService {

	
	@Override
	public List<IndeedListing> getJobs(String keyword, String city, String state) {
		List<IndeedListing> jobs = new ArrayList<>();
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet("https://www.indeed.com/jobs?q=" + keyword + "&l=" + city + "%2C+" + state + "&start=20");
		String regex = "<div class=\"title\">.+?href=\"([^\"]+).+?title=\"([^\"]+).+?<span class=\"company\">\\s+([^<]+).+?((href=\\\"\\\\/cmp\\\\/)?cmp\\/([^\"]+)|data-rc).+?loc=\"([^\"]+).+?<div class=\"summary\">\\s+([^<]+).+?>.+?>([^<]+)";
		try {
			HttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();

			String content = EntityUtils.toString(entity);

			final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.DOTALL);
			final Matcher matcher = pattern.matcher(content);


			while (matcher.find()) {
				IndeedListing listing = new IndeedListing();
			    for (int i = 1; i <= matcher.groupCount(); i++) {
			    
			    	System.out.println("Group " + i + ": " + matcher.group(i));
			    }
				listing.setUrl("https://www.indeed.com" + matcher.group(1));
				listing.setTitle(matcher.group(2));
				listing.setLocation(matcher.group(7));
				if (matcher.group(8).trim().length() > 10) {
					listing.setDescription(matcher.group(8));
				} else {
					listing.setDescription(matcher.group(9));
				}
				
				if (matcher.group(3).length() <= 1) {
					listing.setCompany(matcher.group(6));
				} else {
					listing.setCompany(matcher.group(3));
				}

				jobs.add(listing);
			}
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jobs;
	}

}
