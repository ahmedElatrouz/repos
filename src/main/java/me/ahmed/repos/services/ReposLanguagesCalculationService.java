package me.ahmed.repos.services;

import me.ahmed.repos.models.GithubRepo;
import me.ahmed.repos.models.LanguagesResponse;

import java.util.List;
import java.util.Set;

public interface ReposLanguagesCalculationService {

    LanguagesResponse getCalculatedLanguages(Set<String> laguages, List<GithubRepo> githubRepos);
}
