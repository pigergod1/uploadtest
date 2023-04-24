package team3.meowie.crawler.ip.model;

import org.springframework.stereotype.Component;

@Component
public class Ip {

	private String ip;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Ip() {

	}

}
