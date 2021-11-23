package me.ahmed.repos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubApiResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<GithubRepo> items;

    public GithubApiResponse() {
    }

    public GithubApiResponse(List<GithubRepo> items) {
        this.items = items;
    }

    public List<GithubRepo> getItems() {
        return items;
    }

    public void setItems(List<GithubRepo> items) {
        this.items = items;
    }
}
