package me.ahmed.repos.resources;


import me.ahmed.repos.models.GithubApiResponse;
import me.ahmed.repos.services.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class GithubReposResource {
    @Autowired
    private Environment env;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DateService dateService;

    private static final String DATE_FORMAT = "yyyy-MM-dd";

    public GithubApiResponse getGithubRepos() {
        String url = env.getProperty("github.api.base.url") + env.getProperty("github.api.created.before")
                + dateService.getStringDateBefore30Days(new SimpleDateFormat(DATE_FORMAT)) + env.getProperty("github.api.sort.and.order")
                + env.getProperty("github.api.per.page");
        return restTemplate.getForObject(url, GithubApiResponse.class);
    }
}
