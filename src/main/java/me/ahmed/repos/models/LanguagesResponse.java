package me.ahmed.repos.models;

import java.util.List;

public class LanguagesResponse {

    private List<Language> languageList;

    public LanguagesResponse() {
    }

    public List<Language> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(List<Language> languageList) {
        this.languageList = languageList;
    }
}
