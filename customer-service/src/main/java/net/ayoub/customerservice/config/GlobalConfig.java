package net.ayoub.customerservice.config;


import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@ConfigurationProperties(prefix = "global.params")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
public class GlobalConfig {
    private int p1;
    private int p2;
}
