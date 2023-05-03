package sg.edu.nus.iss.workshop16.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;



@Configuration
public class RedisConfig {
    
    @Value("${spring.data.redis.host}")
    private String redisHost;

    @Value("${spring.data.redis.port}")
    private Optional<Integer> redisPort;

    @Value("${spring.data.redis.username}")
    private String redisUsername;

    @Value("${spring.data.redis.password}")
    private String redisPassword;

    @Bean
    @Scope("singleton")
    public RedisTemplate<String, Object> RedisTemplate(){
        
        final RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName(redisHost);
        config.setPort(redisPort.get());

        if(!redisUsername.isEmpty() && !redisPassword.isEmpty()){
            config.setUsername(redisUsername);
            config.setPassword(redisPassword);
        }
        config.setDatabase(0);

        // create client
        final JedisClientConfiguration
         jedisClient = JedisClientConfiguration.builder().build();
        // create factory
         final JedisConnectionFactory jedisFac = new JedisConnectionFactory(config, jedisClient);
         jedisFac.afterPropertiesSet();

         final RedisTemplate<String, Object> template = new RedisTemplate<>();
         template.setConnectionFactory(jedisFac);
         template.setKeySerializer(new StringRedisSerializer());   //convert Java input into String in redis
         template.setValueSerializer(template.getKeySerializer());
        return template;

    }

}
