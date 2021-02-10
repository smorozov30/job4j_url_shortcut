package ru.job4j.url_shortcut.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.url_shortcut.domian.Site;

import java.util.Map;
import java.util.Optional;

public interface SiteRepository extends CrudRepository<Site, Integer> {

    Optional<Site> findSiteByLogin(String login);

    Optional<Site> findSiteByName(String name);
}
