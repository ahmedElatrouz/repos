package me.ahmed.repos.models;

import java.util.Set;

public class Language {

    private String languageName;
    private long numberOfOccurences;
    private Set<String> reposNames;

    public Language() {
    }

    public long getNumberOfOccurences() {
        return numberOfOccurences;
    }

    public Set<String> getReposNames() {
        return reposNames;
    }

    public void setNumberOfOccurences(long numberOfOccurences) {
        this.numberOfOccurences = numberOfOccurences;
    }

    public void setReposNames(Set<String> reposNames) {
        this.reposNames = reposNames;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }
}
