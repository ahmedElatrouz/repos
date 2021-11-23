package me.ahmed.repos.controllers;

import me.ahmed.repos.models.GithubApiResponse;
import me.ahmed.repos.models.LanguagesResponse;
import me.ahmed.repos.resources.GithubReposResource;
import me.ahmed.repos.services.ReposLanguagesCalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/repos")
public class GithubReposController {

    @Autowired
    private GithubReposResource githubReposResource;

    @Autowired
    private ReposLanguagesCalculationService reposLanguagesCalculationService;

    @GetMapping("/top-100-languages")
    public LanguagesResponse fetchGithubRepos() {
        LanguagesResponse languagesResponse = null;
        try {
            GithubApiResponse response = githubReposResource.getGithubRepos();
            Set<String> languages = response.getItems().stream().map(githubRepo -> githubRepo.getLanguage()).collect(Collectors.toSet());
            languagesResponse = reposLanguagesCalculationService.getCalculatedLanguages(languages, response.getItems());
        } catch (RestClientException e) {
            e.printStackTrace();
        }
        return languagesResponse;
    }
}
