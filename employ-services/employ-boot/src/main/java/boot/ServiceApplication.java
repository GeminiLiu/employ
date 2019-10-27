package boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * SpringBoot启动类
 * 放在boot包下，通过scanBasePackages和basePackages配置需要扫描的包
 * 默认配置如下，如有特殊需求可修改
 * 
 * 2018年5月15日
 * @author gotanks
 */
@SpringBootApplication(scanBasePackages = {"com.jagt", "db.single"})
@EnableDiscoveryClient
//@EnableFeignClients
//@EnableHystrix
//@EnableHystrixDashboard
@EnableCaching
public class ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}
	
//	@Bean
//	public ServletRegistrationBean<HystrixMetricsStreamServlet> getServlet() {
//		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
//		ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<HystrixMetricsStreamServlet>(streamServlet);
//		registrationBean.setLoadOnStartup(1);
//		registrationBean.addUrlMappings("/hystrix.stream");
//		registrationBean.setName("HystrixMetricsStreamServlet");
//		return registrationBean;
//	}
}
