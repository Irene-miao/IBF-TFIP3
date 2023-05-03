package sg.edu.nus.iss.day19.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import sg.edu.nus.iss.day19.model.Love;


@Service
public class LoveService {
    

  // set cmd variable value to here
    @Value("${spring.data.api.url}")
    private String loveApiUrl;

    @Value("${spring.data.api.key}")
    private String loveApiKey;

    @Value("${spring.data.api.host}")
    private String loveApiHost;

    @Autowired
    @Qualifier("lovecount")
    private RedisTemplate<String, Object> redisTemplate;

    
    String fsname;
    String sname; 
    
        
        public Optional<Love> count(Love love) throws IOException {
            fsname=love.getFsname().toLowerCase();  
            sname=love.getSname().toLowerCase(); 
            String loveCountUrl = UriComponentsBuilder
            .fromUriString(loveApiUrl)
            .queryParam("fsname", fsname)
            .queryParam("sname", sname)
            .toUriString();
            RestTemplate template = new RestTemplate();
            ResponseEntity<String> resp = null;
            HttpHeaders headers = new HttpHeaders();

            headers.set("X-RapidAPI-Key", loveApiKey);
            headers.set("X-RapidAPI-Host", loveApiHost);
            HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
            resp = template.exchange(loveCountUrl, HttpMethod.GET, requestEntity, String.class);
            Love l = Love.create(resp.getBody());
            if (l != null) {
                redisTemplate.opsForValue().set(l.getId(), resp.getBody().toString());
                return Optional.of(l);
            }
            return Optional.empty();
        }
    
        
    }

