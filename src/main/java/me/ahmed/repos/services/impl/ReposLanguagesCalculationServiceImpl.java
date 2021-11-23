package me.ahmed.repos.services.impl;

import me.ahmed.repos.models.GithubRepo;
import me.ahmed.repos.models.Language;
import me.ahmed.repos.models.LanguagesResponse;
import me.ahmed.repos.services.ReposLanguagesCalculationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ReposLanguagesCalculationServiceImpl implements ReposLanguagesCalculationService {
    @Override
    public LanguagesResponse getCalculatedLanguages(Set<String> languages, List<GithubRepo> githubRepos) {
        LanguagesResponse languagesResponse = new LanguagesResponse();
        languagesResponse.setLanguageList(new ArrayList<>());
        languages.forEach(languageName -> {
            if(languageName != null) {
                Language languageObject = new Language();
                populateLanguageData(languageObject, languageName, githubRepos);
                languagesResponse.getLanguageList().add(languageObject);
            }
        });
        return languagesResponse;
    }

    private void populateLanguageData(Language languageObject, String languageName, List<GithubRepo> githubRepos) {
        languageObject.setLanguageName(languageName);
        languageObject.setNumberOfOccurences(0);
        languageObject.setReposNames(new HashSet<>());
        githubRepos.forEach(githubRepo -> {
            if (languageName.equalsIgnoreCase(githubRepo.getLanguage())) {
                languageObject.getReposNames().add(githubRepo.getName());
                languageObject.setNumberOfOccurences(languageObject.getNumberOfOccurences() + 1);
            }
        });
        githubRepos.removeIf(githubRepo -> languageObject.getLanguageName().equalsIgnoreCase(githubRepo.getLanguage()));
    }



}
